<%--
  Created by IntelliJ IDEA.
  User: lnmin
  Date: 2018-08-04
  Time: 8:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css"
          integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ" crossorigin="anonymous">
</head>
<body>

<sql:setDataSource var="conn" scope="session"
                   user="sa" password="ngocminh58"
                   url="jdbc:sqlserver://localhost:1433;databaseName=users;"
                   driver="com.microsoft.sqlserver.jdbc.SQLServerDriver"/>
<sql:query dataSource="${conn}" var="result" scope="session">
    SELECT * from thanhvien where id=?;
    <sql:param value="${param.userId}"/>
</sql:query>
<%--<form action="execute-update.jsp" method="post">--%>
<%--<div class="row">--%>

    <%--<c:forEach var="row" items="${result.rows}">--%>
        <%--<div class="card col-6 mx-auto my-5 p-0">--%>
            <%--<h5 class="card-header">Update Form</h5>--%>
            <%--<div class="card-body">--%>
                <%--<input type="hidden" name="userId" value="${param.userId}">--%>
                <%--<div class="input-group mb-3">--%>
                    <%--<div class="input-group-prepend">--%>
                        <%--<span class="input-group-text">Username</span>--%>
                    <%--</div>--%>
                    <%--<input type="text" class="form-control" placeholder="Username" value="${row.username}">--%>
                <%--</div>--%>

                <%--<div class="input-group mb-3">--%>
                    <%--<div class="input-group-prepend">--%>
                        <%--<span class="input-group-text">Password</span>--%>
                    <%--</div>--%>
                    <%--<input type="text" class="form-control" placeholder="Username" value="${row.pass}">--%>
                <%--</div>--%>
                <%--<input type="submit" class="btn btn-block btn-primary" value="Update" name="btnUpdate">--%>
            <%--</div>--%>
        <%--</div>--%>
    <%--</c:forEach>--%>

<%--</div>--%>
<%--</form>--%>
<form action="execute-update.jsp" method="post">
    <c:forEach var="row" items="${result.rows}">
        <input type="hidden" name="userId" value="${param.userId}">
        <br><br>
        username: <input type="text" value="${row.username}" name="username"/>
        <br><br>
        password: <input type="text" value="${row.pass}" name="password"/>
        <br><br>
        <input type="submit" value="Update" name="btnUpdate">
    </c:forEach>
</form>
<a href="allmember.jsp">Go back</a>


<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
        integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>
</body>
</html>
