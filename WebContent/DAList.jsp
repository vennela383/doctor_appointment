<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Appointment Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: blue">
			<div>
				<a class="navbar-brand"> Appointment
					Management Application </a>
			</div>

			<ul class="navbar-nav">
			<li><a href="<%=request.getContextPath() %>/list"
					class="nav-link">Doctors</a></li>
				<li><a href="<%=request.getContextPath() %>/list2"
					class="nav-link">Appointments</a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">Doctor Appointments</h3>
			<hr>

			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Email</th>
						<th>patientAge</th>
						<th>Slot Time</th>
						<!--th>Actions</th -->
					</tr>
				</thead>
				<tbody>
				
					<c:forEach var="doctor" items="${listUser}">

						<tr>
							<td><c:out value="${doctor.id}" /></td>
							<td><c:out value="${doctor.patientName}" /></td>
							<td><c:out value="${doctor.patientEmail}" /></td>
							<td><c:out value="${doctor.patientAge}" /></td>
							<td><c:out value="${doctor.slot}" /></td>
						</tr>
					</c:forEach>
		
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>