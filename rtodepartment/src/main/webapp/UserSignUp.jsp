<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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

	function makeSubmenu(value) {
		if (value.length == 0) {
			document.getElementById("districtSelect").innerHTML = "<option></option>";
		} else {
			var districtsOptions = '';
			for (districtId in districtByState[value]) {
				districtsOptions += "<option>"
						+ districtByState[value][districtId] + "</option>";
			}
			document.getElementById("districtSelect").innerHTML = districtsOptions;
		}
	}

	/* function handleEmail() {
		console.log("Email function is running")
		const eml = document.getElementById('email').value;
		const button = document.getElementById('button');
		 if (eml.match(/^[a-z]+@[a-z]+\.[a-z]{3}$/)) { 
			if(eml.length<=20){
			document.getElementById("emsmg").innerHTML = "<span style='color: green'>Email is valid</span>";
			button.removeAttribute('disabled');
		} else {
			document.getElementById("emsmg").innerHTML = "<span style ='color:red'>Invalid email format</span>";
			button.setAttribute('disabled', '');
		}
	} */

	function handleFirstName() {
		console.log("Fname function is running")
		const fname = document.getElementById('firstName').value
		const button = document.getElementById('button');
		if (fname.length >= 3 && fname.length <= 20) {
			document.getElementById("fname").innerHTML = "<span style='color: green'> Name is valid </span>";
			button.removeAttribute('disabled');
		} else {
			document.getElementById("fname").innerHTML = "<span style='color :red'> Name is Invalid </span>"
			button.setAttribute("disabled", '');
		}
	}

	function handleLastName() {
		console.log("Fname function is running")
		const fname = document.getElementById('lastName').value
		const button = document.getElementById('button');
		if (fname.length >= 2 && fname.length <= 20) {
			document.getElementById("lastname").innerHTML = "<span style='color: green'> Name is valid </span>"
			button.removeAttribute('disabled');
		} else {
			document.getElementById("lastname").innerHTML = "<span style='color :red'> Name is Invalid </span>"
			button.setAttribute('disabled', '');
		}
	}

	function handlePhoneNo() {
		console.log("PhoneNumber function is running")
		const phno = document.getElementById('phoneNumber').value
		const button = document.getElementById('button');
		if (phno.length === 10) {
			document.getElementById("phone").innerHTML = "<span style='color: green'> Phone number is valid </span>"
			button.removeAttribute("disabled");
		} else {
			document.getElementById("phone").innerHTML = "<span style='color :red'> Phone number is Invalid </span>"
			button.setAttribute('disabled', '');
		}
	}

	function handleAdharNo() {
		console.log("PhoneNumber function is running")
		const phno = document.getElementById('adharNumber').value
		const button = document.getElementById('button');
		if (phno.length === 12) {
			document.getElementById("adh").innerHTML = "<span style='color: green'> Phone number is valid </span>"
			button.removeAttribute("disabled");
		} else {
			document.getElementById("adh").innerHTML = "<span style='color :red'> Phone number is Invalid </span>"
			button.setAttribute('disabled', '');
		}
	}
</script>
<%@include file="AllCss.jsp"%>

