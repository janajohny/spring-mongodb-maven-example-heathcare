<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<html>
	<head>
	<a href="${pageContext.servletContext.contextPath}"><img src="${pageContext.servletContext.contextPath}/resources/images/medical_record.png" width="100%"></img>
	</a>
	<h1>Answer</h1>
	</head>
	<body>
	<table>
		<form:form method="post" commandName="answer" action="${pageContext.servletContext.contextPath}/answer/create/${patientId}">
			<form:hidden path="question.id"/>
			<form:hidden path="question.question"/>
			<tr>
				<td>${answer.question.question}</td>
				<td><form:textarea path="answer"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="Save"></td>
			</tr>
		</form:form> 
	</table>
	</body>
</html>
