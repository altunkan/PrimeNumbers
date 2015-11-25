/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.kocaeli.blm307.connection;

import edu.kocaeli.blm307.utility.PrimeAppConstants;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author AnilAltunkan
 */
public class XeConnection {
    
    public Connection getConnection()
    {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Failed to load oracle.jdbc.driver.OracleDriver:"+ex.getMessage());
            return null;
        }
        
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(PrimeAppConstants.ORACLE_CONSTRING, PrimeAppConstants.ORACLE_CONUSERNAME, PrimeAppConstants.ORACLE_CONPASSWORD);
        } catch (SQLException e) {
            System.out.println("Connection Failed!:"+e.getMessage());
            return null;
        }

        return connection;
    }    
}
