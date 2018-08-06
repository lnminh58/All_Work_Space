<%--
  Created by IntelliJ IDEA.
  User: lnmin
  Date: 2018-08-04
  Time: 8:42 PM
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
                   url="jdbc:sqlserver://localhost:1433;databaseName=users;"
                   driver="com.microsoft.sqlserver.jdbc.SQLServerDriver"/>
<sql:update dataSource="${conn}" var="count" scope="session">
    update thanhvien set username=? , pass =?
    where id=${param.userId}
    <sql:param value="${param.username}" />
    <sql:param value="${param.password}" />
</sql:update>
    <c:choose>
        <c:when test="${count>0}" >
            <c:redirect url="allmember.jsp" />
        </c:when>
        <c:otherwise>
            loi update
        </c:otherwise>
    </c:choose>
</body>
</html>
