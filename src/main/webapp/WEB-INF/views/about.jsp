<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
			<div class="w3-panel"
				style=" position: relative; top: 60px; left: 90px;"
				id="about-page">
				<div class="w3-row-padding" style="margin: 0 0">
					<h3>What ?</h3>
					Assists users in analysing their expenses and look into future
					predictions based on the expenses and income details provided by
					the user.
				</div>
				<br />
				<div class="w3-row-padding" style="margin: 0 0">
					<h3>Why ?</h3>
					Serves as a one-stop tool for consolidating your expenses. Update
					once and get the expenses and income predicted for future Helps in
					planning your budget and the expenses to be under control
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