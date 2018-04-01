/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author nguyenducthao
 */
public class connectDatabase {

    static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    static final String DB_URL = "jdbc:sqlserver://localhost;";
    static final String DATABASENAME = "databaseName=UploadThePracticeTest;";
    static final String USER = "user=sa;";
    static final String PASS = "password=123";

    public static void getConnectDatabase() throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        try {

            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL + USER + PASS);
        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(connectDatabase.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Can't connect to database. Please contact administrator!", "Message Dialog", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
//            Logger.getLogger(connectDatabase.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Can't connect to database. Please contact administrator!", "Message Dialog", JOptionPane.INFORMATION_MESSAGE);
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
//        return conn;
    }

    public static Connection getConnectTable() throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        try {

            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL + DATABASENAME + USER + PASS);
        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(connectDatabase.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Can't connect to database. Please contact administrator!", "Message Dialog", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
//            Logger.getLogger(connectDatabase.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Can't connect to database. Please contact administrator!", "Message Dialog", JOptionPane.INFORMATION_MESSAGE);
//        } finally {
//            if (conn != null) {
//                conn.close();
//            }
        }
        return conn;
    }
}
