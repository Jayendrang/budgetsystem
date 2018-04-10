<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Budget Expenses</title>
</head>
<body>
<div><form:form action="${pageContext.request.contextPath}/expenses" modelAttribute="expensesobject">
<div>Expenses Description: <form:input path=""/></div>
<div><form:button>Add Expense </form:button></div>

<div></div>
</form:form></div>
</body>
</html>