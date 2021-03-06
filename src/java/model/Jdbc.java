/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level; 
import java.util.logging.Logger;

/**
 *
 * @author namso1902
 */
public class Jdbc {
    
    //db connection, statement and results
    Connection connection;
    Statement statement;
    ResultSet rs;
    //String query = null;

    public Jdbc() {
        String db = "xyz_assoc";
                try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection
                ("jdbc:mysql://localhost:3306/"+db.trim(), "root", "");
        }
        catch(ClassNotFoundException cfe){        
        }
        //SQL exception
        catch (SQLException ex) {
            Logger.getLogger(Jdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //open connection to database
    public Connection connect(){
        return connection;
    }
    
    //execute mysql queryS
    public ResultSet executeQuery(String sql_query) throws SQLException {
        statement = null;
        statement = connection.createStatement();
        rs = statement.executeQuery(sql_query);
        return rs;
    }
    
    //close connection to database
    //destroy any remaining objects
    public void close() throws SQLException{
        statement.close();
        rs.close();
        connection.close();
    }
    
}
