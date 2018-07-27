<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Save Customer</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/css/style.css" />
</head>
<body>
	<div id="container">
		<div id="header">
			<h1>CRM - Customer Relationship Manager</h1>
		</div>

		<div id="form">
			<h2>Save Customer</h2>
			<form:form action="saveCustomer" modelAttribute="customer"
				method="POST">
				<table>
					<tbody>
						<tr>
							<td><label>First Name</label></td>
							<td><form:input path="firstName" /></td>
						</tr>
						<tr>
							<td><label>Last Name</label></td>
							<td><form:input path="lastName" /></td>
						</tr>
						<tr>
							<td><label>Email</label></td>
							<td><form:input path="email" /></td>
						</tr>
						<tr>
							<td><label></label></td>
							<td><input type="submit" value="Save" /></td>
						</tr>
					</tbody>
				</table>
			</form:form>

			<div style="clear: both;"></div>

			<p>
				<a href="${pageContext.request.contextPath }/customer/list">Back
					to List</a>
			</p>
		</div>
	</div>
</body>
</html>