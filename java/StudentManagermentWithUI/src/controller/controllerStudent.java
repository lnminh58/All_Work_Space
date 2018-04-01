/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import model.modelStudent;

/**
 *
 * @author nguyenducthao
 */
public class controllerStudent {

    public static boolean searchStudentByCode(String studentCode) throws SQLException, ClassNotFoundException {
        boolean result = false;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "SELECT studentcode from student where studentcode like ?";
        conn = controllerConnectDB.connectTable();
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, studentCode);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            result = true;
        }
        rs.close();
        pstmt.close();
        conn.close();
        return result;
    }

    public static boolean searchStudentByName(String studentName) throws SQLException, ClassNotFoundException {
        boolean result = false;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "SELECT studentcode from student where studentname like ?";
        conn = controllerConnectDB.connectTable();
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, studentName);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            result = true;
        }
        rs.close();
        pstmt.close();
        conn.close();
        return result;
    }

    public static boolean searchStudentByBirthday(Date studentBirthday) throws SQLException, ClassNotFoundException {
        boolean result = false;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "SELECT studentcode from student where studentbirthday like ?";
        conn = controllerConnectDB.connectTable();
        pstmt = conn.prepareStatement(sql);
        pstmt.setDate(1, new java.sql.Date(studentBirthday.getYear(), studentBirthday.getMonth(), studentBirthday.getDate()));
        rs = pstmt.executeQuery();
        if (rs.next()) {
            result = true;
        }
        rs.close();
        pstmt.close();
        conn.close();
        return result;
    }

    public static boolean searchStudentByCodeAndName(String studentCode, String studentName) throws SQLException, ClassNotFoundException {
        boolean result = false;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "SELECT studentcode from student where studentcode like ? and studentname like ?";
        conn = controllerConnectDB.connectTable();
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, studentCode);
        pstmt.setString(2, studentName);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            result = true;
        }
        rs.close();
        pstmt.close();
        conn.close();
        return result;
    }

    public static void insertNewStudent(modelStudent student) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        String sql = "insert into student values (?,?,?,?,?,?,?,?,?,?)";
        conn = controllerConnectDB.connectTable();
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, student.getStudentCode());
        pstmt.setString(2, student.getStudentName());
        pstmt.setBoolean(3, student.isStudentGender());
        pstmt.setDate(4, new java.sql.Date(student.getStudentBirthday().getYear(), student.getStudentBirthday().getMonth(), student.getStudentBirthday().getDate()));
        pstmt.setString(5, student.getBatchCode());
        pstmt.setFloat(6, student.getStudentEnglishMark());
        pstmt.setFloat(7, student.getStudentMathMark());
        pstmt.setFloat(8, student.getStudentComputerMark());
        pstmt.setString(9, student.getFilename_avatar());
        pstmt.setBytes(10, student.getImage_avatar());
        pstmt.executeUpdate();

        pstmt.close();
        conn.close();

