<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="bill" method="post">
		Product Name:<input type="text" name="productName"><br>
		Rating:<input type="number" name="rating"><br>
		 Price:<input type="number" name="price"><br>
		  Quantity:<input type="number" name="quantity"><br>
		   Reviews:<input type="text" name="reviews"><br>
			  <input type="submit">
	</form>

	<h1>${productName}</h1>
	<h1>${rating}</h1>
	<h1>${price}</h1>
	<h1>${quantity}</h1>
	<h1>${reviews}</h1>
	 <h1>${total}</h1> 

</body>
</html>