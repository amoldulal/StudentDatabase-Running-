<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@ include file="header.jsp"%>
</head>
<body>
	<a href="UserController?actions=user_new">New User</a>
	<c:if test="${! empty users }">
		<table class="table">
			<thead class="thead-light">
				<tr>
					<th scope="col">#</th>
					<th scope="col">User Id</th>
					<th scope="col">User firstName</th>
					<th scope="col">User lasttName</th>
					<th scope="col">Email</th>
					<th scope="col">User Name</th>
					<th scope="col">Password</th>
					<th scope="col">Gender</th>
					<th scope="col">DOB</th>
					<th scope="col">photo</th>
					<th scope="col">Actions</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach items="${users}" var="user">
					<tr>
						<th scope="row">1</th>
						<td><c:out value="${user.id}" /></td>
						<td><c:out value="${user.firstName}" /></td>
						<td><c:out value="${user.lastName}" /></td>
						<td><c:out value="${user.email}" /></td>
						<td><c:out value="${user.userName}" /></td>
						<td><c:out value="${user.password}" /></td>
						<td><c:out value="${user.gender}" /></td>
						<td><c:out value="${user.dob}" /></td>
						<td><img src="UserImageDisplayController?userId=${user.id}"
							alt="profile pic" width="50px" height="50px"></td>
						<td><a href="UserController?actions=user_delete&userId=${user.id}">Delete</a>|
						<a href="UserController?actions=user_edit&userId=${user.id}">Edit</a>
					</tr>
				</c:forEach>

			</tbody>
		</table>
	</c:if>
</body>
</html>