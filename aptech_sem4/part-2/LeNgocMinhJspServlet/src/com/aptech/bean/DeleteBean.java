package com.aptech.bean;

import com.aptech.util.MSSQLConnection;

import java.sql.SQLException;

public class DeleteBean {
    MSSQLConnection mssqlConnection;
    public DeleteBean() {
        mssqlConnection= new MSSQLConnection();
    }
     public boolean deleteBook(String bookId){
        String sql = "delete from TBL_Book where bookId ='"+ bookId+"'";
         try {
             boolean result = mssqlConnection.execute(sql);
             return result;
         } catch (SQLException e) {
             return false;
         }
     }
}

