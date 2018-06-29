<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Shop View By Array</title>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!-- <link href="/css/bootstrap.min.css" rel="stylesheet"> -->
<style>
.error {
	color: #ff0000;
	font-weight: bold;
}

#listShopViewByArray tr:first-child {
	font-weight: bold;
}
</style>

</head>
<body>
	<div class="container">
		<table class="table table-hover " width="500px">
			<thead>
				<tr id="listShopViewByArray">
					<th>ID</th>
					<th>Name</th>
					<th>Local</th>
					<th>Email</th>
				</tr>
			</thead>

			<c:forEach var="arrayShop" items="${arrayShop}">
				<tbody>
					<tr>
						<td>${arrayShop.id}</td>
						<td>${arrayShop.name}</td>
						<td>${arrayShop.local}</td>
						<td>${arrayShop.email}</td>
					</tr>
				</tbody>
			</c:forEach>
		</table>
	</div>
</body>
</html>