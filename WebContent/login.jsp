<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Info Login</title>
<script type="text/javascript" src="resources/javascript/login.js"></script>
<link rel="stylesheet" href="resources/css/logincss.css">
</head>
<body>
	<!--
    you can substitue the span of reauth email for a input with the email and
    include the remember me checkbox
    -->
	<div class="container">
		<div class="card card-container">

			<img id="profile-img" class="profile-img-card"
				src="//ssl.gstatic.com/accounts/ui/avatar_2x.png" />
			<p id="profile-name" class="profile-name-card"></p>
			<form class="form-signin" action="LoginController" method="post">
				<span style="color: red">${loginfail}</span> <span
					style="color: green">${logout}</span><input type="text"
					id="inputEmail" class="form-control" placeholder="Username"
					name="uname" value="${username}" required autofocus> <input type="password"
					id="inputPassword" class="form-control" placeholder="Password"
					name="pass" value="${password}" required>
				<div id="remember" class="checkbox">
					<label> <input type="checkbox" value="remember-me" name="remember-me">
						Remember me
					</label>
				</div>
				<button class="btn btn-lg btn-primary btn-block btn-signin"
					type="submit">Sign in</button>
			</form>
			<!-- /form -->
			<a href="#" class="forgot-password"> Forgot the password? </a>
		</div>
		<!-- /card-container -->
	</div>
	<!-- /container -->
</body>
</html>