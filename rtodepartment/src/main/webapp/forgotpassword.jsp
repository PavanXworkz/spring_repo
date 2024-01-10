<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>RTO SignIn</title>
<script type="text/javascript">
	function handlePasw() {
		console.log("paws function is running")
		const paws = document.getElementById('password').value
		const button = document.getElementById('button');
		if (paws
				.match(/^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,}$/)) {
			document.getElementById("pawsmsg").innerHTML = "<span style='color: green'>Password is valid</span>";
			button.removeAttribute("disabled");
		} else {
			document.getElementById("pawsmsg").innerHTML = "<span style='color: red'> Minimum eight characters, at least one letter, one number and one special character required</span>";
			button.setAttribute("disabled", "");
		}
	}
	function handleConfPass() {
		console.log("confPass function is running")
		const psw = document.getElementById("password").value;
		const cpsw = document.getElementById("confirmPassword").value;
		const button = document.getElementById('button');
		if (psw === cpsw) {
			document.getElementById("cpamsg").innerHTML = "<span style='color: green'>Confirm Password matches</span>";
			button.removeAttribute("disabled");
		} else {
			document.getElementById("cpamsg").innerHTML = "<span style='color: red'>Confirm Password won't match</span>";
			button.setAttribute("disabled", "");
		}
	}
</script>
<%@include file="AllCss.jsp"%>
</head>
<body>
	<div class="text-center">
		<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS4nAIHVIe-ymwwsQWw1QuFnw6OlxCK0Fu6Bu15TLbT_lKJDZqebRlXIVwSyptKS5nwaTo&usqp=CAU" height="100" width="1000" alt="AMDJzPmwEpwnAAAAAElFTkSuQmCC">
	</div>
	<%@include file="NavBar.jsp"%>
	<div class="container p-3 w-50 border rounded-5 border-dark-subtle shadow-lg my-4">
		<p class="fs-3 text-center bi bi-incognito">SetUp New Password</p>
		<h1 class="text-danger">${paer}</h1>
		<p class="text-success">${pass}</p>
		<p>
			Already have reset your password<a href="SignIn.jsp" class="register-link">SigIn</a>
		</p>
		<p class="text-danger">${exp}</p>
		<hr>
		<form action="passUpdate" method="post">
			<div class="form-floating mb-3 col-md-12">
				<input type="email" class="form-control" id="floatingInput" name="emailId" placeholder="Email">
				<label for="floatingInput">Email Id</label>
			</div>
			<div class="form-floating mb-3 col-md-12">
				<input id="password" type="password" class="form-control" id="floatingInput" name="password" placeholder="Password" oninput="handlePasw()">
				<label for="floatingInput">Password</label>
				<span id="pawsmsg"></span>
			</div>
			<div class="form-floating mb-3 col-md-12">
				<input id="confirmPassword" type="password" class="form-control" id="floatingInput" name="confirmPassword" placeholder="Password" oninput="handleConfPass()">
				<label for="floatingInput">ConformPassword</label>
				<span id="cpamsg"></span>
			</div>
			<input type="submit" value="update password" class="btn btn-primary">
		</form>
	</div>
	<%@include file="Footer.jsp"%>
</body>
</html>