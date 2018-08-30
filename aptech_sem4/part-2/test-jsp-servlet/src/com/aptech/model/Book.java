package com.aptech.model;

import java.io.Serializable;

public class Book implements Serializable {
    private int bookId;
    private String bookName;
    private String author;
    private int categoryId;
    private int pageNumber;

    public Book() {
    }

    public Book( String bookName, String author, int categoryId, int pageNumber) {
        this.bookName = bookName;
        this.author = author;
        this.categoryId = categoryId;
        this.pageNumber = pageNumber;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", categoryId='" + categoryId + '\'' +
                ", pageNumber='" + pageNumber + '\'' +
                '}';
    }
}
