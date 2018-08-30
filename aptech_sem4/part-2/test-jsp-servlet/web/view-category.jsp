<%--
  Created by IntelliJ IDEA.
  User: lnmin
  Date: 2018-08-16
  Time: 6:54 PM
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
    SELECT * from book where category_id=?;
    <sql:param value="${param.categoryID}"/>
</sql:query>
<c:forEach var="row" items="${result.rows}">
    <tr>
        <th>${row.book_name}</th>
        <td>${row.author}</td>
        <td>${row.category_id}</td>
        <td>${row.page_number}</td>
    </tr>
</c:forEach>
</body>
</html>
