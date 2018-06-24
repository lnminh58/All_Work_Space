<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
<head>
    <title>Employee Management</title>

</head>

<body>

<ul>
    <c:forEach items="${list}" var="e">
        <li>${e.fullName}</li>
    </c:forEach>
</ul>
</body>
</html>