<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
<link href="${pageContext.request.contextPath}/resources/style.css" rel="stylesheet"/>
</head>
<body>
<h1 style="color:blue">Welcome</h1>
<form:form action="${pageContext.request.contextPath}/user/validateUser" modelAttribute="userLogin" method="GET" >
<div>Username :<form:input path="username"/></div>
<div>Password :<form:input path="password"/></div>
<div><form:button value="submit">Login</form:button></div>
</form:form>

<a href="${pageContext.request.contextPath}/user/newUserRegistration">Register new user.!</a>
</body>

</html>