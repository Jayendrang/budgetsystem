<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/userEvent/addEventReminder">
Reminder Name : <input type="text" name="event_desc" />
Reminder Start Date : <input type="date" name="event_date" />
<input type="submit" name="addEvent" value="Add Reminder"/>
</form>
</body>
</html>