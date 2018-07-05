<%--
  Created by IntelliJ IDEA.
  User: lnminh
  Date: 2018-07-05
  Time: 7:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Submitted File</h2>
<table>
    <tr>
        <td>OriginalFileName:</td>
        <td>${file.originalFilename}</td>
    </tr>
    <tr>
        <td>Type:</td>
        <td>${file.contentType}</td>
    </tr>
</table>
</body>
</html>
