<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="all_css.jsp"%>
</head>
<body>
	<%@include file="navbar.jsp"%>
	<form action="viewAll" method="get">
		<input type="submit" class="btn btn-success">
	</form>
	<table class="table table-bordered">
		<thead>
			<tr>
				<th scope="col">Name</th>
				<th scope="col">Email</th>
				<th scope="col">Address</th>
				<th scope="col">Contact</th>
				<th scope="col">Rooms</th>
				<th scope="col">RoomType</th>
				<th scope="col">No.OfNights</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${dtoValue}" var="d">
				<tr>
					<td>${d.name}</td>
					<td>${d.emailId}</td>
					<td>${d.address}</td>
					<td>${d.phoneNumber}</td>
					<td>${d.rooms}</td>
					<td>${d.roomType}</td>
					<td>${d.noOfNights}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<h1>${message4}</h1>
	<%@include file="footer.jsp"%>
</body>
</html>