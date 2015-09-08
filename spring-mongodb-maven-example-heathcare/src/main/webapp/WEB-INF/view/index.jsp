<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>
    
<html>
	<head>
	<a href="${pageContext.servletContext.contextPath}"><img src="${pageContext.servletContext.contextPath}/resources/images/image1.jpg"></img>
	</a>
	</head> 
	<body>
	<br/>
	<p><a href="${pageContext.servletContext.contextPath}/patient/add">Add new</a></p>
	<p><a href="${pageContext.servletContext.contextPath}/doctor/">Manage Doctor</a></p>
    <br/>
    <table style="width:100%" border="1">
            <tr>
                <td>Patient Id</td>
                <td>First Name</td>
                <td>Last Name</td>
                <td>Configuration</td>
            </tr>
        <c:forEach items="${patients}" var="patient">
            <tr>
                <td><a href="${pageContext.servletContext.contextPath}/patient/detail/${patient.patientId}">${patient.patientId}</a></td>
                <td>${patient.firstName}</td>
                <td>${patient.lastName}</td>
                <td>
                    <a href="${pageContext.servletContext.contextPath}/medicalhistory/update/${patient.patientId}">Medical history</a>
                    <a href="${pageContext.servletContext.contextPath}/patient/delete/${patient.patientId}" >Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
	</body>
</html>
