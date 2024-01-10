<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="all_css.jsp"%>
</head>
<body>
	<%@include file="navbar.jsp"%>

	<form action="findById" method="get">
		<div class="text-center">
			<input type="search" placeholder="Search" name="id"> <input type="submit" class="btn btn-success">
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
				<tr>
					<td>${d.name}</td>
					<td>${d.emailId}</td>
					<td>${d.address}</td>
					<td>${d.phoneNumber}</td>
					<td>${d.rooms}</td>
					<td>${d.roomType}</td>
					<td>${d.noOfNights}</td>
					<td><a href="Update.jsp" class="btn btn-sm btn-primary">Update</a> <a href="" class="btn btn-sm btn-danger m-1">Delete</a></td>
				</tr>
			</tbody>
		</table>
	</form>

</body>
</html>