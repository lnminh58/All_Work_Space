package com.aptech.controller;

import com.aptech.dao.BookDAO;
import com.aptech.model.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AddBookServlet")
public class AddBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("submit")!= null) {
            String bookName = request.getParameter("name");
            String author = request.getParameter("author");
            int categoryId = Integer.parseInt(request.getParameter("category-id"));
            int pageNumber = Integer.parseInt(request.getParameter("pages"));
            Book book = new Book(bookName, author, categoryId, pageNumber);
            System.out.println(book);
            BookDAO bookDAO = new BookDAO();
            bookDAO.insertBookToDatabase(book);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
