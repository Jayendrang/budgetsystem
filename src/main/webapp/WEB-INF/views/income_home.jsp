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
		<form name="displayIncome" >
			<table border=2>
				<tr>
					<th>INCOME ID</th>
					<th>INCOME DATE</th>
					<th>INCOME TYPE</th>
					<th>INCOME DESCRIPTION</th>
					<th>AMOUNT</th>
					<th>REMARK</th>
					<th>CREATED DATE</th>
				</tr>
				<c:forEach items="${income_list}" var="incomes">
					<tr>
						<td>${incomes.income_id}</td>
						<td>${incomes.income_date}</td>
						<td>${incomes.income_category}</td>
						<td>${incomes.income_desc}</td>
						<td>${incomes.amount}</td>
						<td>${incomes.remark}</td>
						<td>${incomes.created_on}</td>
					</tr>
				</c:forEach>
			</table>
			<div></div>
		</form>
	</div>
</body>
</html>