<%--
  Created by IntelliJ IDEA.
  User: lnmin
  Date: 2018-07-19
  Time: 5:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <h1>LOGIN SYSTEM</h1>
    <%
        if (session.getAttribute("message") != null) {

            String message = session.getAttribute("message").toString();
            if (!message.equals("")) {
                out.println(message);
            }
        }
    %>
    <br><br>
    <form action="login.do" method="post">
        Username<input type="text" name="username">
        <br><br>
        Password<input type="password" name="password">
        <br><br>
        Group
        <select name="group">
            <option value="member">Member</option>
            <option value="admin">Admin</option>
        </select>
        <br><br>
        <input type="submit" value="submit" name="submit">
    </form>
</body>
</html>
