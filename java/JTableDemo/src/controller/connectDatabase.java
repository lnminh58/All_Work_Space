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
import javax.swing.JOptionPane;

/**
 *
 * @author nguyenducthao
 */
public class connectDatabase {

    static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    static final String DB_URL = "jdbc:sqlserver://localhost;";
    static final String DATABASENAME = "databaseName=DBstudent;";
    static final String USER = "user=sa;";
    static final String PASS = "password=ngocminh58";

    public static void getConnectDatabase() throws SQLException {
        Connection conn = null;
        try {

            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL + USER + PASS);
        } catch (ClassNotFoundException | SQLException ex) {
//            Logger.getLogger(connectDatabase.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Can't connect to database. Please contact administrator!", "Message Dialog", JOptionPane.INFORMATION_MESSAGE);
        }
//            Logger.getLogger(connectDatabase.class.getName()).log(Level.SEVERE, null, ex);
         finally {
            if (conn != null) {
                conn.close();
            }
        }
//        return conn;
    }

    public static Connection getConnectTable() throws SQLException {
        Connection conn = null;
        try {

            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL + DATABASENAME + USER + PASS);
        } catch (ClassNotFoundException | SQLException ex) {
//            Logger.getLogger(connectDatabase.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Can't connect to database. Please contact administrator!", "Message Dialog", JOptionPane.INFORMATION_MESSAGE);
        }
//            Logger.getLogger(connectDatabase.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            if (conn != null) {
//                conn.close();
//            }
        return conn;
    }
}
