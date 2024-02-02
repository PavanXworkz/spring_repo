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

						<li class="nav-item"><a class="nav-link" href="SignUp.jsp">SignUp</a></li>

						<li class="nav-item"><a class="nav-link" href="SignIn.jsp">LogOut</a></li>
					</ul>
				</div>
			</div>
		</div>
	</nav>
	<div class="container w=2 p-5">
		<h1>${up}</h1>
		<h1>${nd}</h1>
		<form action="findAll" method="get">
			<input type="submit" value="ALL OFFICERS" class="btn btn-success">
		</form>
		<%-- <h1>${state}</h1>
 --%>
		<div class="container mt-5">
			<div class="table-responsive">
				<table class="table text-center">
					<thead>
						<tr class="table-dark">
							<th scope="col">Name</th>
							<th scope="col">EmailId</th>
							<th scope="col">DOB</th>
							<th scope="col">State</th>
							<th scope="col">District</th>
							<th scope="col">Register Date</th>
							<th scope="col">Account Status</th>
							<!-- 	<th scope="col">Pending Application</th> -->
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list}" var="off">
							<%-- <h1>${off}</h1> --%>
							<tr>

								<td>${off.firstName}&nbsp;${off.lastName}</td> 
								<td>${off.emailId}</td>
								<td>${off.dob}</td>
								<td>${off.state}</td>
								<td>${off.district}</td>
								<td>${off.registereDateTime}</td>
								<td>${off.accountStatus}</td>
								<%-- <td><a href="approveUser?id=${off.id}">Approve</a></td> --%>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>


	</div>
</body>
</html>