<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix= "form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix= "security" uri="http://www.springframework.org/security/tags" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
</head>
<body>

<h2>Home page</h2>
	<hr>
	<p>
	Welcome to Paudyal spring family!
	</p>
	
	<hr>
		
		<p>
			User: <security:authentication property="principal.username" />
			<br><br>
			Role (s): <security:authentication property="principal.authorities" />
		</p>
	
	<hr>
	
	<!-- Add a logout button -->
	
	<form:form action="${pageContext.request.contextPath}/logout" method ="POST">
		
		<input type="submit" value ="Logout" />
	
	</form:form>
	
</body>
</html>