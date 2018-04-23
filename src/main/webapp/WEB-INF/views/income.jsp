<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Income</title>
</head>
<body>

	<form>
		<table>
			<tr>
				<td><input type="date" id="date" /></td>
				<td><select id="incomeName">
						<option>Type 1</option>
						<option>Type 2</option>
					</select>
				</td>
				<td><textarea id="description" /></td>
				<td><input type="text" id="incomeAmount"/></td>
				<td><input type="text" id="incomeRemarks" /></td>
			</tr>
		</table>
	</form>
</body>
</html>