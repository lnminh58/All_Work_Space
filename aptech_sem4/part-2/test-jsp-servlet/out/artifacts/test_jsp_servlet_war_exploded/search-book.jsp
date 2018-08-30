<%--
  Created by IntelliJ IDEA.
  User: lnmin
  Date: 2018-08-04
  Time: 6:56 PM
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
<c:if test="${param.searchText!=null}">

<sql:setDataSource var="conn" scope="session"
                   user="sa" password="ngocminh58"
                   url="jdbc:sqlserver://localhost:1433;databaseName=library;"
                   driver="com.microsoft.sqlserver.jdbc.SQLServerDriver"/>
<c:choose>
    <c:when test='${param.searchType.equalsIgnoreCase("book")}'>
        <sql:query dataSource="${conn}" var="result" scope="session">
            select * from book where book_name like ?
            <sql:param >%${param.searchText}%</sql:param>
        </sql:query>
    </c:when>
    <c:otherwise>
        <sql:query dataSource="${conn}" var="result" scope="session">
            select * from book where author like ?
            <sql:param >%${param.searchText}%</sql:param>
        </sql:query>
    </c:otherwise>
</c:choose>
</c:if>

<form action="" method="get">
    <input type="text" name="searchText">
    <select name="searchType">
        <option value="book">Book name</option>
        <option value="author">Author name</option>
    </select>
    <input type="submit" value="submit">
</form>
<c:forEach var="row" items="${result.rows}">
  <tr>
    <th>${row.book_name}</th>
    <td>${row.author}</td>
    <td>${row.category_id}</td>
    <td>${row.page_number}</td>
  </tr>
    <br>
</c:forEach>
</body>
</html>
