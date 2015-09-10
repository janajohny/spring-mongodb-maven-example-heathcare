<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>
    
<html>
	<head>
	<a href="${pageContext.servletContext.contextPath}"><img src="${pageContext.servletContext.contextPath}/resources/images/drug.png"></img>
	</a>
	</head> 
	<body>
	<br/>
	<p><a href="${pageContext.servletContext.contextPath}/drug/add">Add new Drug</a></p>
    <br/>
    <table style="width:100%" border="1">
		<tr>
			<td>Drug Id</td>
			<td>Drug Name</td>
			<td>Manufacturer</td>
			<td>Description</td>
		</tr>
		<c:forEach items="${drugs}" var="drug">
			<tr>
				<td><a href="${pageContext.servletContext.contextPath}/doctor/detail/">${drug.drugId}</a></td>
				<td>${drug.drugName}</td>
				<td>${drug.manufacturer}</td>
				<td>
					<a href="${pageContext.servletContext.contextPath}/drug/edit/${drug.id}">edit</a>
					<a href="${pageContext.servletContext.contextPath}/drug/delete/${drug.id}">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	</body>
</html>
