<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>
    
<html>
	<head>
	<a href="${pageContext.servletContext.contextPath}"><img src="${pageContext.servletContext.contextPath}/resources/images/medical-history-938416.png"></img>
	</a>
	</head> 
	<body>
	<br/>
	<p><a href="${pageContext.servletContext.contextPath}/question/add">Add new Question</a></p>
    <br/>
    <table style="width:100%" border="1">
		<tr>
			<td>Manufacturer</td>
			<td>Description</td>
		</tr>
		<c:forEach items="${questions}" var="question">
			<tr>
				<td>${question.question}</td>
				<td>
					<a href="${pageContext.servletContext.contextPath}/question/edit/${question.id}">edit</a>
					<a href="${pageContext.servletContext.contextPath}/question/delete/${question.id}">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	</body>
</html>
