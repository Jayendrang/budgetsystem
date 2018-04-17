<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import = "java.util.List" 
	import ="SpringSemester.budgetsystem.beans.Expenses"%> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Budget Expenses</title>
</head>
<body>
<div><form name="displayExpenses" method="GET" action="${pageContext.request.contextPath}/expenses/servExpenses" >


<%
List<Expenses> listofexp = (List<Expenses>)request.getAttribute("expeneslist");
for(Expenses exp : listofexp){
out.println(exp.getExpenses_desc());}
%>
<div></div>
</form></div>
</body>
</html>