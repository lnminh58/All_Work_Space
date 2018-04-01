/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file_and_jdbc;

import static file_and_jdbc.File_and_JDBC.DATABASENAME;
import static file_and_jdbc.File_and_JDBC.DB_URL;
import static file_and_jdbc.File_and_JDBC.DUONGDANFILETXT;
import static file_and_jdbc.File_and_JDBC.JDBC_DRIVER;
import static file_and_jdbc.File_and_JDBC.PASS;
import static file_and_jdbc.File_and_JDBC.USER;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author nguyenducthao
 */
public class createDatabase {
    static void create_Database() throws IOException {
        String contentFileTXT = "";
        String database_Name = "";
        contentFileTXT = readFileTXT.read_FileTXT(DUONGDANFILETXT);
//        noidungfiletxt = noidungfiletxt.substring(0, noidungfiletxt.length() - 2);
        database_Name = contentFileTXT.substring(contentFileTXT.lastIndexOf(' ') + 1);
        if (!checkExitsDatabase.check_ExitsDatabase(database_Name)) {
            DATABASENAME = database_Name + ";";
            Connection conn = null;
            Statement stmt = null;
            try {
                Class.forName(JDBC_DRIVER);

                System.out.println("Connecting to database...");
                conn = DriverManager.getConnection(DB_URL + USER + PASS);

                System.out.println("Creating database...");
                stmt = conn.createStatement();

//      String sql = "CREATE DATABASE QUANLYMAYBAY1";
                String sql = "CREATE DATABASE " + DATABASENAME;
                stmt.executeUpdate(sql);
                System.out.println("Database created successfully...");
            } catch (SQLException se) {
                //Handle errors for JDBC
                se.printStackTrace();
            } catch (Exception e) {
                //Handle errors for Class.forName
                e.printStackTrace();
            } finally {
                //finally block used to close resources
                try {
                    if (stmt != null) {
                        stmt.close();
                    }
                } catch (SQLException se2) {
                }// nothing we can do
                try {
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException se) {
                    se.printStackTrace();
                }//end finally try
            }//end try
        } else {
            System.out.println("Database exits...");
        }
    }
}
