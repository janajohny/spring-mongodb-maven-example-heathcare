<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<a href="${pageContext.servletContext.contextPath}">Home</a>
</head>
<body>
<table style="width:100%" >
		<tr>
			<td>Patient</td>
			<td></td>
			<td>Doctor</td>
		</tr>
		<tr>
			<td>Name:${ prescription.patient.patientId}</td>
			<td></td>
			<td>Doctor:${prescription.doctor.employeeId}</td>
		</tr>
		<tr>
			<td>Name:${ prescription.patient.firstName} ${ prescription.patient.lastName}</td>
			<td></td>
			<td>Doctor:${prescription.doctor.firstName} ${prescription.doctor.lastName}</td>
		</tr>
		<tr>
			<td>Create Date:${ prescription.createDate} </td>
			<td></td>
			<td></td>
		</tr>
</table>
<table style="width:100%" border="1">
		<tr>
      		<td>Drug Id</td>
      		<td>Drug Name</td>
      		<td>Description</td>
  		</tr>
  		<c:forEach items="${prescription.drugs}" var="drug">
  			<c:if test="${not empty drug}">
	  			<tr>
	      			<td>${drug.drugId }</td>
	      			<td>${drug.drugName }</td>
	      			<td>${drug.description }</td>
	  			</tr>
  			</c:if>
  		</c:forEach>
	</table>
</body>
</html>