<%--
  Created by IntelliJ IDEA.
  User: lnmin
  Date: 2018-06-18
  Time: 9:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student registration pages</title>
</head>
<body>
    <form:form action="/student/processForm" modelAttribute="student">
        First name: <form:input path="firstName"/>
        <br><br>
        Last name: <form:input path="lastName"/>
        <input type="text" name="firstName" value="${student.firstName}"/>
        <br><br>
        Country : 
            <form:select path="country">
                <%--<form:option value="Brazil" label="Brazil"/>--%>
                <%--<form:option value="France" label="France"/>--%>
                <%--<form:option value="Germany" label="Germany"/>--%>
                <%--<form:option value="India" label="India"/>--%>
                <form:options items="${countryOptions}"/>


            </form:select>
        <br><br>

        <br><br>
        Favorite Language:
        <%--Java <form:radiobutton path="favoriteLanguage" value="Java"/>--%>
        <%--C# <form:radiobutton path="favoriteLanguage" value="C#"/>--%>
        <%--PHP <form:radiobutton path="favoriteLanguage" value="PHP"/>--%>
        <%--Ruby <form:radiobutton path="favoriteLanguage" value="Ruby"/>--%>
        <form:radiobuttons path="favoriteLanguage" items="${favoriteLanguageOptions}"/>
        <br><br>

        Operating Systems:

        <%--Linux <form:checkbox path="operatingSystems" value="linux"/>--%>
        <%--Mac OS <form:checkbox path="operatingSystems" value="Mac OS"/>--%>
        <%--MS Windows <form:checkbox path="operatingSystems" value="MS Windows"/>--%>
        <form:checkboxes path="operatingSystems" items="${operatingSystemOptions}"/>
        <br><br>
        <input type="submit" value="Confirm"/>
    </form:form>
</body>
</html>
