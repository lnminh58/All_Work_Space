<%--
  Created by IntelliJ IDEA.
  User: lnmin
  Date: 2018-07-24
  Time: 7:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>order</title>
</head>
<body>
    <%
        String currency = request.getParameter("currency_type");
        String amount = request.getParameter("amount");
    %>
    <b> Param Values : </b> <br/><br/>
    <%
        out.println("Currency: " + currency);
        out.println("Amount: " + amount);
    %>
</body>
</html>
