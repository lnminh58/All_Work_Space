<%--
  Created by IntelliJ IDEA.
  User: lnminh
  Date: 2018-07-05
  Time: 7:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="POST" action="/uploadFile" enctype="multipart/form-data">
    <table>
        <tr>
                <td>Select a file to upload</td>
            <td><input type="file" name="file"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>
