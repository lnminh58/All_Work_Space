package com.aptech.webent.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {

    private String form = "\n" +
            "<form action='register.do' method='POST'>\n" +
            "Username <br> <input type='text' name='username'/><br>\n" +
            "Password <br>  <input type='password'  name='password'/><br>\n" +
            "Confirm password <br>  <input type='password'  name='cfmPassword'/><br>\n" +
            "Email <br>  <input type='text'  name='email'/><br>\n" +
            "    <input type='submit' value='submit' name='submit'/>\n" +
            "</form>";

    protected void viewRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) { /* TODO output your page here. You may use following sample code. */
            out.println(this.form);
        }
    }

    private boolean isBlank(String str){
        return str.trim().equalsIgnoreCase("");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            String username = request.getParameter("username").toString();
            String password = request.getParameter("password").toString();
            String cfmPassword = request.getParameter("cfmPassword").toString();
            String email = request.getParameter("email").toString();
            if(isBlank(username)||isBlank(password)||isBlank(cfmPassword)){
                try (PrintWriter out = response.getWriter()) { /* TODO output your page here. You may use following sample code. */
                    String error1 = "<span style='color:red'>vui long dien vao</span>";
                    String formError=error1 +"<br>"+form;
                    out.println(formError);
                }
            }else if(!password.equals(cfmPassword)){
                try (PrintWriter out = response.getWriter()) { /* TODO output your page here. You may use following sample code. */
                    String error2 = "<span style='color:red'>mat khau khong trung nhau</span>";
                    String formError = error2 +"<br>"+form;
                    out.println(formError);
                }
            }else {
                response.sendRedirect("index.jsp");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        viewRegister(request,response);
    }
}
