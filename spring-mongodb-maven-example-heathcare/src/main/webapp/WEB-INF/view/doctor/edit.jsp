<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false" %>
<html>
	<head>
	<a href="${pageContext.servletContext.contextPath}"><img src="${pageContext.servletContext.contextPath}/resources/images/doctor-panel-8546.png" width="100%"></img>
	</a>
	</head> 
	<body>
	<table>
	<form:form method="post" commandName="doctor" action="${pageContext.servletContext.contextPath}/doctor/edit">
		<form:hidden path="id"/>
		<tr>
			<td>Employee Id </td>
			<td><form:input path="employeeId"/></td>
		</tr>
		<tr>
			<td>First Name </td>
			<td><form:input path="firstName"/></td>
		</tr>
		<tr>
			<td>Last Name </td>
			<td><form:input path="lastName"/></td>
		</tr>
		<tr>
			<td>Age</td>
			<td> <form:input path="age"/></td>
		</tr>
		<tr>
			<td><input type="submit" value="Save"></td>
		</tr>
	</form:form> 
	</table>
	</body>
</html>
