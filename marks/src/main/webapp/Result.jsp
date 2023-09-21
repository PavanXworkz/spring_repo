<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="marksCard" method="post">
		Kannada:<input type="number" name="kannada"><br> English:<input
			type="number" name="english"><br> Hindi:<input
			type="number" name="hindi"><br> Maths:<input
			type="number" name="maths"><br> Science:<input
			type="number" name="science"><br> Social:<input
			type="number" name="social"><br> <input type="submit">
	</form>
	
	<h1>kannada:- ${kannada}</h1>
	<h1>english:- ${english}</h1>
	<h1>hindi:- ${hindi}</h1>
	<h1>maths:- ${maths}</h1>
	<h1>social:- ${social}</h1>
	<h1>science:- ${science}</h1>
	<h1>total:- ${total}</h1>
	<h1>percentage:- ${persentage}</h1>
	<h1>highest score:- ${largest}</h1>
	<h1>lowest score:- ${lowest}</h1>
	
</body>
</html>