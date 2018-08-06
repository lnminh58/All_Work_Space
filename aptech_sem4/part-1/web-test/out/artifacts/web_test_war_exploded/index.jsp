<%--
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
