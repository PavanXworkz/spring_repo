<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LLR APPLICANT PROFILE</title>
<%@include file="AllCss.jsp"%>
<style>
body {
	background-color: #AAA;
}
</style>
<script type="text/javascript">
	var districtByState = {
		"Andhra Pradesh" : [ "Visakhapatnam", "Vijayawada", "Guntur",
				"Kakinada", "Amalapuram", "Srikakulam", "Bhimavaram", "Eluru",
				"Kadapa", "Anantapur" ],
		"Arunachal Pradesh" : [ "Itanagar", "Seppa", "Bomdila", "Tawang",
				"Ziro", "Pasighat", "Daporijo", "Roing", "Tezu", "Along" ],
		"Assam" : [ "Guwahati", "Jorhat", "Dibrugarh", "Silchar", "Nagaon",
				"Tinsukia", "Tezpur", "Hailakandi", "Karimganj", "Lakhimpur" ],
		"Bihar" : [ "Patna", "Gaya", "Muzaffarpur", "Bhagalpur", "Darbhanga",
				"Chapra", "Motihari", "Purnia", "Samastipur", "Siwan" ],
		"Chhattisgarh" : [ "Raipur", "Bilaspur", "Durg", "Raigarh", "Korba",
				"Bijapur", "Ambikapur", "Jagdalpur", "Kanker", "Dhamtari" ],
		"Goa" : [ "Panaji", "Margao", "Ponda", "Pernem", "Dharbandora",
				"Canacona", "Panji" ],
		"Gujarat" : [ "Ahmedabad", "Surat", "Vadodara", "Rajkot",
				"Gandhinagar", "Bhavnagar", "Junagadh", "Jamnagar", "Anand",
				"Mehsana" ],
		"Haryana" : [ "Faridabad", "Gurgaon", "Rohtak", "Panipat", "Ambala",
				"Karnal", "Hisar", "Yamunanagar", "Sirsa", "Rewari" ],
		"Himachal Pradesh" : [ "Shimla", "Mandi", "Solan", "Kullu",
				"Dharamshala", "Bilaspur", "Una", "Hamirpur", "Chamba", "Nahan" ],
		"Jharkhand" : [ "Ranchi", "Jamshedpur", "Dhanbad", "Bokaro",
				"Hazaribagh", "Deoghar", "Giridih", "Ramgarh", "Koderma",
				"Palamu" ],
		"Karnataka" : [ "Bengaluru", "Mysuru", "Hubli", "Mangaluru", "Belgaum",
				"Davanagere", "Chikaballapur", "Yelahanka", "Banashankari",
				"Shivamogga" ],
		"Kerala" : [ "Thiruvananthapuram", "Idukki", "Kozhikode", "Kollam",
				"Thrissur", "Palakkad", "Alappuzha", "Kannur", "Kottayam",
				"Kasaragod" ],
		"Madhya Pradesh" : [ "Bhopal", "Indore", "Jabalpur", "Gwalior",
				"Ujjain", "Sagar", "Dewas", "Satna", "Ratlam", "Rewa" ],
		"Maharashtra" : [ "Mumbai", "Pune", "Nagpur", "Thane", "Nashik",
				"Aurangabad", "Solapur", "Kolhapur", "Amravati", "Akola" ],
		"Manipur" : [ "Imphal", "Thoubal", "Bishnupur", "Churachandpur",
				"Senapati", "Ukhrul", "Imphal east" ]
	};
</script>
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
						<li class="nav-item"><a class="nav-link bi bi-person text-capitalize" href="#"> Hi,${em.firstName}</a></li>

						<li class="nav-item"><a class="nav-link" href="SignUp.jsp">SignUp</a></li>

						<li class="nav-item"><a class="nav-link" href="userLogin.jsp">LogOut</a></li>
					</ul>
				</div>
			</div>
		</div>
	</nav>
	<div class="container w=2 p-5">

		<form class="d-flex" role="search" action="state" method="get">
		<!--       <input class="form-control me-2 w-25" type="search" placeholder="Search" name="state" aria-label="Search">
 -->
		<div class="col-md-6 mb-2">
			<select name="state" onchange="makeSubmenu(this.value)" class="form-select w-25" required>
				<option value="" disabled selected>Choose State</option>
				<option value="Andhra Pradesh">Andhra Pradesh</option>
				<option value="Arunachal Pradesh">Arunachal Pradesh</option>
				<option value="Assam">Assam</option>
				<option value="Bihar">Bihar</option>
				<option value="Chhattisgarh">Chhattisgarh</option>
				<option value="Goa">Goa</option>
				<option value="Gujarat">Gujarat</option>
				<option value="Haryana">Haryana</option>
				<option value="Himachal Pradesh">Himachal Pradesh</option>
				<option value="Jharkhand">Jharkhand</option>
				<option value="Karnataka">Karnataka</option>
				<option value="Kerala">Kerala</option>
				<option value="Madhya Pradesh">Madhya Pradesh</option>
				<option value="Maharashtra">Maharashtra</option>
				<option value="Manipur">Manipur</option>
			</select>
		</div>
		<button class="btn btn-outline-success" type="submit">Search</button>
		<%-- <h1>${state}</h1> --%>
		</form>
		<%-- <h1>${state}</h1>
 --%>
		<table class="table table-bordered container p-3 border rounded-2 border-dark-subtle shadow-lg my-4 custom-width">
			<thead>
				<tr>
					<th scope="col">ApplicationNumber</th>
					<th scope="col">FirstName</th>
					<!-- <th scope="col">LastName</th>
					<th scope="col">MiddleName</th>
					<th scope="col">Gender</th>
					<th scope="col">State</th>
					<th scope="col">Date Of Birth</th>
					<th scope="col">Age</th>
					<th scope="col">BloodGroup</th>
					<th scope="col">Qualification</th>
					<th scope="col">PlaceOfBirth</th>
					<th scope="col">District</th>
					<th scope="col">PermanentAddress</th>
					<th scope="col">PinCode</th>
					<th scope="col">CurrentAddress</th>
					<th scope="col">PinCode</th>
					<th scope="col">AdharNo.</th>
					<th scope="col">EmailId</th>
					<th scope="col">PhoneNo</th> -->
					<th scope="col">ApplicationStatus</th>
				</tr>
			</thead>
			
				<tbody>
					<tr>
						<td>${user.applicationNumber}</td>
						<td>${user.firstName}</td>
						
						<td class="text-danger">${user.applicationStatu}</td>
					</tr>
				</tbody>
			
		</table>
	</div>
</body>
</html>