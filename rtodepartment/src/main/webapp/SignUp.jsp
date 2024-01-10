<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
  <!DOCTYPE html>
  <html>

  <head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>RTO SignUp</title>
    <script type="text/javascript">
      var districtByState = {
        "Andhra Pradesh": ["Visakhapatnam", "Vijayawada", "Guntur", "Kakinada", "Amalapuram", "Srikakulam", "Bhimavaram", "Eluru", "Kadapa", "Anantapur"],
        "Arunachal Pradesh": ["Itanagar", "Seppa", "Bomdila", "Tawang", "Ziro", "Pasighat", "Daporijo", "Roing", "Tezu", "Along"],
        "Assam": ["Guwahati", "Jorhat", "Dibrugarh", "Silchar", "Nagaon", "Tinsukia", "Tezpur", "Hailakandi", "Karimganj", "Lakhimpur"],
        "Bihar": ["Patna", "Gaya", "Muzaffarpur", "Bhagalpur", "Darbhanga", "Chapra", "Motihari", "Purnia", "Samastipur", "Siwan"],
        "Chhattisgarh": ["Raipur", "Bilaspur", "Durg", "Raigarh", "Korba", "Bijapur", "Ambikapur", "Jagdalpur", "Kanker", "Dhamtari"],
        "Goa": ["Panaji", "Margao", "Ponda", "Pernem", "Dharbandora", "Canacona", "Panji"],
        "Gujarat": ["Ahmedabad", "Surat", "Vadodara", "Rajkot", "Gandhinagar", "Bhavnagar", "Junagadh", "Jamnagar", "Anand", "Mehsana"],
        "Haryana": ["Faridabad", "Gurgaon", "Rohtak", "Panipat", "Ambala", "Karnal", "Hisar", "Yamunanagar", "Sirsa", "Rewari"],
        "Himachal Pradesh": ["Shimla", "Mandi", "Solan", "Kullu", "Dharamshala", "Bilaspur", "Una", "Hamirpur", "Chamba", "Nahan"],
        "Jharkhand": ["Ranchi", "Jamshedpur", "Dhanbad", "Bokaro", "Hazaribagh", "Deoghar", "Giridih", "Ramgarh", "Koderma", "Palamu"],
        "Karnataka": ["Bengaluru", "Mysuru", "Hubli", "Mangaluru", "Belgaum", "Davanagere", "Chikaballapur", "Yelahanka", "Banashankari", "Shivamogga"],
        "Kerala": ["Thiruvananthapuram", "Idukki", "Kozhikode", "Kollam", "Thrissur", "Palakkad", "Alappuzha", "Kannur", "Kottayam", "Kasaragod"],
        "Madhya Pradesh": ["Bhopal", "Indore", "Jabalpur", "Gwalior", "Ujjain", "Sagar", "Dewas", "Satna", "Ratlam", "Rewa"],
        "Maharashtra": ["Mumbai", "Pune", "Nagpur", "Thane", "Nashik", "Aurangabad", "Solapur", "Kolhapur", "Amravati", "Akola"],
        "Manipur": ["Imphal", "Thoubal", "Bishnupur", "Churachandpur", "Senapati", "Ukhrul", "Imphal east"]
      };

      function makeSubmenu(value) {
        if (value.length == 0) {
          document.getElementById("districtSelect").innerHTML = "<option></option>";
        }
        else {
          var districtsOptions = '';
          for (districtId in districtByState[value]) {
            districtsOptions += "<option>" + districtByState[value][districtId] + "</option>";
          }
          document.getElementById("districtSelect").innerHTML = districtsOptions;
        }
      }

      function handleFName() {
    	  console.log("Fname function is running")
        const fname = document.getElementById('firstName').value
        const button = document.getElementById('button');
        if (fname.length >= 3 && fname.length <= 20) {
          document.getElementById("fmsg").innerHTML = "<span style='color: green'> Name is valid </span>"
          button.removeAttribute("disabled");
        } else {
          document.getElementById("fmsg").innerHTML = "<span style='color :red'> Name is Invalid </span>"
          button.setAttribute("disabled", "");
        }
      }

      function handleLName() {
    	  console.log("Lname function is running")
        const lname = document.getElementById('lastName').value
        const button = document.getElementById('button');
        if (lname.length >= 2 && lname.length <= 10) {
          document.getElementById("lmsg").innerHTML = "<span style='color: green'> Name is valid </span>"
          button.removeAttribute("disabled");
        } else {
          document.getElementById("lmsg").innerHTML = "<span style='color :red'> Name is Invalid </span>"
        	  button.setAttribute("disabled", "");
        }
      }

      function handlePhoneNo() {
    	  console.log("phoneno function is running")
        const phno = document.getElementById('contact').value
        const button = document.getElementById('button');
        if (phno.length === 10) {
          document.getElementById("phmsg").innerHTML = "<span style='color: green'> PhoneNumber is valid </span>"
          button.removeAttribute("disabled");
        } else {
          document.getElementById("phmsg").innerHTML = "<span style='color :red'> PhoneNumber is Invalid </span>"
          button.setAttribute("disabled", "");
        }
      }

      /* function handleEmail() {
    	  console.log("Email function is running")
        const em = document.getElementById('email').value;
        const button = document.getElementById('button');
        if (em.match(/^[a-z]+@[a-z]+\.[a-z]{3}$/)) {
          document.getElementById("emsg").innerHTML = "<span style='color: green'>Email is valid</span>";
          button.removeAttribute("disabled");
        } else {
          document.getElementById("emsg").innerHTML = "<span style='color: red'>Invalid Email format</span>";
          button.setAttribute("disabled", "");
        }
      } */

      function handlePasw(){
    	  console.log("paws function is running")
    	  const paws=document.getElementById('password').value
    	  const button= document.getElementById('button');
    	  if(paws.match(/^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,}$/)){
    		  document.getElementById("pawsmsg").innerHTML="<span style='color: green'>Password is valid</span>";
    		  button.removeAttribute("disabled");
    	  }else{
    		  document.getElementById("pawsmsg").innerHTML="<span style='color: red'> Minimum eight characters, at least one letter, one number and one special character required</span>";
    		  button.setAttribute("disabled","");
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
    <%@include file="AllCss.jsp" %>
      <style>
        @media (min-width: 768px) {
          .custom-width {
            width: 50%;
          }
        }
      </style>
  </head>

  <body>
    <div class="text-center">
      <img
        src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS4nAIHVIe-ymwwsQWw1QuFnw6OlxCK0Fu6Bu15TLbT_lKJDZqebRlXIVwSyptKS5nwaTo&usqp=CAU"
        height="100" width="100%" alt="logo">
    </div>
    <%@include file="NavBar.jsp" %>
      <div class="container p-3 border rounded-2 border-dark-subtle shadow-lg my-4 custom-width">
        <p class="fs-3 text-center">Sign Up</p>
        <p class="text-danger">${err}</p>
        <p class="text-success">${succ}</p>
        <hr>
        <form action="save" method="post">
          <div class="row g-3">
            <div class="col-md-6 mb-2">
              <input id="firstName" type="text" class="form-control" placeholder="First name" name="firstName"
                onblur="handleFName()" required>
              <span id="fmsg"></span>
            </div>

            <div class="col-md-6 mb-2">
              <input id="lastName" type="text" class="form-control" placeholder="Last name" name="lastName"
                onblur="handleLName()" required>
              <span id="lmsg"></span>
            </div>

            <div class="col-md-6 mb-2">
              <input id="email" type="email" class="form-control" placeholder="EmailID" name="emailId"
                onblur="handleEmail()" required>
              <span id="emsg"></span>
            </div>

            <div class="col-md-6 mb-2">
              <input id="contact" type="tel" class="form-control" placeholder="PhoneNumber" name="phNo"
                onblur="handlePhoneNo()" required>
              <span id="phmsg"></span>
            </div>

            <div class="col-md-6 mb-2">
              <input id="password" type="password" class="form-control" placeholder="Password" name="password" onblur="handlePasw()" required>
              <span id="pawsmsg"></span>
            </div>

            <div class="col-md-6 mb-2">
              <input id="confirmPassword" type="password" class="form-control" placeholder="Conform Password"
                name="confirmPassword" onblur="handleConfPass()" required>
              <span id="cpamsg"></span>
            </div>

            <div class="col-md-6 mb-2">
              <select name="state" onchange="makeSubmenu(this.value)" class="form-select" required>
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

            <div class="col-md-6 mb-2">
              <select id="districtSelect" name="district" class="form-select" required>
                <option value="" disabled selected>Choose City</option>
              </select>
            </div>

            <div class="col-md-6">
              <input type="date" class="form-control md-3" name="dob" min="1956-01-01" max="2005-12-31" required>
            </div>

            <div class="col-12">
              <div class="form-check mb-3">
                <input id="check" class="form-check-input" type="checkbox" required checked>
                <label for="check" class="form-check-label"> Confirm Registration </label>
              </div>
            </div>

            <div class="col-md-6">
              <input type="submit" id="button" value="SignUp" class="btn btn-primary w-100">
            </div>

            <div class="col-md-6">
              <input type="reset" class="btn btn-dark w-100">
            </div>
          </div>
        </form>
      </div>
      <%@include file="Footer.jsp" %>
  </body>

  </html>