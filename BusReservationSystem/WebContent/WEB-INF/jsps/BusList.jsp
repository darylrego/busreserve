<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search and filter details</title>
</head>
<body>
<h1>Bus List</h1>
		<table border="1">
			<tr>
				<th>Bus Number</th>
				<th>Source</th>
				<th>Destination</th>
				<th>Departure Time</th>
				<th>Arrival Time</th>
			</tr>
			
		<c:forEach items="${requestScope.list}" var="bus">
			<tr>
				<td>${bus.busno}</td>
				<td>${bus.source}</td>
				<td>${bus.destination}</td>
				<td>${bus.departureTime}</td>
				<td>${bus.arrivalTime}</td>
			</tr>
		</c:forEach>	
</body>
</html>