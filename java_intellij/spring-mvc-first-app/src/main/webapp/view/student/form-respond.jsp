<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>

<body>

Student confirmation page of Spring!
<br><br>
First name: ${student.firstName}
<br><br>
Last name : ${student.lastName}

<br><br>
Country : ${student.country}

<br><br>
Favorite Language : ${student.favoriteLanguage}
<br><br>
Operating Systems :
<ul>
    <c:forEach var="temp" items="${student.operatingSystems}">
        <li> ${temp}</li>
    </c:forEach>
</ul>
</body>

</html>






