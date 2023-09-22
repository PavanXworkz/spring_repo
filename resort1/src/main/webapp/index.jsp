<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Resort registration</title>
</head>
<body>
<form action="save" method="post">

<input type="text" name="name" placeholder="Name"><br>
<input type="text" name="address" placeholder="Address"><br>
<input type="text" name="roomType" placeholder="RoomType"><br>
<input type="text" name="activity" placeholder="Activity"><br>
<input type="number" name="price" placeholder="Price"><br>

<input type="submit">

</form> 

<h1>${d.name}</h1>
<h1>${d.address}</h1>
<h1>${d.roomType}</h1>
<h1>${d.activity}</h1>
<h1>${d.price}</h1>
</body>
</html>