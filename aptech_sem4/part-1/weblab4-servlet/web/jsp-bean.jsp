<%--
  Created by IntelliJ IDEA.
  User: lnmin
  Date: 2018-06-28
  Time: 8:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
        <jsp:useBean id="probean" scope="session" class="com.aptech.webent.model.ProductsBean"/>
        <jsp:setProperty name="probean" property="proName" value="Nhan"/>
        <jsp:setProperty name="probean" property="proDescription" value="Trai Dep"/>

        <p>Product Name: <jsp:getProperty name="probean" property="proName"/></p>
        <p>Product Decription<jsp:getProperty name="probean" property="proDescription"/></p>
</body>
</html>
