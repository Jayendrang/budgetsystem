<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List"
	import="SpringSemester.budgetsystem.beans.Expenses"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Budget Expenses</title>
</head>
<body>
	<div>
		<form name="displayExpenses" method="GET"
			action="${pageContext.request.contextPath}/expenses/servExpenses">
			<table border=2>
				<tr>
					<th>EXPENSES ID</th>
					<th>EXPENSES DATE</th>
					<th>EXPENSES TYPE</th>
					<th>EXPENSES DESCRIPTION</th>
					<th>AMOUNT</th>
					<th>REMARK</th>
					<th>CREATED DATE</th>
				</tr>
				<c:forEach items="${expenseslist}" var="expenses">
					<tr>
						<td>${expenses.expenses_id}</td>
						<td>${expenses.expenses_date}</td>
						<td>${expenses.expenses_type}</td>
						<td>${expenses.expenses_desc}</td>
						<td>${expenses.amount}</td>
						<td>${expenses.remark}</td>
						<td>${expenses.created_on}</td>
					</tr>
				</c:forEach>
			</table>
			<div></div>
		</form>
	</div>
</body>
</html>