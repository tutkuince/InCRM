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
				
			<input type="button"
				value="Sort By Customer Name"
				onclick="window.location.href='orderedList'; return false;"
				class="add-button"> 
				
			<input type="button"
				value="Sort By Customer ID"
				onclick="window.location.href='list'; return false;"
				class="add-button">

		</div>
		<table id="customers">
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${customerList }" var="customer">
				
				<c:url var="updateLink" value="/customer/showFormForUpdate" >
					<c:param name="customerId" value="${customer.id }" />
				</c:url>
				
				<tr>
					<td>${customer.firstName }</td>
					<td>${customer.lastName }</td>
					<td>${customer.email }</td>
					<td><a href="${updateLink }">Update</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>