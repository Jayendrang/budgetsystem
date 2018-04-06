<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User registration form</title>
<link href="${pageContext.request.contextPath}/resources/style.css" rel="stylesheet"/>

</head>
<body>

<form:form action="${pageContext.request.contextPath}/user/UserRegistrationProcess" modelAttribute="UserInfo">
<h1>New Registration Information </h1>
<div>First Name  :  <form:input path="user_fname"/></div> 
<div>Last Name : <form:input path="user_lname"/></div> 
<div> User type   :  <form:select path="user_type">
				<form:option value="none" label="--Select role---"/>
				<form:option value="admin" label="Administrator"/>
				<form:option value="techspt" label="Tech Support Team member"/>
				<form:option value="Level1" label="Contractor Level 1"/>
				<form:option value="Level2" label="Contractor Level 2"/>
				<form:option value="Level3" label="Contractor Level 3"/>
				</form:select></div>
<div>E-Mail		: <form:input path="email_id"/></div>
<div>Mobile Contact : <form:input path="mobile_contact" /></div>
<div>Address	: <form:input path="address"/></div> 
		<div><form:button value="Sign up">Sign up </form:button> </div> 
</form:form>


</body>
</html>