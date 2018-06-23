package com.aptech.webent.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {

    protected void viewLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) { /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet First_Servlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet First_Servlet at " + request.getContextPath() + "</h1>");
            out.println("<form>");
            out.println("<input type='text' placeholder='user name'/>");
            out.println("<br/>");
            out.println("<input type='password' />");
            out.println("<br/>");
            out.println("<input type='submit' value='login'/>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        viewLogin(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        viewLogin(request,response);
    }
}
