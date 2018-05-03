<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	window.onload = function() {

		var chart1 = new CanvasJS.Chart("chartContainer", {
			theme : "light2",
			animationEnabled : true,
			exportFileName : "New Year Resolutions",
			exportEnabled : true,
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
		theme : "light2",
		animationEnabled : true,
		exportFileName : "New Year Resolutions",
		exportEnabled : true,
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
</head>
<body>
	<div id="chartContainer" style="height: 370px; width: 100%;"></div>
	<div id="chartContainer1" style="height: 370px; width: 100%;"></div>
	<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
</body>
</html>
