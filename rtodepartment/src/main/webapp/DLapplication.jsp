<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Application for Driving License</title>
<%@include file="AllCss.jsp"%>
</head>
<body>
	<nav class="navbar navbar-expand-lg bg-primary navbar-dark fw-medium d-flex justify-content-between align-items-center">
		<div class="container-fluid">
			<!-- 		<input type="button" value=Home class="btn btn-success">
 -->
			<a class="navbar-brand" href="index.jsp">Home</a> <a class="navbar-brand align-item-right" href="#">Driving License</a>
		</div>
	</nav>
	<div>
		<h4 class="text-center">NEW DRIVING LICENCE REGISTRATION</h4>
	</div>
	<form action="dl" method="post">
		<h1>${app}</h1>
		<%-- <h1>${dto}</h1> --%>
		<div class="row g-3">
			<div class="col-md-6 mb-2">
				<input id="firstName" type="text" class="form-control" placeholder="First name" value="${dto.firstName}" name="firstName" required readonly>

			</div>

			<div class="col-md-6 mb-2">
				<input id="middleName" type="text" class="form-control" readonly placeholder="Middle name" value="${dto.middleName}" name="middleName">
			</div>

			<div class="col-md-6 mb-2">
				<input id="lastName" type="text" class="form-control" readonly placeholder="Last name" name="lastName" value="${dto.lastName}" required>

			</div>

			<div class="col-md-6 mb-2">
				<input id="lastName" type="date" class="form-control" readonly placeholder="" name="dateOfBirth" value="${dto.dob}" required>
			</div>

			<div class="col-md-6 mb-2">
				<input id="age" type="tel" class="form-control" readonly placeholder="enter your age" name="age" value="${dto.age}" required>

			</div>

			<div class="col">
				<label>
					<b>Gender</b>
				</label>


				<input class="form-check-input" type="radio" name="gender" value="Male">
				<label class="form-check-label"> Male </label>

				<input class="form-check-input" type="radio" name="gender" value="Female">
				<label class="form-check-label"> Female </label>

				<input class="form-check-input" type="radio" name="gender" value="Trans">
				<label class="form-check-label"> Trans </label>
			</div>

			<div class="col-md-6 mb-2">
				<input id="occupation" type="text" class="form-control" placeholder="occupation" name="occupation">

			</div>

			<div class="col-md-6 mb-2">
				<input id="education" type="text" class="form-control" readonly placeholder="Education" value="${dto.qualification}" name="education">
			</div>
			<div class="col-md-6 mb-2">
				<input id="booldGroup" type="text" class="form-control" readonly placeholder="BloodGroup" value="${dto.bloodGroup}" name="bloodGroup" required>

			</div>

			<div class="col-md-6 mb-2">
				<input id="citizenshipNo" type="text" class="form-control" placeholder=" CitizenshipNumber" name="citizenshipNumber" required>
			</div>

			<div class="col-md-6 mb-2">
				<input id="citizenship" type="text" class="form-control" placeholder="Citizenship" name="citizenship" required>

			</div>

			<div class="col-md-6 mb-2">
				<input id="citizenshipdist" type="text" class="form-control" placeholder=" Citizenship Issued distict" name="citizenshipIssuedDistict" required>
			</div>

			<div class="col-md-6 mb-2">
				<input id="passportNo" type="tel" class="form-control" placeholder="PassportNumber" name="passportNumber" required>

			</div>

			<div class="col-md-6 mb-2">
				<input id="passportCountry" type="text" class="form-control" placeholder="PassportIssuedCountry" name="countryPassport" required>
			</div>

			<div class="col-md-6 mb-2">
				<input id="firstName" type="text" class="form-control" placeholder="Witness FirstName" name="witnwssFirstName" required>

			</div>

			<div class="col-md-6 mb-2">
				<input id="mark" type="text" class="form-control" placeholder="Your Identiy mark" name="mark" required>
			</div>

			<div class="col-md-6 mb-2">
				<input id="state" type="text" class="form-control" readonly placeholder="Enter your state" value="${dto.state}" name="state" required>

			</div>

			<div class="col-md-6 mb-2">
				<input id="middleName" type="text" class="form-control" placeholder="Witness MiddleName" name="witnessMiddleName" required>
			</div>

			<div class="col-md-6 mb-2">
				<input id="lastName" type="text" class="form-control" placeholder="Witness LastName" name="witnessLastName" required>

			</div>

			<div class="col-md-6 mb-2">
				<input id="relation" type="text" class="form-control" placeholder="Witness Relation" name="witnessRelation" required>
			</div>

			<div class="col-md-6 mb-2">
				<input id="name" type="text" class="form-control" placeholder="Trainer Name" name="trainerName" required>

			</div>

			<div class="col-md-6 mb-2">
				<input id="lisenceNo" type="text" class="form-control" placeholder="LisenceNumber" name="licenceNumber" required>
			</div>
		</div>
		<hr>

		<input type="submit" value="SignUp" class="btn btn-primary">
		<input type="cancle" value="cancle" class="btn btn-warning">
		<input type="reset" value="reset" class="btn btn-success">

	</form>
</body>
</html>