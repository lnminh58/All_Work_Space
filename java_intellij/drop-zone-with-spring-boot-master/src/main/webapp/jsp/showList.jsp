<%--
  Created by IntelliJ IDEA.
  User: minhat
  Date: 28/10/2017
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.6/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>
    <style>
        .jumbotron {
            max-width: 300px;
            max-height: 300px;
        }
    </style>
</head>
<body>
<p>This is image list</p>
<c:if test="${not empty images}">
    <c:forEach items="${images}" var="image">
        <img class="jumbotron" src="${pageContext.request.contextPath}${image.path}"/>
    </c:forEach>
</c:if>
</body>
</html>
