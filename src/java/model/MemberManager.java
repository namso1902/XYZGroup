/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author namso1902
 */
public class MemberManager {
    
    public static String generatePassword(Date d) {
        Format formatter = new SimpleDateFormat("dd-MM-yyyy");
        String password = formatter.toString();
        return password;
    }
    
    //Check the users login details
    public static int checkLogin(String username, String password) {
        int correct= 0; //
        Jdbc dbConn = new Jdbc();
        Connection con = dbConn.connect();
        String sql_userName = "SELECT * FROM users WHERE id = " + username;
        try {
            ResultSet rs = dbConn.executeQuery(sql_userName);
        } catch (SQLException ex) {
            Logger.getLogger(MemberManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return correct;
    }
    
}
