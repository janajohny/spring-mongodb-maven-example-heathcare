<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>
    
<html>
	<head>
	<a href="${pageContext.servletContext.contextPath}"><img src="${pageContext.servletContext.contextPath}/resources/images/medical_record.png"></img>
	</a>
	</head> 
	<body>
	<br/>
	<p><a href="${pageContext.servletContext.contextPath}/prescription/add">Add new Prescription</a></p>
    <br/>
    <table style="width:100%" border="1">
		<tr>
			<td>Id</td>
			<td>Patient Id</td>
			<td>Doctor Id</td>
			<td>Option</td>
		</tr>
		<c:forEach items="${prescriptions}" var="prescription">
			<tr>
				<td><a href="${pageContext.servletContext.contextPath}/doctor/detail/">${prescription.id}</a></td>
				<td>${prescription.patient.patientId}</td>
				<td>${prescription.doctor.employeeId}</td>
				<td>
					<a href="${pageContext.servletContext.contextPath}/prescription/edit/${prescription.id}">edit</a>
					<!-- <a href="${pageContext.servletContext.contextPath}/drug/edit/${prescription.id}">drug</a>-->
					<a href="${pageContext.servletContext.contextPath}/prescription/delete/${prescription.id}">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	</body>
</html>
