package com.aptech.webent.servlet;

import com.aptech.webent.dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

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
                String secureText = createRandomText();
                userDAO.createLoginSession(username,secureText);
                Cookie cookie = new Cookie("usernameLogin",username+"+"+secureText);
                cookie.setMaxAge(60*60);
                response.addCookie(cookie);
                response.sendRedirect("show-all.jsp");
            }else{
                out.print("dang nhap that bai");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private String createRandomText(){
        Random random = new Random();
        String alphabet= "0123456789abcdefghijklmnopqrstuvwxyz";
        String secureText="";
        for (int i= 0;i<15;i++){
            secureText+=alphabet.charAt(random.nextInt(alphabet.length()-1));
        }
        return secureText;
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
