<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DL FORMAT</title>
<%@include file="AllCss.jsp" %>
</head>
<body>
	<div class="container p-5 m-6 row col-md-6 offset-md-3 card card-body">
	<div  style="background-image:url(https://i.ibb.co/7CV6Wth/download.jpg); background-repeat: no-repeat; width=500px; ">
	<div class="align-left">
<img src="download?fileName=${UserImage}" height="80" width="80"></div>
<h6>Name:${dto.firstName}${dto.middleName}${dto.lastName}</h6>
<h6>BloodGoup:${dto.bloodGroup}</h6>
<h6>DLNO:${dto.applicationNumber}</h6>
</div>
</div>
</body>
</html>