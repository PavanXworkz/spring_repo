<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>RTO SignIn</title>
<%@include file="AllCss.jsp"%>
</head>
<body>
	<div class="text-center">
		<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS4nAIHVIe-ymwwsQWw1QuFnw6OlxCK0Fu6Bu15TLbT_lKJDZqebRlXIVwSyptKS5nwaTo&usqp=CAU" height="100" width="1000" alt="AMDJzPmwEpwnAAAAAElFTkSuQmCC">
	</div>
	<%@include file="NavBar.jsp"%>
	<div class="container p-3 w-50 border rounded-5 border-dark-subtle shadow-lg my-4">
		<p class="fs-3 text-center bi bi-incognito">Admin Login</p>
		<hr>
		<form action="admin" method="post">
			<div class="mb-3">
				<label class="form-lable">EmailId</label>
				<input type="text" value="${emailId}" name="emailId" class="form-control" required>
			</div>
			<h1>${otp}</h1>
			<input type="submit" value="SendOtp" name="num" class="btn btn-success">
			<div class="mb-3">
				<label class="form-lable">OTP</label>
				<input type="text" name="otp" class="form-control">
			</div>
			<h1>${exp}</h1>
			<h1> ${wrg}</h1>
			<div>
				<input type="submit" value="login" name="num" class="btn btn-success">
			</div>
		</form>
	</div>
	<%@include file="Footer.jsp"%>
</body>
</html>