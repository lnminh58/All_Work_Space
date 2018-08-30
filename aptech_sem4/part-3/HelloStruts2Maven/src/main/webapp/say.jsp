<%--
  Created by IntelliJ IDEA.
  User: lnmin
  Date: 2018-08-30
  Time: 8:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Say hello</h1>
    <hr>
<s:form action="say">
    <s:textfield name="name" label="Name" />
    <s:submit value="say hello"/>
</s:form>
    <hr>
    <s:property value="message" />
</body>
</html>
