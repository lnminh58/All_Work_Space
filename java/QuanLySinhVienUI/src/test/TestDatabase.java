/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import controller.ConnectDatabase;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lnmin
 */
public class TestDatabase {
    public static void main(String[] args) {
        try (Connection conn = ConnectDatabase.getConnectDatabase();
                Statement stmt= conn.createStatement()){
            String sql = "Select * from student";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {                
                System.out.print(rs.getString("ID")+"\t");
                System.out.print(rs.getString("Name")+"\t");
                System.out.print(rs.getString("Gender")+"\t");
                System.out.print(rs.getString("classID")+"\n");
            }
        } catch (SQLException ex) {
        }
        
    }
 
}
