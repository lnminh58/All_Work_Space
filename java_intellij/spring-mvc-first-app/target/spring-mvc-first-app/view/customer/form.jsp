<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Customer Form</title>

    <link rel="stylesheet" href="/resources/css/style.css">
</head>
<body>

    <i>Fill out the form. Asterisk (*) means required</i>
    <form:form action="/customer/processForm" modelAttribute="customer">
        First Name: <form:input path="firstName"/>
        <br><br>
        Last Name(*): <form:input path="lastName"/>
        <form:errors path="lastName" cssClass="error"/>
        <br><br>
        <input type="submit" value="Submit" />
    </form:form>
</body>
</html>