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
	<p><a href="${pageContext.servletContext.contextPath}/doctor/add">Add new doctor</a></p>
    <br/>
    <table style="width:100%" border="1">
            <tr>
                <td>Doctor Id</td>
                <td>First Name</td>
                <td>Last Name</td>
                <td>Configuration</td>
            </tr>
        <c:forEach items="${doctors}" var="doctor">
            <tr>
                <td><a href="${pageContext.servletContext.contextPath}/doctor/detail/">${doctor.employeeId}</a></td>
                <td>${doctor.firstName}</td>
                <td>${doctor.lastName}</td>
                <td>
                    <a href="${pageContext.servletContext.contextPath}/doctor/edit/${doctor.id}">edit</a>
                    <a href="${pageContext.servletContext.contextPath}/doctor/delete/${doctor.id}" >Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
	</body>
</html>
