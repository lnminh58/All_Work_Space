<%--
  Created by IntelliJ IDEA.
  User: lnmin
  Date: 2018-06-23
  Time: 8:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="ContentType" content="text/html; charset=UTF-8">
    <%--<style>--%>
    <%--body{--%>
    <%--min-height: 800px;--%>
    <%--background: linear-gradient(120deg,teal,palegreen);--%>
    <%--}--%>
    <%--a {--%>
    <%--color: lightgoldenrodyellow;--%>
    <%--text-decoration: none;--%>
    <%--font-size: 20px;--%>
    <%--font-weight: bold;--%>
    <%--}--%>
    <%--</style>--%>
    <title>Dynamic Content Inclusion</title>
</head>
<body>
<%--<a href="/login.do"> Login</a>--%>
<%--<br><br>--%>
<%--<a href="/register.do"> Registration</a>--%>
<%--<br><br>--%>
<%--<a href="/giaiphuongtrinh.jsp"> Giai phuong trinh</a>--%>
<%--<br><br>--%>
<%--<a href="/buy.jsp"> Mua Hàng</a>--%>
<h4 style="color: teal ">
    Displaying Current Date and Time
</h4>

<b>Today is:
    <jsp:include page="printdate.jsp" />
    <%--<jsp:forward page="printdate.jsp" />--%>



</b>

<p>
    <i> The Date and Time are displayed as a result of evaluation of another JSP page. </i>
</p>

</body>
</html>
