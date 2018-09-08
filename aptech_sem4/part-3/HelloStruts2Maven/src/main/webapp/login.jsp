<%--
  Created by IntelliJ IDEA.
  User: lnminh
  Date: 04/09/2018
  Time: 19:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Login pages</h1>
    <br>
    <s:form action="login" method="POST" >
        <s:textfield name="username" label="Username: " />
        <s:submit value="Login" />
    </s:form>
    <h4>
        Errors: <s:property value="message" />
    </h4>
</body>
</html>
