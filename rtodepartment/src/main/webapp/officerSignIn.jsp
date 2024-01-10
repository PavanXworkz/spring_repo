<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>RTO SignIn Page</title>
<%@include file="AllCss.jsp"%>
</head>
<body>
	<div class="text-center">
		<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS4nAIHVIe-ymwwsQWw1QuFnw6OlxCK0Fu6Bu15TLbT_lKJDZqebRlXIVwSyptKS5nwaTo&usqp=CAU" height="100" width="100%" alt="logo">
	</div>
	<%@include file="NavBar.jsp"%>
	<div class="container p-3 w-50 border rounded-5 border-dark-subtle shadow-lg my-4">
		<p class="fs-3 text-center bi bi-incognito">Admin Login</p>
		<p class="text-danger">${err}</p>
		<hr>
		<form action="officer" method="get">
			<div class="form-floating mb-3 col-md-12">
				<input type="email" class="form-control" name="emailId" id="floatingInput" placeholder="EmailId">
				<label for="floatingInput">EmailId</label>
			</div>
			<div class="form-floating mb-3 col-md-12">
				<input type="password" class="form-control" id="floatingInput" name="password" placeholder="Password">
				<label for="floatingInput">Password</label>
			</div>
			<input type="submit" value="signIn" class="btn btn-primary">
		</form>
		<p>
			<a href="emailVerifi.jsp" class="register-link">ForgotPassword</a>
		</p>
	</div>
	<%@include file="Footer.jsp"%>
</body>
</html>