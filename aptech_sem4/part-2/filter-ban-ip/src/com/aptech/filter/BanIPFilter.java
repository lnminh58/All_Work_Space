package com.aptech.filter;

import com.sun.deploy.net.HttpRequest;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "BanIPFilter")
public class BanIPFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(req, resp);
        HttpServletRequest httpReq = (HttpServletRequest) req;
        HttpServletResponse httpResp = (HttpServletResponse) resp;
        String url = httpReq.getRequestURI();
        String remoteAddr = req.getRemoteAddr();

        if (url.indexOf("sex") != -1 || url.indexOf("admincp") != -1) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("spam.jsp");
            requestDispatcher.forward(req,resp);
        }else if(remoteAddr.equals("0:0:0:0:0:0:0:1") == true){
            if(url.indexOf("banIP.jsp") == -1){
                httpResp.sendRedirect("banIP.jsp");
            }else{
                chain.doFilter(req,resp);
            }
        }else{
            chain.doFilter(req,resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
