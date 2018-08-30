package com.aptech.dao;

import com.aptech.model.Book;
import com.aptech.util.MSSQLConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class BookDAO {
    MSSQLConnection mssqlConnection;

    public BookDAO() {
        this.mssqlConnection = new MSSQLConnection();
    }

    public void insertBookToDatabase(Book book) {
        String sql = "insert into book (book_name,author,category_id,page_number) values ('" + book.getBookName() + "','" + book.getAuthor() + "'," + book.getCategoryId() + "," + book.getPageNumber() + ")";
        try {
            mssqlConnection.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
