/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
//BOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO
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

    public Member(String firstName, String lastName, String address, Date dob, Date dateOfReg) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.dob = dob;
        this.dateOfReg = dateOfReg;
    }
    
    public int checkBalance() {
        int balance = 0;
        return balance;
    }
    
    public void makePayment() {
        
    }
    
    public void submitClaim() {
        
    }
    
    public void listAllClaimsAndPaymnts() {
        
    }
}
