package com.aptech.controller;

import com.aptech.model.LoginModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginController")
public class LoginController extends HttpServlet {
    RequestDispatcher rd = null;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            if(request.getParameter("submit")!= null){
                String username = request.getParameter("username");
                String password = request.getParameter("password");
//                System.out.println(username + " "+ password);
                    LoginModel login = new LoginModel();
                boolean result = login.authenticate(username, password);
                if(result){
                     rd = request.getRequestDispatcher("/view/success.jsp");
                }else {
                     rd = request.getRequestDispatcher("/view/error.jsp");
                }
                rd.forward(request,response);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
