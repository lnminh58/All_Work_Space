/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file_and_jdbc;

import java.io.IOException;

/**
 *
 * @author nguyenducthao
 */
public class File_and_JDBC {

    /**
     * @param args the command line arguments
     */
    static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    static final String DB_URL = "jdbc:sqlserver://192.168.61.139;";

    //  Ten database, nguoi dung va mat khau cua co so du lieu
//    static final String DATABASENAME = "databaseName=quanlymaybay;";
    static String DATABASENAME = "";
    static final String USER = "user=sa;";
    static final String PASS = "password=123";
    static String DUONGDANFILETXT = "password=123";
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        DUONGDANFILETXT = getPaths.get_Path();
        DUONGDANFILETXT += "\\txt\\create dabase.txt";
        createDatabase.create_Database();
        DUONGDANFILETXT = getPaths.get_Path();
        DUONGDANFILETXT += "\\txt\\create table.txt";
//        createTable.create_Table();
        DUONGDANFILETXT = getPaths.get_Path();
        DUONGDANFILETXT += "\\txt\\insert into table.txt";
//        insertIntoTable.insert_Into_Table();
        DUONGDANFILETXT = getPaths.get_Path();
        DUONGDANFILETXT += "\\txt\\delete table row.txt";
//        deleteTableRow.delete_TableRow();
        DUONGDANFILETXT = getPaths.get_Path();
        DUONGDANFILETXT += "\\txt\\drop table.txt";
//        dropTable.drop_Table();
        DUONGDANFILETXT = getPaths.get_Path();
        DUONGDANFILETXT += "\\txt\\query table.txt";
        queryTable.query_table();
    }
    
}
