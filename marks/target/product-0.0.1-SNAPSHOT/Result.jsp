<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form actoin="marksCard" method="post">
	Kannada:<input type="number" name="kannada">
	English:<input type="number" name="english">
	Hindi:<input type="number" name="hindi">
	Maths:<input type="number" name="maths">
	Science:<input type="number" name="science">
	Social:<input type="number" name="social">
	</form>
	<hr>
	<h1>kannada ${kannada}</h1>
	<h1>english ${english}</h1>
	<h1>hindi ${hindi}</h1>
	<h1>maths ${maths}</h1>
	<h1>social ${social}</h1>
	<h1>science ${science}</h1>
	<h1>total ${total}</h1>
	<h1>percentage ${percentage}</h1>
</body>
</html>