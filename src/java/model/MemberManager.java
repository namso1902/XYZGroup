/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
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
    public static ResultSet checkLogin(String username, String password) throws SQLException {
        int correct= 0; //
        Jdbc dbConn = new Jdbc();
        Connection con = dbConn.connect();
        //boolean passwordCheck = false;
        ResultSet rs = null;
        String sql_userName = "SELECT * FROM users WHERE id = " + username;
        try {
            rs = dbConn.executeQuery(sql_userName);
        } catch (SQLException ex) {
            Logger.getLogger(MemberManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        //check that username exists
        return rs;
    }
    
    public static Date getCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
        Date date = new Date();
        return date;
    }
    
    public static Date StringToDate(String strDate) {
        Date date = null;
        DateFormat format = new SimpleDateFormat("dd-mm-yyyy", Locale.ENGLISH);
        try {
            date = format.parse(strDate);
        } catch (ParseException ex) {
            Logger.getLogger(MemberManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return date;
    }
    
    //Get a member
    public ResultSet getMember(String userId) {
        ResultSet member = null;
        String sql_get_member = "SELECT * FROM members WHERE id = " + userId;
        
        return member;
    }
    
}
