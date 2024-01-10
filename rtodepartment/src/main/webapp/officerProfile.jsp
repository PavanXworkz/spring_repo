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
		<form class="d-flex" role="search" action="state" method="get">
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