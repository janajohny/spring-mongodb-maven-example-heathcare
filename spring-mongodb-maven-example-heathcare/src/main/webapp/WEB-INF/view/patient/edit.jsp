<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<html>
	<head>
	<a href="${pageContext.servletContext.contextPath}"><img src="${pageContext.servletContext.contextPath}/resources/images/medical_record.png"></img>
	</a>
	</head> 
	<body>
	<table>
	<form:form method="post" commandName="patient" action="${pageContext.servletContext.contextPath}/patient/edit">
		<form:input path="id"/>
		<tr>
			<td>Patient Id </td>
			<td><form:input path="patientId"/></td>
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
			<td>BirthDay</td>
			<td> <form:input path="birthDate"/></td>
		</tr>
		<tr>
			<td><input type="submit" value="Save"></td>
		</tr>
	</form:form> 
	</table>
	</body>
</html>
