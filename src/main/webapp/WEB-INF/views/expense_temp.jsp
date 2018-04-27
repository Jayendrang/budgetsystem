<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="expenses.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="/js/expenses.js">

</script>
<title>Insert title here</title>
</head>
<body>
	
	<input type="button" id="button" value="+" onclick="method"></input>
	<form>
		<table id="table">
		<tr>
			<th>
				<td>Date</td>
				<td>Expense Name</td>
				<td>Expense Description</td>
				<td>Amount</td>
				<td>Remark</td>
			</th>
		</tr>
		<tr>
			<td><input type="text" name="expensedate_0" data-date-format='yyyy-mm-dd'/> </input></td>
			<td><select id="expenseName" name="expensesName_0"> 
									<c:forEach items="${applicationdata}"  var="expensetypes" >
									<option value="${expensetypes.value}">${expensetypes.value}</option>
			  						</c:forEach>
							</select></td>
			<td><input type="text" name="expensedesc_0" /></td>
			<td><input type="number" name="expenseamount_0"/></td>
			<td><input type="text" name="expenseremark_0"/></td>
		</tr>
	</table>
	<input type="submit" value="Submit"></input>
	</form>
	<input type="button" id="button" value="+"></input>
</body>
</html>