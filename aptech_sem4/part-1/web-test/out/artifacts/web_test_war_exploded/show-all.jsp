<%@ page import="com.aptech.webent.dao.UserDAO" %>
<%@ page import="com.aptech.webent.model.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: lnmin
  Date: 2018-07-17
  Time: 8:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Show All Users</h1>
    <%
        UserDAO userDAO = new UserDAO();
        List<User> all = userDAO.getAll();
        for (User user : all) {
    %>
        <%=user.getId()%> ---- <%=user.getUsername()%></br>
    <%
        }
    %>
</body>
</html>
