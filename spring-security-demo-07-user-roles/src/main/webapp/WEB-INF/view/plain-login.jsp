<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>

<head>
	<title>Custom Login Page</title>
	<style>
		.failed {
			color: red;
		}
	</style>
</head>

<body>
	<h3>My Custom Login Page</h3>
	<form action="${pageContext.request.contextPath}/authenticateTheUser" method="POST">
		<c:if test="${param.error != null}">
			<i class="failed">You've entered an invalid username or password</i>
		</c:if>
		<c:if test="${param.logout != null}">
			<i class="failed">You've been logged out</i>
		</c:if>
		
		<p>
			User name: <input type="text" name="username" />
		</p>
		
		<p>
			Password: <input type="password" name="password" />
		</p>
		<input type="submit" value="Login"/>
		
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>
</body>
</html>