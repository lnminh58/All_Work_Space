<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>Student Registration Form</title>
</head>
<body>

	<form:form action="processForm" modelAttribute="student">

		Frist name: <form:input path="firstName" />
		<br>
		<br>
		
		Last name: <form:input path="lastName" />
		<br>
		<br>
		
		Country:
		<form:select path="country">
			<%-- <form:option value="Brazil" label="Brazil"/>
			<form:option value="France" label="France"/>
			<form:option value="Germany" label="Gremany"/>
			<form:option value="India" label="India"/> --%>
			
			<form:options items="${student.countryOptions}" />
		</form:select>
		<br>
		<br>
		Favorite Language:
		Java <form:radiobutton path="favoritelanguage" value="Java"/>
		C# <form:radiobutton path="favoritelanguage" value="C#"/>
		PHP <form:radiobutton path="favoritelanguage" value="PHP"/>
		Ruby <form:radiobutton path="favoritelanguage" value="Ruby"/>
		<br>
		<br>
		Operating Systems:
		
		linux <form:checkbox path="operatingSystems" value="linux"/>
		Mac OS <form:checkbox path="operatingSystems" value="Mac OS"/>
		MS Windows <form:checkbox path="operatingSystems" value="MS Windows"/>
		<br>
		<br>
		<input type="submit" value="Submit">
	</form:form>


</body>
</html>