<%--
  Created by IntelliJ IDEA.
  User: lnmin
  Date: 2018-06-26
  Time: 9:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Save Customer</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>CRM - Customer Relationship Manager</h2>
    </div>
</div>
<div id="container">
    <h3>Save Customer</h3>
    <form:form action="saveCustomer" method="POST" modelAttribute="customer">
        <%-- need to associate this data with customer id --%>
        <form:hidden path="id"/>
        <table>
            <tbody>
                <tr>
                    <td><lablel>First name :</lablel></td>
                    <td><form:input path="firstName"/></td>
                </tr>
                <tr>
                    <td><lablel>Last name :</lablel></td>
                    <td><form:input path="lastName"/></td>
                </tr>
                <tr>
                    <td><lablel>Email :</lablel></td>
                    <td><form:input path="email"/></td>
                </tr>
                <tr>
                    <td><lablel></lablel></td>
                    <td><input type="submit" value="save" class="save"/></td>
                </tr>
            </tbody>
        </table>
    </form:form>

    <div style="clear: both;"></div>
    <p>
        <a href="${pageContext.request.contextPath}/customer/list">Back to list</a>
    </p>
</div>

</body>
</html>
