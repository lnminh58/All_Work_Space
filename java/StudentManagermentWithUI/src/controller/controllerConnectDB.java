/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nguyenducthao
 */
public class controllerConnectDB {

    public static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public static final String DB_URL = "jdbc:sqlserver://localhost;";
    public static final String DATABASENAME = "databaseName=studentmanagerment;";
    public static final String USER = "user=sa;";
    public static final String PASS = "password=123";

    public static Connection connectDB() throws ClassNotFoundException {
        Connection conn = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL + USER + PASS);
        } catch (SQLException ex) {
            Logger.getLogger(controllerConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        return conn;
    }

    public static Connection connectTable() throws ClassNotFoundException {
        Connection conn = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL + DATABASENAME + USER + PASS);
        } catch (SQLException ex) {
            Logger.getLogger(controllerConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        return conn;
    }
}
