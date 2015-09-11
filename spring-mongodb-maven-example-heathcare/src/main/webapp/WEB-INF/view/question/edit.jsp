<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<html>
	<head>
	<a href="${pageContext.servletContext.contextPath}"><img src="${pageContext.servletContext.contextPath}/resources/images/medical-history-938416.png"></img></a>
	</head> 
	<body>
	<table>
	<form:form method="post" commandName="question" action="${pageContext.servletContext.contextPath}/question/edit">
		<form:hidden path="id"/>
		<tr>
			<td>Question</td>
			<td> <form:textarea path="question" cols="50" rows="5"/></td>
		</tr>
		<tr>
			<td><input type="submit" value="Save"></td>
		</tr>
	</form:form> 
	</table>
	</body>
</html>
