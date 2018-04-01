<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Student Registration Form</title>
</head>
<body>

	<form:form action="processForm" modelAttribute="student">
        First name : <form:input path="firstName" />
		<br>
        Last name : <form:input path="lastName" />
		<br>
        Country:
        <form:select path="country">
        	<%-- <form:option value="Brazil" label="Brazil"/> --%>
			<form:options items="${student.countryOptions}" />

		</form:select>

		<br><br>
		Favorite Language :
		Java<form:radiobutton path="favoriteLanguage" value="Java"/>
		C#<form:radiobutton path="favoriteLanguage" value="C#"/>
		PHP<form:radiobutton path="favoriteLanguage" value="PHP"/>
		Ruby<form:radiobutton path="favoriteLanguage" value="Ruby"/>
		<br><br>
		
		Operation System : 
		linux <form:checkbox path="operatingSystems" value="Linux"/>
		Mac OS <form:checkbox path="operatingSystems" value="Mac OS"/>
		MS Window <form:checkbox path="operatingSystems" value="MS Window"/>
		<br><br>
		<input type="submit" value="Submit" />
		<br>
	</form:form>

</body>
</html>