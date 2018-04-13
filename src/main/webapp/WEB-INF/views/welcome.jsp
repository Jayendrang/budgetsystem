<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="SpringSemester.budgetsystem.beans.SessionInfo"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
<link href="${pageContext.request.contextPath}/resources/style.css" rel="stylesheet"/>
</head>
<body>

<h2>Hello,  ${session_Info.lname},${session_Info.fname}</h2>
<h2>Role    :  ${session_Info.sessionId }</h2> 
</body>
</html>