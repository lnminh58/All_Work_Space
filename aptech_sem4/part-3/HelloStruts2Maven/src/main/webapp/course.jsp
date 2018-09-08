<%--
  Created by IntelliJ IDEA.
  User: lnminh
  Date: 06/09/2018
  Time: 19:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1 align="center">ADD NEW COURSE</h1>
    <br><br>
    <s:form>
        <s:label value="Category: "/> <s:select list="categories" name="category"/>
        <s:label value="Course ID: "/> <s:textfield name="courseId" />
        <s:label value="Name: "/><s:textfield name="name" />
        <s:label value="Description: "/><s:textarea name="description" rows="5" />
        <s:submit value="New" action="new" />
        <s:submit value="Save" action="save" />
    </s:form>
    <s:property value="message" />
</body>
</html>
