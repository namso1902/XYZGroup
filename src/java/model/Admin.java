/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author namso1902
 */
public class Admin {
    
    //Status constants
    public static final String approved = "APPROVED";
    public static final String applied = "APPLIED";
    public static final String suspended = "SUSPENDED";
    //Members array
    //ArrayList<Member> mbs = new ArrayList<Member>();
    //login details
    String username, password;
    String status;
    PreparedStatement pstmt;
    //initialise dbConnection
    Jdbc dbConn = new Jdbc();
    Connection con = dbConn.connect();

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
        status = "Admin";
    }
    
    public void addAdmin() throws SQLException {
        pstmt = con.prepareStatement("INSERT INTO users VALUES(?,?,?)");
        pstmt.setString(1, username);
        pstmt.setString(2, password);
        pstmt.setString(3, status);
    }
    
    public static ResultSet getMember(String name) {
        Jdbc dbConn = new Jdbc();
        Connection con = dbConn.connect();
        ResultSet getMember = null;
        String sql_get_member = "SELECT * FROM members WHERE name = " + name;
        try {
            getMember = dbConn.executeQuery(sql_get_member);
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return getMember;
    }
    
    
    public static ResultSet getAllMembers() {
        Jdbc dbConn = new Jdbc();
        Connection con = dbConn.connect();
        ResultSet members = null;
        String sql_get_all_members = "SELECT * FROM members";
        try {
            members = dbConn.executeQuery(sql_get_all_members);
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return members;
    }
    
    //get all outstanding approvals
     public ResultSet getAllOutstdClaims() {
        ResultSet oustandingBalances = null;
        String sql_outstanding_balances = "SELECT * FROM claims WHERE "
                + "status = APPLIED";
        try {
            oustandingBalances = dbConn.executeQuery(sql_outstanding_balances);
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return oustandingBalances;
    }
    
    public ResultSet gettAllClaims() {
        ResultSet claims = null;
        String sql_get_all_claims = "SELECT * FROM claims";
        try {
            claims = dbConn.executeQuery(sql_get_all_claims);
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return claims;
    }
    
    public static ResultSet getTotalIncome() throws SQLException {
        Jdbc dbConn = new Jdbc();
        Connection con = dbConn.connect();
        ResultSet totalIncome = null;
        String sql_get_total_income = "SELECT SUM(amount) FROM payments";
        try {
            totalIncome = dbConn.executeQuery(sql_get_total_income);
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        dbConn.close();
        return totalIncome;
    }
    
    public static ResultSet gettTotalPayouts() throws SQLException {
        Jdbc dbConn = new Jdbc();
        Connection con = dbConn.connect();
        ResultSet totalPayouts = null;
        String sql_get_total_payouts = "SELECT SUM(amount) FROM claims WHERE "
                + "status = APPROVED";
        try {
            totalPayouts = dbConn.executeQuery(sql_get_total_payouts);
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        dbConn.close();
        return totalPayouts;
    }
    
    //Return annual charge for each member
    public static ResultSet getAllMembersCharge() {
        Jdbc dbConn = new Jdbc();
        Connection con = dbConn.connect();
        ResultSet rs_totalPayouts = gettTotalPayouts();
    }
    
    //Approve claim - APPROVED/REJECTED
    public boolean assessClaim(String id) throws SQLException {
        //Get all member claims
        ResultSet member_claims = null;
        boolean approveClaim = false;
        String sql_update_claim;
        String status;
        String sql_get_all_member_claims = "SELECT * FROM claims WHERE id = " + 
                id;
        try {
            member_claims = dbConn.executeQuery(sql_get_all_member_claims);
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Get user status via id
        String sql_get_status = "SELECT status FROM users WHERE id = " + id;
        ResultSet userStatus = dbConn.executeQuery(sql_get_status);
        status = userStatus.getString(1);
        //approve or reject claim. Conditions: less than 2 claims, full member
        if ((getResultSetSize(member_claims) < 2) && 
                (status.matches(approved))) {
            //approve claim status
            sql_update_claim = "UPDATE claim SET status = APPROVED" +   
            " WHERE id = " + id;
            approveClaim = true;
        }
        else {
            //reject claim status
            sql_update_claim = "UPDATE claim SET status = REJECTED" +   
            " WHERE id = " + id;
            approveClaim = false;
        }
        
        dbConn.executeQuery(sql_update_claim);
        return approveClaim;
    }
    
    
    
    public void chargeMember(String id) throws SQLException {
        //change status in users table to 'APPROVED'
        float balance = 0;
        String sql_get_user = "SELECT status FROM users WHERE id = " + id;
        ResultSet user = dbConn.executeQuery(sql_get_user);
        //Get the members balance.
        String sql_get_balance = "SELECT balance FROM members WHERE id = " + id;
        ResultSet rs_balance = dbConn.executeQuery(sql_get_balance);
        balance = rs_balance.getFloat(1);
        if (balance < 10) {
            suspendMembership(id);
        }
        else {
            approveMembership(id);
        }
    } 
    
    //change status field to 'suspended'
    public static void suspendMembership(String id) throws SQLException {
        Jdbc dbConn = new Jdbc();
        Connection con = dbConn.connect();
        String sql_suspend_member = "UPDATE users SET status = SUSPENDED" +   
            " WHERE id = " + id;
        try {
            dbConn.executeQuery(sql_suspend_member);
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        dbConn.close();
    }
    
    //change membership from suspended/applied to approved.
    public void approveMembership(String id) {
        String sql_suspend_member = "UPDATE users SET status = APPROVED" +   
            " WHERE id = " + id;
        try {
            dbConn.executeQuery(sql_suspend_member);
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int getResultSetSize(ResultSet rs) throws SQLException {
        int size = 0;
        if (rs.last()) {
            size = rs.getRow();
            rs.beforeFirst();
        }
        return size;
    }
}
