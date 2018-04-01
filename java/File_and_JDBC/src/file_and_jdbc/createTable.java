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
public class createTable {
    static void create_Table() throws IOException {
        String contentFileTXT = "";
//        String tentable = "";
        contentFileTXT = readFileTXT.read_FileTXT(DUONGDANFILETXT);
//        noidungfiletxt = noidungfiletxt.substring(0, noidungfiletxt.length() - 2);
//        tentable = noidungfiletxt.substring(noidungfiletxt.lastIndexOf(' ') + 1);
        Connection conn = null;
        Statement stmt = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL + DATABASENAME + USER + PASS);

            //STEP 4: Execute a query
            System.out.println("Creating table...");
            stmt = conn.createStatement();

            String sql = contentFileTXT;

            stmt.executeUpdate(sql);
            System.out.println("Table created successfully...");
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
    }
}
