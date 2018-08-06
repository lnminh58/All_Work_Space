<%--
  Created by IntelliJ IDEA.
  User: lnminh
  Date: 2018-08-02
  Time: 9:21 PM
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
<c:if test="${! empty param.btnAdd}">
  <c:if test="${! empty param.Username && ! empty param.Password}">
    <sql:setDataSource var="conn" scope="session"
                       user="sa" password="ngocminh58"
                       url="jdbc:sqlserver://localhost:1433;databaseName=users;"
                       driver="com.microsoft.sqlserver.jdbc.SQLServerDriver"/>
    <sql:update dataSource="${conn}" var="rowCount" scope="session"
                sql="insert into thanhvien(username,pass) values (?,?)">
      <sql:param value="${param.Username}"/>
      <sql:param value="${param.Password}"/>
    </sql:update>
    <c:if test="${rowCount > 0}">
      <span style="color:red">Member Added</span> <br>
      ${param.Username}
    </c:if>
    <c:if test="${rowCount<=0}">
      Can not add this member
    </c:if>
  </c:if>
  <c:if test="${empty param.Username || empty param.Password}">
    <span style="color:red">Please enter information</span> <br>
  </c:if>
</c:if>

<form action="" method="POST">
  Username:
  <input type="text" name="Username"/>
  <br><br>
  Password:
  <input type="text" name="Password"/>
  <br><br>
  <input type="submit" value="Add" name="btnAdd"/>
</form>
</body>
</html>
