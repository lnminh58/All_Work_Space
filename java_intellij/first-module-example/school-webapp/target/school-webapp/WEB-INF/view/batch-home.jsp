<%--
  Created by IntelliJ IDEA.
  User: lnmin
  Date: 2018-06-22
  Time: 2:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <ul>
        <c:forEach var="batch" items="${batchs}">
            <li>batch.name</li>
        </c:forEach>
    </ul>
</body>
</html>
