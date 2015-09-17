<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<html>
	<head>
	<a href="${pageContext.servletContext.contextPath}"><img src="${pageContext.servletContext.contextPath}/resources/images/medical_record.png" width="100%"></img></a>
	</head> 
	<body>
	<table>
	<form:form method="post" commandName="prescription" action="${pageContext.servletContext.contextPath}/prescription/edit/">
		<tr>
			<form:hidden path="id" />
      		<td>Patient:</td>
      		<td><form:select path="patient.id" >
      				<form:options items="${patientList}" itemLabel="patientId" itemValue="id" />
      			</form:select>
      		</td>
  		</tr>
  		<tr>
      		<td>Doctor:</td>
      		<td><form:select path="doctor.id" items="${doctorList}" itemLabel="employeeId" itemValue="id"/></td>
  		</tr>
  		<tr>
			<td>Description</td>
			<td><form:textarea path="description"/></td>
		</tr>
		<tr>
			<td><input type="submit" value="Save"></td>
		</tr>
	</form:form> 
	</table>
	<form:form method="post" commandName="drug" action="${pageContext.servletContext.contextPath}/prescription/drug/add/${prescription.id}">
		<p>Add drug</p>
		<form:select path="id" >
      		<form:options items="${drugs}" itemLabel="drugId" itemValue="id" />
     	</form:select>
     	<td><form:textarea path="description"/></td>
     	<input type="submit" value="Add Drug"/>
    </form:form>
	<table>
		<tr>
      		<td>Drug Id</td>
      		<td>Drug Name</td>
      		<td>Description</td>
      		<td></td>
  		</tr>
  		<c:forEach items="${prescription.drugs}" var="drug">
  			<c:if test="${not empty drug}">
	  			<tr>
	      			<td>${drug.drugId }</td>
	      			<td>${drug.drugName }</td>
	      			<td>${drug.description }</td>
	      			<td><a href="${pageContext.servletContext.contextPath}/prescription/drug/delete/${prescription.id}/${drug.id}">delete</a></td>
	  			</tr>
  			</c:if>
  		</c:forEach>
	</table>
	</body>
</html>
