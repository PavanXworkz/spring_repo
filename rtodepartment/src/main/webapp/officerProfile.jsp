<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="AllCss.jsp"%>
<style>
body {
	background-color: #AAA;
}
</style>

</head>
<body>
	<nav class="navbar navbar-expand-lg bg-primary navbar-dark fw-medium d-flex justify-content-between align-items-center">
		<div class="container-fluid">
			<div class="d=flex">
				<a class="navbar-brand" href="index.jsp"><img src="https://i.ibb.co/sCp6G0Z/download.jpg" width="50" alt="Logo" class="rounded-circle"></a>
				<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
			</div>

			<div class="d-flex">
				<a class="navbar-brand" href="index.jsp">Karntaka RTO</a>
			</div>

			<div class="d-flex">
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav me-auto mb-2 mb-lg-0">
						<li class="nav-item"><a class="nav-link bi bi-person text-capitalize" href="#"> Hi,<%-- ${d.firstName} --%></a></li>

						<!-- <li class="nav-item"><a class="nav-link" href="SignUp.jsp">SignUp</a></li> -->

						<li class="nav-item"><a class="nav-link" href="SignIn.jsp">LogOut</a></li>
					</ul>
				</div>
			</div>
		</div>
	</nav>
	<div class="container w=2 p-5">
		<h1>${up}</h1>
		<h1>${nd}</h1>
		<form class="d-flex" role="search" action="state" method="get">
			<%-- <h1>${state}</h1> --%>
		</form>
		<%-- <h1>${state}</h1>
 --%>
		<div class="container mt-5">
			<div class="table-responsive">
				<table class="table text-center">
					<thead>
						<tr class="table-dark">
							<th scope="col">Name</th>
							<th scope="col">DOB</th>
							<th scope="col">State</th>
							<th scope="col">Appl Date</th>
							<th scope="col">Appl Number</th>
							<th scope="col">Appl Status</th>
							<th scope="col">Pending Application</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${users}" var="user">
							<tr>
								<td>${user.firstName}&nbsp;${user.lastName}</td>
								<td>${user.dob}</td>
								<td>${user.state}</td>
								<td>${user.userRegisterDateTime}</td>
								<td>${user.applicationNumber}</td>
								<td>${user.applicationStatu}</td>
								<td><a href="approveUser?id=${user.id}">Approve</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		
		<p><b>Driving lisence applicant</b></p>
		
		<div class="container mt-5">
			<div class="table-responsive">
				<table class="table text-center">
					<thead>
						<tr class="table-dark">
							<th scope="col">Name</th>
							<th scope="col">DOB</th>
							<th scope="col">State</th>
							<th scope="col">Appl Date</th>
							<th scope="col">Appl Number</th>
							<th scope="col">Appl Status</th>
							<th scope="col">Pending Application</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${users}" var="user">
							<tr>
								<td>${user.firstName}&nbsp;${user.lastName}</td>
								<td>${user.dob}</td>
								<td>${user.state}</td>
								<td>${user.userRegisterDateTime}</td>
								<td>${user.applicationNumber}</td>
								<td>${user.applicationStatu}</td>
								<td><a href="approveUser?id=${user.id}">Approve</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>