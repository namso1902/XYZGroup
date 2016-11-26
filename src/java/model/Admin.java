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
    
    //Members array
    ArrayList<Member> mbs = new ArrayList<Member>();
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
    
    public Member getMember(String name) {
        Member m = null;
        return m;
    }
    
    public void getAllMembers() {
        ResultSet members = null;
        String sql_get_all_claims = "SELECT * FROM claims";
    }
    
    public void listAllOutstdBalances() {
        
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
    
    public void listTotalIncome() {
        
    }
    
    public void listTotalPayouts() {
        
    }
    
    public void suspendMembership() {
        
    }
    
    //change membership from suspended/applied to approved.
    public void approveMembership() {
        
    }
}