</head>
<body>
	<%@include file="NavBar.jsp"%>
	<div class="container p-3 border rounded-2 border-dark-subtle shadow-lg my-4 custom-width">
		<p class="fs-3 text-center bg-dark text-white">Application For LLR</p>
		<hr>
		<h1 class="text-success">${d}</h1>
		<h1>${appNo}</h1>
		<form action="saveuser" method="post">
			<p>
				<b>*Select State and RTO office from where LLR is being applied</b>
			</p>
			<div class="row g-4">
				<div class="col-md-6 mb-2">
					<label class="form-lable">
						<b>*state</b>
					</label>
					<div class="col-md-6 mb-2">
						<select name="state" onchange="makeSubmenu(this.value)" required>
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
				</div>
				<div class="col-md-6 mb-2">
					<label class="form-lable">
						<b>*RTO office</b>
					</label>
					<select id="districtSelect" name="rtoOffice" required>
						<option value="" disabled selected>Choose City</option>
					</select>
				</div>
			</div>
			<div class="container border border-dark ">
				<div class="row mt-2">
					<div class="col-md-5">
						<label class="form-lable">
							<b>*Applicant Name</b>
						</label>
						<input id="firstName" type="text" placeholder="First name" name="firstName" required oninput="handleFirstName()">
						<span id="fname"></span>
					</div>
					<div class="col-md-3 mb-2">
						<input id="middleName" type="text" placeholder="Middle name" name="middleName" required>

					</div>
					<div class="col-md-3 mb-2">
						<input id="lastName" type="text" placeholder="Last name" name="lastName" oninput="handleLastName()" required>
						<span id="lastname"></span>
					</div>

				</div>
				<hr>
				<div class="row mt-2">
					<div class="col-md-3 mb-2">
						<label>
							<b>Date of Birth</b>
						</label>
						<input id="dob" type="date" placeholder="DateOfBirth" name="dob" required>

					</div>
					<div class="col-md-3 mb-2">
						<label>
							<b>Age</b>
						</label>
						<input id="age" type="number" placeholder="Enter your age" name="age" required>
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
				</div>
				<hr>
				<div class="row mt-2">
					<div class="col-md-3 mb-2">
						<label class="form-lable">
							<b>*ph</b>
						</label>
						<input id="phoneNumber" type="tel" placeholder="contact" name="contactNo" oninput="handlePhoneNo()" required>
						<h6 class="text-danger">${phone}</h6>
						<span id="phone"></span>
					</div>
					<div class="col-md-3 mb-2">
						<label class="form-lable">
							<b>*adhar No</b>
						</label>
						<input id="adharNumber" type="tel" placeholder="adharNumber" name="adhNo" oninput=" handleAdharNo() " required>
						<h6 class="text-danger">${adh}</h6>
						<span id="adh"></span>
					</div>
					<div class="col-md-3 mb-2">
						<label class="form-lable">
							<b>*EmailId</b>
						</label>
						<input id="email" type="email" placeholder="example@gmail.com" name="emailId" required oninput="handleEmail()">
						<h6 class="text-danger">${email}</h6>
						<span id="emsmg"></span>
					</div>

				</div>
				<hr>
				<div class="row mt-2">
					<div class="col-md-6">
						<label class="form-lable">
							<b>*permanent address</b>
						</label>
						<input id="premanent address" type="text" placeholder="Enter Permanent Address" name="permanentAddress" required>
					</div>
					<div class="col-md-6">
						<label class="form-lable">
							<b>*PinCode </b>
						</label>
						<input id="premanent pin" type="number" placeholder="Enter Permanent Address pin" name="permanentPinCode" required>
					</div>

				</div>
				<hr>
				<div class="row mt-2 mb-3">
					<div class="col-md-6">
						<label class="form-lable">
							<b>*current address</b>
						</label>
						<input id="current address" type="text" placeholder="Enter Current Address" name="currentAddress" required>
					</div>
					<div class="col-md-6">
						<label class="form-lable">
							<b>*PinCode </b>
						</label>
						<input id="current pin" type="number" placeholder="Enter current Address pin" name="presentPinCode" required>
					</div>

				</div>
				<hr>
				<div class="row mt-2 mb-3">
					<div class="col-md-4">
						<label class="form-lable">
							<b>BloodGroup </b>
						</label>
						<input id="bloodgroup" type="text" placeholder="bloodgrup" name="bloodGroup" required>
					</div>
					<div class="col-md-4">
						<label class="form-lable">
							<b>Qualification </b>
						</label>
						<input id="qualification" type="text" placeholder="qualification" name="qualification" required>
					</div>

					<div class="col-md-4">
						<label class="form-lable">
							<b>BirthPlace </b>
						</label>
						<input id="placeOfBirth" type="text" placeholder="Place Of Birth" name="placeOfBirth" required>
					</div>
				</div>
			</div>
			<div class="col-12 mt-2	">
				<input type="submit" id="button" class="btn btn-primary">
				<input type="reset" id="button" class="btn btn-primary">
			</div>
		</form>
	</div>
</body>
</html>