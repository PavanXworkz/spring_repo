<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="AllCss.jsp"%>
</head>
<body>
<form action="display" method="get">
<div class="col-md-4 mb-2">
		<input id="lastName" type="text" class="form-control" placeholder="Application Number" name=applicationNumber required>
	</div>
	<input type="submit" value="Display" class="btn btn-primary">
	</form>
</body>
</html>