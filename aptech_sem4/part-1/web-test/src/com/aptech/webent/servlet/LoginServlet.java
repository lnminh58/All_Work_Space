package com.aptech.webent.servlet;

import com.aptech.webent.dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try(PrintWriter out = response.getWriter()){

            if(request.getParameter("submit")== null){
                out.print("Request Error");
               return;
            }
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            System.out.println(username);
            System.out.println(password);
            UserDAO userDAO = new UserDAO();
            boolean isValid = userDAO.checkLogin(username, password);
//            out.print(isValid==true?"Thanh Cong":"that bai");
            if (isValid){
                response.sendRedirect("show-all.jsp");
            }else{
                out.print("dang nhap that bai");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
