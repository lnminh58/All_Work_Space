package com.aptech.webent.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet(name = "GiaiPhuongTrinhBac2Servlet")
public class GiaiPhuongTrinhBac2Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            if(request.getParameter("submit") != null){
                int a = Integer.parseInt(request.getParameter("txtA").toString());
                int b = Integer.parseInt(request.getParameter("txtB").toString());
                int c = Integer.parseInt(request.getParameter("txtC").toString());
                int delta = b*b-4*a*c;
                if (delta<0){
                    Cookie cookie = new Cookie("message", "Phuong trinh vo nghiem");
                    cookie.setMaxAge(60*60*24);
                    response.addCookie(cookie);


                    HttpSession session= request.getSession();
                    session.setAttribute("message","phuong trinh vo nghiem");

                }else if(delta==0){
                    int x =  -b/(2*a);
                    Cookie cookie = new Cookie("message", "phuong trinh co nghiem kep:" +x);
//                    cookie.setMaxAge(60*60*24);
                    response.addCookie(cookie);

                    HttpSession session= request.getSession();
                    session.setAttribute("message","phuong trinh co nghiem kep: "+ -b/(2*a));



                }else {
                    HttpSession session= request.getSession();
                    session.setAttribute("message","phuong trinh co 2 nghiem : ");
                }

                response.sendRedirect("giaiphuongtrinh.jsp");
            }
        }catch (Exception ex){
            ex.printStackTrace();


            Cookie cookie= new Cookie("message", "loi");
//            cookie.setMaxAge(24*60*60);
            response.addCookie(cookie);


            response.sendRedirect("giaiphuongtrinh.jsp");

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
