<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>
	<head>
		<title>Home Page</title>
	</head>
	<body>
		<h2>Company Home page</h2>
		<hr>
		<p>
		Welcome to the home page!
		</p>
		
		<p>
			User: <security:authentication property="principal.username" />
			<br><br>
			Role(s): <security:authentication property="principal.authorities" /> 
		</p>
		
		<hr>
			<p>
				<a href="${pageContext.request.contextPath}/leaders">Leadership Meeting</a>
			</p>
			
			<p>
				<a href="${pageContext.request.contextPath}/systems">Systems Info</a>
			</p>
		</hr>
		
		<form:form action="${pageContext.request.contextPath}/logout" method="POST">
			<input type="submit" value="Logout" />
		</form:form>
	</body>
</html>