<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Check In</title>
<%@include file="all_css.jsp"%>
<style>
body {
	background-image:
		url('https://e1.pxfuel.com/desktop-wallpaper/538/683/desktop-wallpaper-sunset-beach-resort-ultra-wide-tv-wide-thumbnail.jpg');
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: 100% 100%;
}
</style>
</head>
<body>
	<%@include file="navbar.jsp"%>

	<div class="container p-4">
		<div class="col-md-6 offset-md-3 card card-body">
			<p class="fs-3 text-center">CHECK IN</p>
			<hr>
			<form action="save" method="post" class="row g-3">
				<div class="col-md-6">
					<label for="inputName" class="form-label"></label> <input type="text" class="form-control" name="name" id="inputName" placeholder="Name">
				</div>
				<div class="col-md-6">
					<label for="inputEmail14" class="form-label"></label> <input type="email" class="form-control" name="emailId" id="inputEmail14" placeholder="Email Id">
				</div>
				<div class="col-12">
					<label for="inputAddress" class="form-label"></label> <input type="text" class="form-control" name="address" id="inputAddress" placeholder="Address">
				</div>
				<div class="col-12">
					<label for="inputAddress2" class="form-label"></label> <input type="number" class="form-control" name="phoneNumber" id="inputPhoneNumber" placeholder="Phone Number">
				</div>

				<div class="col-md-4">
					<label for="inputRooms" class="form-label"></label> <select name="rooms" id="inputRooms" class="form-select">
						<option selected>Rooms</option>
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>

					</select>
				</div>

				<div class="col-md-4">
					<label for="inputState" class="form-label"></label> <select name="roomType" id="inputState" class="form-select">
						<option selected>Room Type</option>
						<option value="1 bed">1 bed</option>
						<option value="2 bed">2 bed</option>
						<option value="3 bed">3 bed</option>
						<option value="4 bed">4 bed</option>
					</select>
				</div>

				<div class="col-md-4">
					<label for="inputState" class="form-label"></label> <select name="noOfNights" id="inputState" class="form-select">
						<option selected>No Of Nights</option>
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
					</select>
				</div>

				<div class="col-12">
					<div class="form-check">
						<input class="form-check-input" type="checkbox" id="gridCheck" required="required" checked> <label class="form-check-label" for="gridCheck">I Accept Terms And Conditions</label>
					</div>
				</div>
				<div class="col-12">
					<input type="submit" class="btn btn-success" value="Save"> <input type="reset" class="btn btn-warning">
				</div>
			</form>
		</div>
	</div>
	<%@include file="footer.jsp"%>
</body>
</html>