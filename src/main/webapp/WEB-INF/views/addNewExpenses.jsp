<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="SpringSemester.budgetsystem.beans.ApplicationData"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<form action="${pageContext.request.contextPath}/expenses/servExpenses" method="POST">
 
<p> Date : <input type="date" name="expensedate" data-date-format="yyyy-mm-dd"/> 
Expense Name :<select name= "expensename"> 
				<c:forEach items="${applicationdata}"  var="expensetypes" >
				<option value="${expensetypes.key}">${expensetypes.key}</option>
			  </c:forEach>
</select> 
Expense Description : <input type="text" name= "expensedesc"/>
Amount : <input type="number" name="expenseamount"/>
Remark : <input type="text" name="expenseremark"/> 

</p>
<input type="submit" value="Add expenses"/>
</form>
</body>
</html>