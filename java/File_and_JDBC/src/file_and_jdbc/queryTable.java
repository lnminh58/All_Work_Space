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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author nguyenducthao
 */
public class queryTable {
    static void query_table() throws IOException {
        String contentFileTXT = "";
//        String tentable = "";
        contentFileTXT = readFileTXT.read_FileTXT(DUONGDANFILETXT);
//        System.out.println(noidungfiletxt);
        Connection conn = null;
        Statement stmt = null;
        try {
            // Buoc 2: Dang ky Driver
            Class.forName(JDBC_DRIVER);

            // Buoc 3: Mo mot ket noi
            System.out.println("Dang ket noi toi co so du lieu ...");
//      conn = DriverManager.getConnection("jdbc:sqlserver://192.168.61.139;databaseName=quanlymaybay;user=sa;password=123");
            conn = DriverManager.getConnection(DB_URL + DATABASENAME + USER + PASS);

            // Buoc 4: Thuc thi truy van
            System.out.println("Tao cac lenh truy van SQL ...");
            stmt = conn.createStatement();
            String sql;
            sql = contentFileTXT;
            ResultSet rs = stmt.executeQuery(sql);

            // Buoc 5: Lay du lieu tu Result Set
            int dem = 0;
            while (rs.next()) {
                /*FileWriter là một lớp luồng ký tự dùng để ghi các ký tự 
        vào file. Mặc định, nó sẽ thay thế toàn bộ nội dung sẵn 
        có bằng nội dung mới, tuy nhiên bạn có thể chỉ định giá 
        trị boolean là true cho tham số thứ hai trong hàm tạo của 
        FileWriter, nó sẽ giữ lại nội dung có sẵn và nối thêm nội 
        dung mới vào cuối file.

Để thay thế toàn bộ nội dung đã có bằng nội dung mới : new FileWriter(file);
Để giữ lại nội dung đã có và nối thêm nội dung mới vào cuối file : new FileWriter(file,true)*/
                dem++;
                try {
                    String duongdan = getPaths.get_Path();
                    duongdan += "\\txt\\query table result.txt";
                    File file = new File(duongdan);
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write("Row " + dem + ":\r\n");
                    bw.write("Ma chuyen bay: " + rs.getString(1) + "\r\n");
                    bw.write("Ga di: " + rs.getString(2) + "\r\n");
                    bw.write("Ga den: " + rs.getString(3) + "\r\n");
                    bw.write("Do dai: " + rs.getInt(4) + "\r\n");
                    bw.write("Gio di: " + rs.getString(5) + "\r\n");
                    bw.write("Gio den: " + rs.getString(6) + "\r\n");
                    bw.write("Chi phi: " + rs.getInt(7) + "\r\n");
                    bw.write("Ma nhan vien: " + rs.getString(8) + "\r\n");
                    bw.write("==========================\r\n");
                    bw.close();
//            System.out.println("Done");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            // Buoc 6: Don sach moi truong va giai phong resource
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            // Xu ly cac loi cho JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Xu ly cac loi cho Class.forName
            e.printStackTrace();
        } finally {
            // Khoi finally duoc su dung de dong cac resource
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }// Ket thuc khoi finally
        }// Ket thuc khoi try
    }
}
