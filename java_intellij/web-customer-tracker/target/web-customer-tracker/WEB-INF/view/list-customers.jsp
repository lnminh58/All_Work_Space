<%--
  Created by IntelliJ IDEA.
  User: lnminh
  Date: 2018-06-25
  Time: 8:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Customer</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
    <div id="wrapper">
        <div id = "header">
            <h2>CRM - Customer Relationship Manager</h2>
        </div>
    </div>
    <div id="container">
        <div id="content">
            <%--put new button: add customer--%>
            <input type="button" value="Add customer"
                   onclick="window.location.href='showFormForAdd'; return false;"
                   class="add-button"/>
            <%--    Add out html table here    --%>
            <table>
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                    <th>Action</th>
                </tr>

                <%--  Loop over and print our customer  --%>

                <c:forEach var="customer" items="${customers}">
                    <%-- construct an "update" link with customer id --%>
                    <c:url var="updateLink" value="/customer/showFormForUpdate">
                        <c:param name="customerId" value="${customer.id}"/>
                    </c:url>



                    <%-- construct an "delete" link with customer id --%>
                    <c:url var="deletelink" value="/customer/delete">
                        <c:param name="customerId" value="${customer.id}"/>
                    </c:url>

                    <tr>
                        <td>${customer.firstName}</td>
                        <td>${customer.lastName}</td>
                        <td>${customer.email}</td>
                        <td>
                            <%--Display the update link --%>
                                <a href="${updateLink}">Update</a>
                                |
                                <a href="${deletelink}" onclick="return confirmDelelte()">delete</a>
                        </td>
                    </tr>
                </c:forEach>

            </table>
        </div>
    </div>
    <script>
        function confirmDelelte() {
           return confirm('Are you sure you want to delete it?');
        }
    </script>

</body>
</html>
