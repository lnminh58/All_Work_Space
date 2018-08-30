<%@ page import="com.aptech.webent.dao.UserDAO" %><%--
  Created by IntelliJ IDEA.
  User: lnmin
  Date: 2018-07-17
  Time: 6:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<%
    UserDAO userDAO = new UserDAO();
    String cookieName = "usernameLogin";
    Cookie cookies[] = request.getCookies();
    if (cookies != null) {
        for (int i = 0; i < cookies.length; i++) {
            if (cookies[i].getName().equals(cookieName)) {
                String[] loginInfo = cookies[i].getValue().split("\\+");
                System.out.println(loginInfo[1]+"\t"+loginInfo[0]);
                boolean validUser = userDAO.checkLoginWithCookie(loginInfo[0], loginInfo[1]);
                if (validUser) {
                    response.sendRedirect("show-all.jsp");
                }
            }
        }
    }
%>
<h2>Login Form</h2>
<form action="/login.do" method="post">
    <input type="text" name="username" placeholder="Username">
    <br>
    <input type="password" name="password" placeholder="Password">
    <br>
    <input type="submit" name="submit" value="submit">
</form>
</body>
</html>
