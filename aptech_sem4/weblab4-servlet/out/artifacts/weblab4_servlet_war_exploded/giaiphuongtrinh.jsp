<%@ page import="java.net.URLEncoder" %><%--
  Created by IntelliJ IDEA.
  User: lnmin
  Date: 2018-06-26
  Time: 7:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    out.print("Session: ");
    if (session.getAttribute("message") != null) {

        String message = session.getAttribute("message").toString();
        if (!message.equals("")) {
            out.println(message);
        }
    }
%>
<%
    out.print("<br>Cookie: ");
    Cookie[] cookies= request.getCookies();
    // check null because there are chances that there are no cookies
    if(cookies !=null)
    {
        for(int i=0 ;i<cookies.length;i++ )
        {
            Cookie cookie = cookies[i];
            if(cookie.getName().equalsIgnoreCase("message")){
                out.println("" + cookie.getValue() + "" );
            }
        }
    }
%>


<form action="giaiphuongtrinh.do" method="POST">
    A= <input type="text" name="txtA"/> <br>
    B= <input type="text" name="txtB"/> <br>
    C= <input type="text" name="txtC"/> <br>
    <br>
    <input type="submit" name="submit" value="Giai Phuong Trinh"/>
</form>
</body>
</html>
