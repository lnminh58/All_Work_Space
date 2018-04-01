/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file_and_jdbc;

import static file_and_jdbc.File_and_JDBC.DATABASENAME;
import static file_and_jdbc.File_and_JDBC.DB_URL;
import static file_and_jdbc.File_and_JDBC.JDBC_DRIVER;
import static file_and_jdbc.File_and_JDBC.PASS;
import static file_and_jdbc.File_and_JDBC.USER;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author nguyenducthao
 */
public class checkExitsDatabase {
    static boolean check_ExitsDatabase(String database_Name) {
        Connection conn = null;
        boolean kiemtra = false;
        try {
            Class.forName(JDBC_DRIVER);

//            DATABASENAME="databaseName=quanlymaybay;";
            DATABASENAME = "databaseName=" + database_Name + ";";
//            System.out.println("Dang ket noi toi co so du lieu ...");
//      conn = DriverManager.getConnection("jdbc:sqlserver://192.168.61.139;databaseName=quanlymaybay;user=sa;password=123");
            conn = DriverManager.getConnection(DB_URL + DATABASENAME + USER + PASS);
            kiemtra = true;
            conn.close();
        } catch (Exception e) {
//            System.out.println(e.getCause());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }// Ket thuc khoi finally
        }// Ket thuc khoi try
        return kiemtra;
    }
}
