<%--
  Created by IntelliJ IDEA.
  User: lnmin
  Date: 2018-08-16
  Time: 6:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<sql:setDataSource var="conn" scope="session"
                   user="sa" password="ngocminh58"
                   url="jdbc:sqlserver://localhost:1433;databaseName=library;"
                   driver="com.microsoft.sqlserver.jdbc.SQLServerDriver"/>
<sql:query dataSource="${conn}" var="result" scope="session">
    SELECT * from category;
</sql:query>
<form action="add-book.do" method="post">
    <input type="text" name="name" placeholder="book name"> <br><br>
    <input type="text" name="author" placeholder="author"> <br><br>
    <select name="category-id">
        <c:forEach var="row" items="${result.rows}">
            <option value="${row.category_id}">${row.category_name}</option>
        </c:forEach>
    </select> <br><br>
    <input type="text" name="pages" placeholder="pages number"> <br><br>
    <input type="submit" name="submit" value="submit">
</form>
</body>
</html>
