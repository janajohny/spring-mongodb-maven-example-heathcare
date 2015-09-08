<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<a href="${pageContext.servletContext.contextPath}"><img src="${pageContext.servletContext.contextPath}/resources/images/medical_record.png"></img></a>
Patient detail
</head>
<body>
	<table style="width: 100%" border="1">
		<tr>
		<td>Patient Id </td>
		<td>${patient.patientId }</td>
		</tr>
		<tr>
		<td>First Name</td>
		<td>${patient.firstName }</td>
		</tr>
		<tr>
		<td>Last Name</td>
		<td>${patient.lastName }</td>
		</tr>
		<tr>
		<td>Age</td>
		<td>${patient.age }</td>
		</tr>
	</table>
</body>
</html>