<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>inserted data</title>
<%@include file="AllCss.jsp"%>
</head>
<body>
	<%@include file="NavBar.jsp"%>
	<table class="table">
		<thead>
			<tr>
				<th scope="col">FirstName</th>
				<th scope="col">LastName</th>
				<th scope="col">Date Of Birth</th>
				<th scope="col">EmailId</th>
				<th scope="col">PhoneNo</th>
				<th scope="col">State</th>
				<th scope="col">District</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${save.firstName}</td>
				<td>${save.lastName}</td>
				<td>${save.dob}</td>
				<td>${save.emailId}</td>
				<td>${save.phNo}</td>
				<td>${save.state}</td>
				<td>${save.district}</td>				
			</tr>
		</tbody>
	</table>
</body>
</html>