<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>List Shop View</title>
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <!-- <link href="/css/bootstrap.min.css" rel="stylesheet"> -->
  <style>
    .error {
      color: #ff0000;
      font-weight: bold;
    }

    #listShopView tr:first-child {
      font-weight: bold;
    }
  </style>

</head>
<body>
<form method="get" action="/searchByName">
  <%--<label>local</label><input type="text"  name="name">--%>
  <%--<label>name</label></label><input type="text"  name="local">--%>
  <label>datefrom</label></label><input type="text"  name="date">
  <label>dateto</label></label><input type="text"  name="date">

  <input type="submit" value="tim">
</form>
<%--<form method="get" action="/searchByName">
	<input type="text" required="" name="name">
	<input type="submit" value="TìmLocal">
</form>--%>
<div class="container">
  <table class="table table-hover " width="500px">
    <thead>
    <tr id="listShopView">
      <th>ID</th>
      <th>Name</th>
      <th>Local</th>
      <th>Email</th>
      <th>Date</th>
    </tr>
    </thead>

    <c:forEach var="listShops" items="${ListAllShop}">
      <tbody>
      <tr>
        <td>${listShops.id}</td>
        <td>${listShops.name}</td>
        <td>${listShops.local}</td>
        <td>${listShops.email}</td>
        <td>${listShops.date}</td>
      </tr>
      </tbody>
    </c:forEach>
  </table>
</div>


</body>
</html>