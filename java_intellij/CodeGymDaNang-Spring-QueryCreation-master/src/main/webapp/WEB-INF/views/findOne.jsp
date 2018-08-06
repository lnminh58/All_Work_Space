<%--
  Created by IntelliJ IDEA.
  User: PC-PC
  Date: 8/28/2016
  Time: 8:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" isELIgnored="false"%>
<html>
<head>
    <title></title>
</head>
<body>
<table class="table table-hover " width="500px">
  <thead>
  <tr id="listShopView">
    <th>ID</th>
    <th>Name</th>
    <th>Local</th>
    <th>Email</th>
  </tr>
  </thead>
  <tr>
    <td>${shop.id}</td>
    <td>${shop.name}</td>
    <td>${shop.local}</td>
    <td>${shop.email}</td>
  </tr>

</table>

</body>
</html>
