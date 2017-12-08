<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>StudentInfoSystem</title>
<%@ include file="header.jsp"%>
</head>
<body
	style="background-size: cover; background-image: url('resources/images/college.jpg');">


	<div class="alert alert-warning alert-dismissible fade show"
		role="alert">
		<strong>WELCOME!</strong> ${userName}
		<button type="button" class="close" data-dismiss="alert"
			aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>
	</div>
</body>
</html>