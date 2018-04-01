/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lnmin
 */
public class DBManager {
    static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    static final String DB_URL = "jdbc:sqlserver://localhost;";
    static final String DATABASENAME = "databaseName=QLKH;";
    static final String USER = "user=sa;";
    static final String PASS = "password=ngocminh58";
    static Connection conn;
    static Statement stmt;
    public static boolean checkExitsDatabase(){
        Connection conn=null;
        boolean checker= false;
        try {
            conn=DriverManager.getConnection(DB_URL+DATABASENAME+USER+PASS);
            checker=true;
            conn.close();
        } catch (SQLException ex) {
            
        }finally{
            try {
                if(conn!=null)
                conn.close();
            } catch (SQLException ex) {
            }
        }
        return checker;
    }
    
    public static void creatConnect(){
        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("Connecting to server -------->");
            conn = DriverManager.getConnection(DB_URL+USER+PASS);
            System.out.println("Connect success");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void createDataBase(){
        try {
            stmt = conn.createStatement();
            String sql= "CREATE DATABASE " + DATABASENAME.substring(DATABASENAME.indexOf("=")+1);
            stmt.executeUpdate(sql);
            System.out.println("Database created successfully...");
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public static void main(String[] args) {
        creatConnect();
        if (checkExitsDatabase()) {
            System.out.println("Database already exits");
        }else{
            System.out.println("Database's name is valid, creating database ...");
            createDataBase();
        }
    }
}
