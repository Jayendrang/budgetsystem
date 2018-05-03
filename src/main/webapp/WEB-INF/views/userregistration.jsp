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
<title>Budget System</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/w3.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/font-awesome-4.7.0/css/font-awesome.min.css">
<link href="${pageContext.request.contextPath}/resources/css/styles.css" rel="stylesheet"/>
</head>
<body class="w3-light-grey">

<form:form action="${pageContext.request.contextPath}/user/processRegistration" modelAttribute="UserInfo" style="padding-left: 260px; padding-right: 300px;">
<h1 align="center">New Registration Information </h1>
<div><label for="ufname">First Name  :</label>  <form:input name="ufname" class="login-input" path="user_fname"/></div> 
<div><label for="ulname">Last Name :</label> <form:input name="ulname" class="login-input" path="user_lname"/></div> 
<div><label for="emailid">E-Mail		:</label> <form:input name="emailid" class="login-input" path="email_id"/></div>
<div><label for="umobile">Mobile Contact :</label> <form:input name="umobile" class="login-input" path="mobile_contact" /></div>
<div><label for=name="uaddress">Address	:</label> <form:input name="uaddress" class="login-input" path="address"/></div>
<div><label for="upassword">Password   :</label> <form:password name="upassword" class="login-input" path="password"/></div>

<div><label for="secques1">Recovery Question 1:</label> <form:select name ="secques1" path="rec1_ques">
							<c:forEach items="${securityQues}" var="questions">
							<form:option value="${questions.code}">${questions.details}</form:option>
							</c:forEach>
							</form:select></div>
<div><label for="secans1">Answer:</label><form:input name="secans1" class="login-input" path="rec1_ans"/></div>
<div><label for="recques2">Recovery Question 1:</label><form:select name="recques2" path="rec2_ques" >
						<c:forEach items="${securityQues}" var="questions">
							<form:option value="${questions.code}">${questions.details}</form:option>
							</c:forEach>
						</form:select></div>				
 <div><label for="recans2">Answer:</label><form:input name="recans2" class="login-input" path="rec2_ans"/></div>						
		<div><form:button  class="login-submit" value="Sign up">Sign up </form:button> </div> 
</form:form>
<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/js/scripts.js"></script>
<script type="text/javascript">
function onblurevent(){
	alert("check the name");	
}
</script>

</body>


</html>
