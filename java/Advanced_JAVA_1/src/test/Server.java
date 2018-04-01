/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author nguyenducthao
 */
public class Server {

    private Connection con;
    private Statement stm;
    private ResultSet rs;
    private String sql;

    public Server() {
        // TODO Auto-generated constructor stub
    }

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        ServerSocket svsk = new ServerSocket(8080);
        String st = "";
        String[] arr;
        while (true) {
            Socket sk = svsk.accept();
            
            DataInputStream din = new DataInputStream(sk.getInputStream());
            st = din.readUTF();
            System.out.println("Client gui:" + st);
            arr = st.split(" ");
            System.out.println("arr1:" + arr[0]);
            System.out.println("arr2:" + arr[1]);
            Server sv = new Server();
            sv.insertData(arr[0], arr[1]);
            DataOutputStream dos = new DataOutputStream(sk.getOutputStream());
            dos.writeUTF("Server");
            sk.close();
        }
    }
// private static String[] Split(String st, String string) {
// // TODO Auto-generated method stub
// return null;
// }

    public void ConnectData() throws Exception {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String URL = "jdbc:sqlserver://192.168.61.139;";
            String user = "";
            String Password = "";
            con = DriverManager.getConnection("jdbc:sqlserver://192.168.61.139;databaseName=test;user=sa;password=123");
            stm = con.createStatement();
            sql = "select * from test1";
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getString("id"));
                System.out.println(rs.getString("userName"));
                System.out.println(rs.getString("password"));
            }
        } catch (Exception e) {
            System.out.println("khong nap duoc driver" + e);
        }
    }

    public boolean insertData(String user, String pass) throws Exception {
        ConnectData();
        sql = "INSERT INTO test1(username,password) VALUES('" + user + "','" + pass + "')";
        int row = 0;
        row = stm.executeUpdate(sql);
        System.out.println("so row insert vao: " + row);
        con.close();
        return true;
    }

    public boolean deleteData(String user) throws Exception {
        ConnectData();
        sql = "DELETE FROM test1 where username='" + user + "'";
        int row = stm.executeUpdate(sql);
        System.out.println("so row xoa: " + row);
        con.close();
        return true;
    }

    public boolean updateData(String user, String pass) throws Exception {
        ConnectData();
        sql = "UPDATE test1 set password='" + pass + "' where username='" + user + "'";
        int row = stm.executeUpdate(sql);
        System.out.println("update number row: " + row);
        con.close();
        return true;
    }
}
