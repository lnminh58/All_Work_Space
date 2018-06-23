<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello</title>
</head>
<body>
    <h1>List employees</h1>
    <ul>
        <c:forEach  items="${list}" var="employee">
            <li>${employee.fullName}</li>
        </c:forEach>
    </ul>

</body>
</html>
