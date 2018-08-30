<%--
  Created by IntelliJ IDEA.
  User: lnmin
  Date: 2018-08-21
  Time: 8:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<html>
<head>

</head>
<body>
<h1> Registation form </h1>
<hr>
<html:form action="register">
    <html:text property="name"/>
    <html:submit value="Register"/>
    <hr>
    <html:text property="message"/>
</html:form>
</body>
</html>
