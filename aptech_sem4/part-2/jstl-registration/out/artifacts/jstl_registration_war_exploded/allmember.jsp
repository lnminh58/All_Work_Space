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
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css"
          integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ" crossorigin="anonymous">
    <title>Title</title>
</head>
<body>
<sql:setDataSource var="conn" scope="session"
                   user="sa" password="ngocminh58"
                   url="jdbc:sqlserver://localhost:1433;databaseName=users;"
                   driver="com.microsoft.sqlserver.jdbc.SQLServerDriver"/>
<sql:query dataSource="${conn}" var="result" scope="session">
    SELECT * from thanhvien;
</sql:query>

<div class="container p-5">
    <table class="table table-striped w-75" >
        <thead class="thead-dark">
        <tr>
            <th scope="col">id</th>
            <th scope="col">Username</th>
            <th scope="col">Password</th>
            <th scope="col" class="text-center">Modify</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="row" items="${result.rows}">

            <tr>
                <th scope="row">${row.id}</th>
                <td>${row.username}</td>
                <td>${row.pass}</td>
                <td class="d-flex justify-content-around">
                    <a href="detail.jsp?userId=<c:out value="${row.id}"/>">
                        <i class="fa fa-info"></i>
                    </a>
                    <a href="update.jsp?userId=<c:out value="${row.id}"/>" >
                        <i class="fa fa-edit text-warning"></i>
                    </a>
                    <a href="delete.jsp?userId=<c:out value="${row.id}"/>" onclick="return confirm('Are you sure?')">
                        <i class="fa fa-trash-alt text-danger"></i>
                    </a>
                </td>
            </tr

        </c:forEach>
        </tbody>
    </table>

</div>


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
