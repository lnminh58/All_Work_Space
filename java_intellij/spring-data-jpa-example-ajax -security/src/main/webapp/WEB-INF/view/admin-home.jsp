<%--
  Created by IntelliJ IDEA.
  User: lnmin
  Date: 2018-08-02
  Time: 10:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>
    hello admin
</h1>
<br><br>
<a href="/student/home">Go to student page</a>
<br><br>
<form id="logoutForm" method="POST" action="/logout">
    <input type="hidden" name="${_csrf.parameterName}"
           value="${_csrf.token}" />
    <input type="submit" value="log out">
</form>
<%--<a onclick="document.forms['logoutForm'].submit()" >Logout</a>--%>
</body>
</html>
