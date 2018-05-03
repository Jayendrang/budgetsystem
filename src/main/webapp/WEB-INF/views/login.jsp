<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<div id="login-page" style="display:block;" class="login-container">
			<div class="imgcontainer">
				<img src="${pageContext.request.contextPath}/resources/images/login_image.png" alt="login" class="login">
			</div>
			<form class="login-form" style="margin-left:35%;margin-right:35%;" action="${pageContext.request.contextPath}/user/validateUser"  method="POST">
				<div class="container">
					<div>
						<label for="uname"><b>Username</b></label>
						<input id="username" class="login-input" type="text" placeholder="Enter Username" name="uname"  required/>
					</div>
					<div>
						<label for="psw"><b>Password</b></label>
						<input id="password" class="login-input" type="password" placeholder="Enter Password" name="psw" required/>
					</div>
						
					<button class="login-submit" onclick="authenticateUser()" type="submit">Login</button>
					<button class="login-submit" onclick="registerUser()" type="button">Register</button>
				</div>
				
				<span id="error-message" style="display:none;padding:16px;" class="w3-text-red">${error_message}</span>
			</form>
		</div>
		<script type="text/javascript">
		function registerUser(){
			var URL = "${pageContext.request.contextPath}/user/newUserRegistration";
			location.href = URL;
		}
		</script>
</body>
</html>