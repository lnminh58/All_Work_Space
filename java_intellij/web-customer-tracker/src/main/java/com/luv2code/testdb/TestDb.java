package com.luv2code.testdb;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestDb {
    public static void main(String[] args) {
        String user = "springstudent";
        String pass = "springstudent";

        String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
        String driver = "com.mysql.jdbc.Driver";

        try{

            System.out.println("Connecting to database: "+jdbcUrl);
            Class.forName(driver);
            Connection myConnection = DriverManager.getConnection(jdbcUrl,user,pass);
            System.out.println("Success!!!");
            myConnection.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
