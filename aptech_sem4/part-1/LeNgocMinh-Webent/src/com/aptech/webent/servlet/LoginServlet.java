package com.aptech.webent.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try(PrintWriter out = response.getWriter()){

            if(request.getParameter("submit")== null){
                return;
            }
            String username = request.getParameter("username").trim();
            String password = request.getParameter("password").trim();
            String group = request.getParameter("group");
            if(username.equals("")||password.equals("")){
                HttpSession session= request.getSession();
                session.setAttribute("message","You must enter your login information");
                response.sendRedirect("login.jsp");
            }else if(password.length()<3){
                HttpSession session= request.getSession();
                session.setAttribute("message","Your password is not valid");
                response.sendRedirect("login.jsp");
            }else if (username.equals("admin")&& password.equals("123456")){
                response.sendRedirect("success.jsp");
            }else {
                HttpSession session= request.getSession();
                session.setAttribute("message","Incorrect username or password");
                response.sendRedirect("login.jsp");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
