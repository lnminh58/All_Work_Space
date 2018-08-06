<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="ContentType" content="text/html; charset=UTF-8">
    <title>product</title>
</head>
<body>
    <jsp:include page="order.jsp" flush="true">
        <jsp:param name="currency_type" value="Dollar"/>
        <jsp:param name="amount" value="$110"/>
    </jsp:include>

</body>
</html>