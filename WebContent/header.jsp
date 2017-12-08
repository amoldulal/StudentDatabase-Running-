<!-- Grey with black text -->
<link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
<script type="text/javascript"
	src="resources/javascript/jquery-3.2.1.min.js"></script>
<script type="text/javascript"
	src="resources/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="resources/javascript/popper.js"></script>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	<a class="navbar-brand" href="#">StudentInfoSystem</a>
	<ul class="navbar-nav">
		<li class="nav-item"><a class="nav-link"
			href="StudentController?actions=student_list">Student</a></li>
		<li class="nav-item active"><a class="nav-link" href="#">Home</a>
		</li>
		<li class="nav-item"><a class="nav-link"
			href="UserController?actions=user_list">User</a></li>
		<li class="nav-item"><a class="nav-link disabled" href="#">${userName}</a>
		</li>
		<li class="nav-item"><a class="nav-link" href="LoginController">Logout</a>
		</li>
	</ul>
</nav>