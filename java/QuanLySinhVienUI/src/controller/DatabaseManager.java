/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Student;

/**
 *
 * @author lnmin
 */
public class DatabaseManager {
    public static void addStudent(Student st){
        try (Connection conn = ConnectDatabase.getConnectDatabase()) {
            String sql = "insert into Student values (?,?,?,?)";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, st.getId());
                pstmt.setString(2, st.getName());
                pstmt.setBoolean(3, st.isGender());
                pstmt.setString(4, st.getClassID());
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Update success");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Update fail");
        }
}
    public static void deleteStudent(String id){
        try (Connection conn = ConnectDatabase.getConnectDatabase()) {
            String sql = "Delete from student where id like ?";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, id);
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Update success");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Update fail");
        }
        
    }
}

