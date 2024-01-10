<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="all_css.jsp"%>
</head>
<body>
	<%@ include file="navbar.jsp"%>
	<form action="findByName" method="get">
		<div class="text-center">
			<input type="search" placeholder="Search" name="name"> <input type="submit" class="btn btn-success">
		</div>
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
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${nm}" var="me">
					<tr>
						<td>${me.name}</td>
						<td>${me.emailId}</td>
						<td>${me.address}</td>
						<td>${me.phoneNumber}</td>
						<td>${me.rooms}</td>
						<td>${me.roomType}</td>
						<td>${me.noOfNights}</td>
						<td><a href="Update.jsp" class="btn btn-sm btn-primary">Update</a> <a href="deleteByName/${me.name}" class="btn btn-sm btn-danger m-1">Delete</a></td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
	</form>
	<h2>${success}</h2>
	<h2>${unssuccess}</h2>
</body>
</html>