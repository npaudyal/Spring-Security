<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix= "form" uri="http://www.springframework.org/tags/form" %>
 
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
	
	<!-- Add a logout button -->
	
	<form:form action="${pageContext.request.contextPath}/logout" method ="POST">
		
		<input type="submit" value ="Logout" />
	
	</form:form>
	
</body>
</html>