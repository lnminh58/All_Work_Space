<%--
  Created by IntelliJ IDEA.
  User: lnminh
  Date: 06/09/2018
  Time: 18:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Resgister Student</h1>
<hr>
<s:form action="register" method="post">
    <s:select name="country" list="countries"/>
    <s:submit value="Register"/>
    <s:if test="message!=null">
        <h3><i>
            <s:property value="message"/>
        </i></h3>
    </s:if>
</s:form>

</body>
</html>
