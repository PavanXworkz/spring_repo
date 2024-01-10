<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LOGIN</title>
<%@include file="AllCss.jsp"%>
</head>
<body>
	<div class="text-center">
		<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS4nAIHVIe-ymwwsQWw1QuFnw6OlxCK0Fu6Bu15TLbT_lKJDZqebRlXIVwSyptKS5nwaTo&usqp=CAU" height="100" width="1000" alt="AMDJzPmwEpwnAAAAAElFTkSuQmCC">
	</div>
	<%@include file="NavBar.jsp"%>
	<div class="container p-3 w-50 border rounded-5 border-dark-subtle shadow-lg my-4">
		<p class="fs-3 text-center bi bi-incognito">LOGIN FOR LLR</p>
		<p class="text-danger">${err}</p>
		<hr>
		<form action="logIn" method="get">
			<div class="form-floating mb-3 col-md-12">
				<input type="text" class="form-control" name="apporcontno" id="floatingInput" placeholder="ApplicationNo/PnoneNo">
				<label for="floatingInput">ApplicationNo/PnoneNo</label>
			</div>


			<div class="form-floating mb-3 col-md-12">
				<input type="date" class="form-control" id="floatingInput" name="dob" placeholder="Enter Your Date Of Birth">
				<label for="floatingInput">DateOfBirth</label>
			</div>

			<p>
				New application<a href="UserSignUp.jsp" class="register-link">register</a>
			</p>
			<input type="submit" value="signIn" class="btn btn-primary">
		</form>
	</div>
	<%@include file="Footer.jsp"%>

</body>
</html>