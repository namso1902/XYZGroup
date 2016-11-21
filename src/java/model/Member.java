/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author namso1902
 */
public class Member {

    //class parameters (first commit)    
    String firstName, lastName;
    String address;
    Date dob;
    Date dateOfReg;
    int balance;
    boolean paymentMade;
    Jdbc dbConn;
    

    public Member(String firstName, String lastName, String address, Date dob, Date dateOfReg) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.dob = dob;
        this.dateOfReg = dateOfReg;
        String sql_addMember = "INSERT INTO xyz_assoc  (ID,NAME,AGE,ADDRESS,SALARY)\n" +
            "VALUES (1, 'Ramesh', 32, 'Ahmedabad', 2000.00 );";
    }
    
    public int checkBalance() {
        int balance = 0;
        String sql_get_balance = "S";
        return balance;
    }
    
    public void makePayment() {
        String sql_addPayment = "";
    }
    
    public void submitClaim() {
        
    }
    
    public void listAllClaims() {
        ResultSet claims;
        String sql_get_claims = "";
        try {
            claims = dbConn.executeQuery(sql_get_claims);
        } catch (SQLException ex) {
            Logger.getLogger(Member.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void listAllPayments() {
        
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Date getDateOfReg() {
        return dateOfReg;
    }

    public void setDateOfReg(Date dateOfReg) {
        this.dateOfReg = dateOfReg;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
    
    
}
