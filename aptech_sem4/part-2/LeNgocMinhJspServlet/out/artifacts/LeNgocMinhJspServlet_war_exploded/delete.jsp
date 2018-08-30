<%--
  Created by IntelliJ IDEA.
  User: lnmin
  Date: 2018-08-18
  Time: 6:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Here is delete page</h1>
<p style="color:red">
<%
    if (session.getAttribute("message") != null) {

        String message = session.getAttribute("message").toString();
        if (!message.equals("")) {
            out.println(message);
        }
    }
%>
</p>
<form action="delete.do" method="post">
    <input type="text" name="bookId" placeholder="enter book id"><br/><br/>
    <input type="submit" name="submit" value="Delete" />
</form>
</body>
</html>
