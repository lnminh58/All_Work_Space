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
import model.modelBatch;

/**
 *
 * @author nguyenducthao
 */
public class controllerBatch {

    public static boolean searchBatchByCode(String batchCode) throws SQLException, ClassNotFoundException {
        boolean result = false;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "SELECT batchcode from batch where batchcode like ?";
        conn = controllerConnectDB.connectTable();
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, batchCode);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            result = true;
        }
        rs.close();
        pstmt.close();
        conn.close();
        return result;
    }

    public static boolean searchBatchByName(String batchName) throws SQLException, ClassNotFoundException {
        boolean result = false;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "SELECT batchcode from batch where batchname like ?";
        conn = controllerConnectDB.connectTable();
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, batchName);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            result = true;
        }
        rs.close();
        pstmt.close();
        conn.close();
        return result;
    }

    public static boolean searchBatchByCodeAndName(String batchCode, String batchName) throws SQLException, ClassNotFoundException {
        boolean result = false;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "SELECT batchcode from batch where batchcode like ? and batchname like ?";
        conn = controllerConnectDB.connectTable();
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, batchCode);
        pstmt.setString(2, batchName);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            result = true;
        }
        rs.close();
        pstmt.close();
        conn.close();
        return result;
    }

    public static void insertNewBatch(modelBatch batch) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        String sql = "insert into batch values (?,?)";
        conn = controllerConnectDB.connectTable();
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, batch.getBatchCode());
        pstmt.setString(2, batch.getBatchName());
        pstmt.executeUpdate();

        pstmt.close();
        conn.close();
    }

    public static void deleteBatchByCode(String batchCode) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        String sql = "delete from batch where batchcode like ?";
        conn = controllerConnectDB.connectTable();
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, batchCode);
        pstmt.executeUpdate();

        pstmt.close();
        conn.close();
    }

    public static void deleteBatchByName(String batchName) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        String sql = "delete from batch where batchname like ?";
        conn = controllerConnectDB.connectTable();
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, batchName);
        pstmt.executeUpdate();

        pstmt.close();
        conn.close();
    }

    public static void deleteBatchByCodeAndName(String batchCode, String batchName) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        String sql = "delete from batch where batchcode like ? and batchname like ?";
        conn = controllerConnectDB.connectTable();
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, batchCode);
        pstmt.setString(2, batchName);
        pstmt.executeUpdate();

        pstmt.close();
        conn.close();
    }

    public static void updateBatchCode(String oldBatchCode, String newBatchCode) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        String sql = "update batch set batchcode = ? where batchcode like ?";
        conn = controllerConnectDB.connectTable();
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, newBatchCode);
        pstmt.setString(2, oldBatchCode);
        pstmt.executeUpdate();

        pstmt.close();
        conn.close();
    }

    public static void updateBatchName(String oldBatchName, String newBatchName) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        String sql = "update batch set batchname = ? where batchname like ?";
        conn = controllerConnectDB.connectTable();
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, newBatchName);
        pstmt.setString(2, oldBatchName);
        pstmt.executeUpdate();

        pstmt.close();
        conn.close();
    }

    public static void updateBatchCodeAndBatchName(String oldBatchCode, String oldBatchName, String newBatchCode, String newBatchName) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        String sql = "update batch set batchcode = ?, batchname=? where batchcode like ? and batchname like ?";
        conn = controllerConnectDB.connectTable();
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, newBatchCode);
        pstmt.setString(2, newBatchName);
        pstmt.setString(3, oldBatchCode);
        pstmt.setString(4, oldBatchName);
        pstmt.executeUpdate();

        pstmt.close();
        conn.close();
    }

    public static ResultSet getAllBatchCode() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        String sql = "SELECT batchcode FROM batch";
        conn = controllerConnectDB.connectTable();
        stmt = conn.createStatement();
        rs = stmt.executeQuery(sql);
        return rs;

    }

    public static ResultSet getAllBatchName() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        String sql = "SELECT batchname FROM batch";
        conn = controllerConnectDB.connectTable();
        stmt = conn.createStatement();
        rs = stmt.executeQuery(sql);
        return rs;

    }

    public static ResultSet getAllBatchCodeAndBatchName() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        String sql = "SELECT batchcode, batchname FROM batch order by batchcode asc";
        conn = controllerConnectDB.connectTable();
        stmt = conn.createStatement();
        rs = stmt.executeQuery(sql);
        return rs;
    }

    public static String createNewBatchCode() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String newBatchCode = "";

        String sql = "SELECT batchcode FROM batch order by batchcode desc";
        conn = controllerConnectDB.connectTable();
        stmt = conn.createStatement();
        rs = stmt.executeQuery(sql);
        if (rs.next()) {
            int i = Integer.parseInt(rs.getString("batchcode").substring(5)) + 1;
            if (i < 10) {
                newBatchCode = "batch0000" + i;
            } else {
                if ((i >= 10) && (i < 100)) {
                    newBatchCode = "batch000" + i;
                } else {
                    if ((i >= 100) && (i < 1000)) {
                        newBatchCode = "batch00" + i;
                    } else {
                        if ((i >= 1000) && (i < 10000)) {
                            newBatchCode = "batch00" + i;
                        } else {
                            if ((i >= 10000) && (i < 100000)) {
                                newBatchCode = "batch0" + i;
                            }
                        }
                    }
                }
            }
        }
        rs.close();
        stmt.close();
        conn.close();
        return newBatchCode;
    }
}