//        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-mm-dd");
//        java.util.Date date=dateFormat.parse("2017-11-10");
//        modelStudent student=new modelStudent("st00000006", "student 06",new java.sql.Date(date.getYear(), date.getMonth(), date.getDate()), "batch00130", 0, 0, 0);
    }

    public static void deleteStudentByCode(String studentCode) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        String sql = "delete from student where studentcode like ?";
        conn = controllerConnectDB.connectTable();
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, studentCode);
        pstmt.executeUpdate();

        pstmt.close();
        conn.close();
    }

    public static void deleteStudentByName(String studentName) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        String sql = "delete from student where studentname like ?";
        conn = controllerConnectDB.connectTable();
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, studentName);
        pstmt.executeUpdate();

        pstmt.close();
        conn.close();
    }

    public static void deleteStudentByCodeAndName(String studentCode, String studentName) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        String sql = "delete from student where studentcode like ? and studentname like ?";
        conn = controllerConnectDB.connectTable();
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, studentCode);
        pstmt.setString(2, studentName);
        pstmt.executeUpdate();

        pstmt.close();
        conn.close();
    }

    public static void deleteStudentByBirthday(Date birthday) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        String sql = "delete from student where studentbirthday like ?";
        conn = controllerConnectDB.connectTable();
        pstmt = conn.prepareStatement(sql);
        pstmt.setDate(1, new java.sql.Date(birthday.getYear(), birthday.getMonth(), birthday.getDate()));
        pstmt.executeUpdate();

        pstmt.close();
        conn.close();
    }

    public static void updateStudentCode(String oldStudentCode, String newStudentCode) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        String sql = "update student set studentcode = ? where studentcode like ?";
        conn = controllerConnectDB.connectTable();
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, newStudentCode);
        pstmt.setString(2, oldStudentCode);
        pstmt.executeUpdate();

        pstmt.close();
        conn.close();
    }

    public static void updateStudentName(String studentCode, String oldStudentName, String newStudentName) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        String sql = "update student set studentname = ? where studentcode like ? and studentname like ?";
        conn = controllerConnectDB.connectTable();
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, newStudentName);
        pstmt.setString(2, studentCode);
        pstmt.setString(3, oldStudentName);
        pstmt.executeUpdate();

        pstmt.close();
        conn.close();
    }

    public static void updateStudentBirthday(String studentCode, Date oldStudentBirthday, Date newStudentBirthday) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        String sql = "update student set studentbirthday = ? where studentcode like ? and studentbirthday like ?";
        conn = controllerConnectDB.connectTable();
        pstmt = conn.prepareStatement(sql);
        pstmt.setDate(1, new java.sql.Date(newStudentBirthday.getYear(), newStudentBirthday.getMonth(), newStudentBirthday.getDate()));
        pstmt.setString(2, studentCode);
        pstmt.setDate(3, new java.sql.Date(oldStudentBirthday.getYear(), oldStudentBirthday.getMonth(), oldStudentBirthday.getDate()));
        pstmt.executeUpdate();

        pstmt.close();
        conn.close();
    }

    public static void updateStudentCodeAndStudentName(String oldStudentCode, String oldStudentName, String newStudentCode, String newStudentName) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        String sql = "update student set studentcode = ?, studentname=? where studentcode like ? and studentname like ?";
        conn = controllerConnectDB.connectTable();
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, newStudentCode);
        pstmt.setString(2, newStudentName);
        pstmt.setString(3, oldStudentCode);
        pstmt.setString(4, oldStudentName);
        pstmt.executeUpdate();

        pstmt.close();
        conn.close();
    }

    public static void updateStudent(modelStudent student) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        String sql = "update student set "
                + "studentname = ?, "
                + "studentgender=?, "
                + "studentbirthday=?, "
                + "batchcode=?, "
                + "studentenglishmark=?, "
                + "studentmathmark=?, "
                + "studentcomputermark=?, "
                + "filename_avatar=?, "
                + "image_avatar=? "
                + "where studentcode = ?";
        conn = controllerConnectDB.connectTable();
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, student.getStudentName());
        pstmt.setBoolean(2, student.isStudentGender());
        pstmt.setDate(3, new java.sql.Date(student.getStudentBirthday().getYear(), student.getStudentBirthday().getMonth(), student.getStudentBirthday().getDate()));
        pstmt.setString(4, student.getBatchCode());
        pstmt.setFloat(5, student.getStudentEnglishMark());
        pstmt.setFloat(6, student.getStudentMathMark());
        pstmt.setFloat(7, student.getStudentComputerMark());
        pstmt.setString(8, student.getFilename_avatar());
        pstmt.setBytes(9, student.getImage_avatar());
        pstmt.setString(10, student.getStudentCode());
        pstmt.executeUpdate();

        pstmt.close();
        conn.close();
    }

    public static ResultSet getAllStudentCode() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        String sql = "SELECT studentcode FROM student";
        conn = controllerConnectDB.connectTable();
        stmt = conn.createStatement();
        rs = stmt.executeQuery(sql);
        return rs;

    }

    public static ResultSet getAllStudentName() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        String sql = "SELECT studentname FROM student";
        conn = controllerConnectDB.connectTable();
        stmt = conn.createStatement();
        rs = stmt.executeQuery(sql);
        return rs;

    }

    public static ResultSet getAllStudentBirthday() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        String sql = "SELECT studentbirthday FROM student";
        conn = controllerConnectDB.connectTable();
        stmt = conn.createStatement();
        rs = stmt.executeQuery(sql);
        return rs;

    }

    public static ResultSet getAllStudentCodeAndName() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        String sql = "SELECT studentcode, studentname FROM student";
        conn = controllerConnectDB.connectTable();
        stmt = conn.createStatement();
        rs = stmt.executeQuery(sql);
        return rs;

    }

    public static ResultSet getAllStudentAllField() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        String sql = "SELECT "
                + "student.studentcode, "
                + "student.studentname, "
                + "student.studentgender, "
                + "student.studentbirthday, "
                + "student.batchcode, "
                + "batch.batchname, "
                + "student.studentEnglishMark, "
                + "student.studentMathMark, "
                + "student.studentComputerMark, "
                + "student.filename_avatar, "
                + "student.image_avatar "
                + "FROM student "
                + "inner join batch on student.batchcode=batch.batchcode";
        conn = controllerConnectDB.connectTable();
        stmt = conn.createStatement();
        rs = stmt.executeQuery(sql);
        return rs;
    }

    public static String createNewStudentCode() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String newStudentCode = "st";

        String sql = "SELECT studentcode FROM student order by studentcode desc";
        conn = controllerConnectDB.connectTable();
        stmt = conn.createStatement();
        rs = stmt.executeQuery(sql);
        if (rs.next()) {
            int i = Integer.parseInt(rs.getString("studentcode").substring(5)) + 1;
            for (int j = 2; j < 10 - String.valueOf(i).length(); j++) {
                newStudentCode += "0";
            }
            newStudentCode += i;
        }
        rs.close();
        stmt.close();
        conn.close();
        return newStudentCode;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException, ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        java.util.Date date1 = dateFormat.parse("1996-01-05");
//        java.util.Date date2 = dateFormat.parse("1996-01-05");
//        modelStudent student=new modelStudent("st00000006", "student 06",new java.sql.Date(date.getYear(), date.getMonth(), date.getDate()), "batch00130", 0, 0, 0);
//        updateStudentBirthday("st0000005", date1, date2);
        System.out.println(searchStudentByBirthday(date1));
//        while (rs.next()) {
//            System.out.println(rs.getString("studentcode"));
//            System.out.println(rs.getString("studentname"));
//            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
//            java.util.Date date1 = dateFormat.parse(rs.getString("studentbirthday"));
//            System.out.println(date1.getDate());
//        }
    }
}
