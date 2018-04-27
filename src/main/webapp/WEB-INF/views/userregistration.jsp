<%@page import="SpringSemester.budgetsystem.beans.ApplicationData"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>   
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User registration form</title>
<link href="${pageContext.request.contextPath}/resources/style.css" rel="stylesheet"/>

</head>
<body>
<form:form action="${pageContext.request.contextPath}/user/processRegistration" modelAttribute="UserInfo">
<h1>New Registration Information </h1>
<div>First Name  :  <form:input path="user_fname"/></div> 
<div>Last Name : <form:input path="user_lname"/></div> 
<div>E-Mail		: <form:input path="email_id"/></div>
<div>Mobile Contact : <form:input path="mobile_contact" /></div>
<div>Address	: <form:input path="address"/></div>
<div>Password   : <form:password path="password"/></div>
<div>Recovery Question 1: <form:select path="rec1_ques">
							<c:forEach items="${securityQues}" var="questions">
							<form:option value="${questions.key}">${questions.value}</form:option>
							</c:forEach>
							</form:select>
<div>Answer:<form:input path="rec1_ans"/></div>
<div>Recovery Question 1:<form:select path="rec2_ques" >
						<c:forEach items="${securityQues}" var="questions">
							<form:option value="${questions.key}">${questions.value}</form:option>
							</c:forEach>
						</form:select></div>				
 <div>Answer:<form:input path="rec2_ans"/></div>						
		<div><form:button value="Sign up">Sign up </form:button> </div> 
</form:form>


</body>
</html>
