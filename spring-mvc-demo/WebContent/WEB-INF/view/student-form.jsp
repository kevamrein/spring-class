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
			<form:option value="Brazil" label="Brazil" />
			<form:option value="France" label="France" />
			<form:option value="Germany" label="Germany" />
		</form:select>
		
		<br><br>
		
		<input type="submit" value="submit" />
	</form:form>
</body>

</html>