<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


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
		<form:form action="${pageContext.request.contextPath}/logout" method="POST">
			<input type="submit" value="Logout" />
		</form:form>
	</body>
</html>