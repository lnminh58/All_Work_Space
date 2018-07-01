package com.lnminh.test;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnect {

    public static void main(String[] args) {
        String jdbcUrl = "jdbc:sqlserver://localhost;databaseName=education";
        String user = "sa";
        String pass = "ngocminh58";

        try{
            System.out.println("Connecting to database");
            Connection conn = DriverManager.getConnection(jdbcUrl,user,pass);
            System.out.println("connection successfull: " + conn);
            conn.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
