<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Upload File</title>
<%@include file="AllCss.jsp"%>
</head>
<body>
<h1>${message}</h1>
<form action="upload" method="post" enctype="multipart/form-data">
	<div class="col-md-4 mb-2">
		<input id="lastName" type="text" class="form-control" placeholder="Application Number" value="${appl}" name="applicationNumber" required readonly>
	</div>
	<div class="col-md-4 mb-2">
		<input id="lastName" type="file" class="form-control" placeholder="upload your photo" name="file" required>
	</div>
<input type="submit" value="Upload File" class="btn btn-primary">
</form>
</body>
</html>