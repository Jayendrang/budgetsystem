<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="SpringSemester.budgetsystem.beans.SessionInfo"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page import="java.util.*"%>
<%@ page import="com.google.gson.Gson"%>
<%@ page import="com.google.gson.JsonObject"%>

<%
	Gson gsonObj = new Gson();
	Map<Object, Object> map = null;
	Map<String, Double> incomeMap = (Map<String, Double>) request.getAttribute("incomeMapData");
	Map<String, Double> expenseMap = (Map<String, Double>) request.getAttribute("expenseMapData");

	List<Map<Object, Object>> expenselist1 = new ArrayList<Map<Object, Object>>();
	List<Map<Object, Object>> incomelist1 = new ArrayList<Map<Object, Object>>();
	for (Map.Entry<String, Double> expensesData : expenseMap.entrySet()) {
		map = new HashMap<Object, Object>();
		map.put("label", expensesData.getKey());
		map.put("y", expensesData.getValue());
		expenselist1.add(map);
	}
	for (Map.Entry<String, Double> incomeData : incomeMap.entrySet()) {
		map = new HashMap<Object, Object>();
		map.put("label", incomeData.getKey());
		map.put("y", incomeData.getValue());
		incomelist1.add(map);
	}
	String expensedataPoints = gsonObj.toJson(expenselist1);
	String incomedataPoint = gsonObj.toJson(incomelist1);
%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Budget System</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/w3.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/font-awesome-4.7.0/css/font-awesome.min.css">
<link href="${pageContext.request.contextPath}/resources/css/styles.css" rel="stylesheet"/>
</head>
<body class="w3-light-grey">

<!-- <h2>Hello,  ${session_Info.lname},${session_Info.fname}</h2>
<h2>Role    :  ${session_Info.sessionId }</h2> 
 -->
<div id="main-page">
			<!-- Top container -->
			<div class="w3-bar w3-top w3-blue-grey w3-large" style="z-index:4">
			  <button class="w3-bar-item w3-button w3-hover-none w3-hover-text-light-grey" onclick="w3_open();"><i class="fa fa-bars"></i> Expense Predictor</button>
			  <span class="w3-bar-item w3-right">Welcome, <strong>${session_Info.fname} ${session_Info.lname}</strong></span>
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
			<div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

			<!-- !PAGE CONTENT! -->
			<div class="w3-main" style="margin-top:70px;">
				<div class="w3-panel" style="display:block;" id="home-page">
					<div class="w3-row-padding w3-margin-bottom">
						<div class="w3-quarter">
							<form action="${pageContext.request.contentType}/income/serveIncome" method="get" name="incomeForm" enctype="text/plain" >
							<div class="w3-container w3-blue w3-padding-16" style="cursor:pointer" onclick="w3_close();getIncomeServlet();">
								<div class="w3-left"><i class="fa fa-money w3-xxxlarge"></i></div>
								<div class="w3-right"><h4>Income</h4></div>
								<div class="w3-clear"></div>
								<br/>
							</div>
							</form>
						</div>
						<div class="w3-quarter">
						<form action="${pageContext.request.contentType}/expenses/serveExpenses" method="get" name="expensesForm" enctype="text/plain">
							<div class="w3-container w3-red w3-padding-16" style="cursor:pointer" onclick="w3_close();getExpensesServlet();">
								<div class="w3-left"><i class="fa fa-shopping-bag w3-xxxlarge"></i></div>
								<div class="w3-right"><h4>Expenses</h4></div>
								<div class="w3-clear"></div>
								<br/>
							</div>
						</form>
						</div>
						
						<div class="w3-quarter">
						<form action="${pageContext.request.contextPath}/userEvent/getAllReminder" method="get" name="schedulingform" enctype="text/plain">
							<div class="w3-container w3-teal w3-padding-16" style="cursor:pointer" onclick="w3_close();getSchedulingServlet();">
								<div class="w3-left"><i class="fa fa-calendar w3-xxxlarge"></i></div>
								<div class="w3-right"><h4>Scheduling</h4></div>
								<div class="w3-clear"></div>
								<br/>
							</div>
							</form>
						</div>
						<div class="w3-quarter" style="cursor:pointer" onclick="showPredictionsPage();w3_close();">
							<div class="w3-container w3-orange w3-text-white w3-padding-16">
								<div class="w3-left"><i class="fa fa-area-chart w3-xxxlarge"></i></div>
								<div class="w3-right"><h4>Future Predictions</h4></div>
								<div class="w3-clear"></div>
								<br/>
							</div>
						</div>
					</div>
					<div class="w3-row-padding" style="margin:0 -16px">
						<div class="w3-half">
						<div id="chartContainer" style="float: right" >			
						</div>
						</div>
						<div class="w3-half">
						<div id="chartContainer1">
						</div>
						</div>
					</div>
				</div>
				
				
				
				<!-- Footer -->
				<div class="w3-bar w3-bottom w3-blue-grey" style="z-index:4">
					<p style="text-align:center;">Expense Predictor &copy; 2018</p>
				</div>
				<!-- End page content -->
			</div>
		</div>
 <script src="${pageContext.request.contextPath}/resources/js/canvas.min.js"></script>
 <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/scripts.js"></script>
 <script type="text/javascript">
	window.onload = function() {

		var chart1 = new CanvasJS.Chart("chartContainer", {
			//theme : "light2",
			backgroundColor: "#F1F1F1",
			animationEnabled : true,
			exportFileName : "New Year Resolutions",
			exportEnabled : false,
			title : {
				text : "Expenses of current month"
			},
			data : [ {
				type : "pie",
				showInLegend : true,
				legendText : "{label}",
				toolTipContent : "{label}: <strong>{y}$</strong>",
				indexLabel : "{label} {y}$",
				dataPoints :
<%out.print(expensedataPoints);%>
	} ]
		});
	chart1.render();	
	
	var chart2 = new CanvasJS.Chart("chartContainer1", {
		//theme : "light2",
		backgroundColor: "#F1F1F1",
		animationEnabled : true,
		exportFileName : "New Year Resolutions",
		exportEnabled : false,
		title : {
			text : "Income details of current month"
		},
		data : [ {
			type : "pie",
			showInLegend : true,
			legendText : "{label}",
			toolTipContent : "{label}: <strong>{y}$</strong>",
			indexLabel : "{label} {y}$",
			dataPoints :
<%out.print(incomedataPoint);%>
} ]
	});
	chart2.render();
	
	}
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