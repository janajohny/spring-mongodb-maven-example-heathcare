<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<html>
	<head>
	<a href="${pageContext.servletContext.contextPath}"><img src="${pageContext.servletContext.contextPath}/resources/images/drug_panel_672.png"></img></a>
	</head> 
	<body>
	<table>
	<form:form method="post" commandName="drug" action="${pageContext.servletContext.contextPath}/drug/edit">
		<form:hidden path="id"/>
		<tr>
			<td>Drug Id </td>
			<td><form:input path="drugId"/></td>
		</tr>
		<tr>
			<td>Drug Name </td>
			<td><form:input path="drugName"/></td>
		</tr>
		<tr>
			<td>Manufacturer </td>
			<td><form:input path="manufacturer"/></td>
		</tr>
		<tr>
			<td>description</td>
			<td> <form:textarea path="description"/></td>
		</tr>
		<tr>
			<td><input type="submit" value="Save"></td>
		</tr>
	</form:form> 
	</table>
	</body>
</html>
