<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
</head>

<body>
	<form:form action="processForm" modelAttribute="student">
		First name: <form:input path="firstName" />
		<br><br>
		
		Last name: <form:input path="lastName" />
		
		<br><br>
		
		<form:select path="country">
			<form:options items="${student.countryOptions}" />
		</form:select>
		
		<br><br>
		
		Favorite Language:
		Java <form:radiobutton path="favoriteLanguage" value="Java" />
		Python <form:radiobutton path="favoriteLanguage" value="Python" />
		Ruby <form:radiobutton path="favoriteLanguage" value="Ruby" />
		
		<br><br>
		
		Operating Systems:
		macOS <form:checkbox path="operatingSystems" value="macOS" />
		Windows <form:checkbox path="operatingSystems" value="windows" />
		
		<input type="submit" value="submit" />
	</form:form>
</body>

</html>