<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1> Reminders in action </h1>
<form method="post" action="${pageContext.request.contextPath}">
<table width="2">
<th>REMINDER ID</th>
<th>REMINDER EVENT DESCRIPTION</th>
<th>REMINDER DATE</th>
<th>CREATED ON</th>
<th>ACTION</th>
<c:forEach items="${event_list}" var="reminder">
<tr>
<td><input type="text" readonly="readonly" name="event_id" value="${reminder.eventid }"/></td>
<td><input type="text" readonly="readonly" name="event_desc" value="${reminder.event_desc}"/></td>
<td><input type="date" readonly="readonly" name="event_date" value="${reminder.event_start_date}"/></td>
<td><input type="date" readonly="readonly" name="created_on" value="${reminder.created_on}"/></td>
<td><button name="delete" value="delete">Delete</button></td>
</tr>
</c:forEach>
</table>
</form>
<form method="post" action="${pageContext.request.contextPath}/userEvent/addEventReminder">
Reminder Name : <input type="text" name="event_desc" />
Reminder Start Date : <input type="date" name="event_date" />
<input type="submit" name="addEvent" value="Add Reminder"/>
</form>
</body>
</html>