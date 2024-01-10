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
		<p class="fs-3 text-center bi bi-incognito">Verify Email</p>
		<p class="text-danger">${op}</p>
		<hr>
		<form action="updadePassword" method="post">
			<div class="form-floating mb-3 col-md-12">
				<div class="form-floating mb-3 col-md-12">
					<input type="email" class="form-control" name="emailId" id="floatingInput" placeholder="EmailId">
					<label for="floatingInput">EmailId</label>
				</div>
				<p class="text-sucess">${otp}</p>
				<!-- 				<label for="floatingInput">OTP</label>
 -->
				<input type="submit" value="send OTP" class="btn btn-primary">
				<!-- <div class="form-floating mb-3 col-md-12">
				<input type="password" class="form-control" id="floatingInput" name="password" placeholder="Password">
				<label for="floatingInput">Password</label>
			</div> -->
			</div>
		</form>
		<form action="updatePassOtp" method="post">
			<div class="form-floating mb-3 col-md-12">
				<input type="email" class="form-control" value="${emailId}" name="emailId" id="floatingInput" placeholder="EmailId">
				<label for="floatingInput">EmailId</label>
			</div>
			<input type="text" class="form-control" id="floatingInput" name="otp" placeholder="Enter your otp">
			<input type="submit" value="update password" class="btn btn-primary">
		</form>

	</div>
	<%@include file="Footer.jsp"%>
</body>
</html>