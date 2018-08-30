<%--
  Created by IntelliJ IDEA.
  User: lnmin
  Date: 2018-08-18
  Time: 5:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    if (username != null && password != null) {
        if (username.equals("admin") && password.equals("admin")) {
            response.sendRedirect("delete.jsp");
        } else {
            out.print("Không đúng thông tin đăng nhập");
        }
    }
%>
<form action="" method="post">
    Enter Username: <input type="text" name="username">
    <br><br>
    Enter Password: <input type="password" name="password">
    <br><br>
    <input type="submit" name="submit" value="Login">
</form>
</body>
</html>
