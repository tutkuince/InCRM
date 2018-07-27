<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer List</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/css/style.css" />
</head>
<body>
	<div id="container">
		<div id="header">
			<h1>CRM - Customer Relationship Manager</h1>
		</div>
		<div id="menu">
			<!-- put new button: Add Customer -->
			<input type="button" value="Add Customer"
				onclick="window.location.href='showFormForAdd'; return false;"
				class="add-button">
		</div>
		<table id="customers">
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
			</tr>
			<c:forEach items="${customerList }" var="item">
				<tr>
					<td>${item.firstName }</td>
					<td>${item.lastName }</td>
					<td>${item.email }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>