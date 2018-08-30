package com.aptech.controller;

import com.aptech.bean.DeleteBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DeleteServlet")
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if(request.getParameter("submit")!=null){
            String bookId = request.getParameter("bookId");
            System.out.println(bookId);
            if(bookId.equals("")){
                HttpSession session= request.getSession();
                session.setAttribute("message","enter fill before send");
                response.sendRedirect("delete.jsp");
                return;
            }else{
                DeleteBean deleteBean=new DeleteBean();
                boolean result = deleteBean.deleteBook(bookId);
                System.out.println(result);
                if(result){
                    response.sendRedirect("success.jsp");
                }else {
                    response.sendRedirect("failed.jsp");
                }
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
