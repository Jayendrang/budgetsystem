<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Budget System</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/w3.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/font-awesome-4.7.0/css/font-awesome.min.css">
<link href="${pageContext.request.contextPath}/resources/css/styles.css"
	rel="stylesheet" />

</head>
<body class="w3-light-grey">
	<div id="main-page">
		<!-- Top container -->
		<div class="w3-bar w3-top w3-blue-grey w3-large" style="z-index: 4">
			<button
				class="w3-bar-item w3-button w3-hover-none w3-hover-text-light-grey"
				onclick="w3_open();">
				<i class="fa fa-bars"></i> Expense Predictor
			</button>
			<span class="w3-bar-item w3-right">Welcome, <strong>${session_Info.fname}
					${session_Info.lname}</strong></span>
		</div>

		<!-- Sidebar/menu -->
		<!-- Sidebar/menu -->
			<nav class="w3-sidebar w3-white w3-animate-left" style="z-index:3;width:300px;display:none;top:43px;" id="mySidebar"><br>
				<div class="w3-container">
					<h5>Dashboard</h5>
				</div>
				<div class="w3-bar-block">
					<a href="#" class="w3-bar-item w3-button w3-padding-16 w3-hide-large w3-dark-grey w3-hover-black" onclick="w3_close()" title="close menu"><i class="fa fa-remove fa-fw"></i>  Close Menu</a>
					<a href="#" onclick="showHomePage();w3_close();" class="w3-bar-item w3-button w3-padding w3-blue"><i class="fa fa-home fa-fw"></i>  Home</a>
					<a href="#" onclick="showAboutPage();w3_close();" class="w3-bar-item w3-button w3-padding"><i class="fa fa-info fa-fw"></i>  About</a>
					<a href="#" onclick="showContactUsPage();w3_close();" class="w3-bar-item w3-button w3-padding"><i class="fa fa-envelope fa-fw"></i>  Contact Us</a>
					<a href="#" onclick="logout();w3_close();" class="w3-bar-item w3-button w3-padding"><i class="fa fa-power-off fa-fw"></i>  Log Out</a>
				</div>
			</nav>


		<!-- Overlay effect when opening sidebar on small screens -->
		<div class="w3-overlay w3-hide-large w3-animate-opacity"
			onclick="w3_close()" style="cursor: pointer" title="close side menu"
			id="myOverlay"></div>

		<!-- !PAGE CONTENT! -->
		<div class="w3-main" style="margin-top: 70px;">
			<div class="w3-panel" style="display: block;" id="home-page">
				<div class="w3-row-padding w3-margin-bottom">


					<h1>Reminders in action</h1>
					<div>
						<form method="post" action="${pageContext.request.contextPath}">
							<table class="w3-table w3-striped w3-white">
								<tr>
									<th></th>
									<th>REMINDER ID</th>
									<th>REMINDER EVENT DESCRIPTION</th>
									<th>REMINDER DATE</th>
									<th>CREATED ON</th>

								</tr>

								<c:forEach items="${event_list}" var="reminder">
									<tr class="content">
										<td><i class="fa fa-bell w3-text-red w3-large"></i></td>
										<td>${reminder.eventid }</td>
										<td>${reminder.event_desc}</td>
										<td>${reminder.event_start_date}</td>
										<td>${reminder.created_on}</td>
									</tr>

									<tr class="errormessage">${message}</tr>
								</c:forEach>
							</table>
						</form>
					</div>
					<br>
					<div>
						<form method="post"
							action="${pageContext.request.contextPath}/userEvent/addEventReminder">
							<div>
								<label for="event_desc"> Reminder Name</label> <input
									type="text" class="login-input" name="event_desc" />
							</div>
							<div>
								<label for="event_date">Reminder Start Date</label> <input
									type="date" class="login-input" name="event_date" />
							</div>
							<div>
								<input type="submit" class="login-submit" name="addEvent"
									value="Add Reminder" />
							</div>
						</form>
					</div>
				</div>
			</div>
			<!-- Footer -->
			<div class="w3-bar w3-bottom w3-blue-grey" style="z-index: 4">
				<p style="text-align: center;">Expense Predictor &copy; 2018</p>
			</div>
		</div>
	</div>

	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/js/scripts.js">
		
	</script>

<script type='text/javascript'>


function getIncomeServlet(){
	var URL = "${pageContext.request.contextPath}/income/serveIncome";
	location.href = URL;
	
}
function getExpensesServlet(){
	var URL = "${pageContext.request.contextPath}/expenses/serveExpenses";
	location.href = URL;
}
function getSchedulingServlet(){
	var URL = "${pageContext.request.contextPath}/userEvent/getAllReminder";
	location.href = URL;
}
function showAboutPage(){
	var URL = "${pageContext.request.contextPath}/aboutus";
	location.href = URL;
}
function showContactUsPage(){
	var URL = "${pageContext.request.contextPath}/contactus";
	location.href = URL;
}
function showHomePage(){
	var URL = "${pageContext.request.contextPath}/user/homepage";
	location.href = URL;
}
function logout(){
	var URL = "${pageContext.request.contextPath}/logout";
	location.href = URL;
}
</script>
</body>

</html>