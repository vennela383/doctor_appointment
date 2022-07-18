<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>User Management Application</title>
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
				<a href="#" class="navbar-brand"> Appointment Management Application </a>
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
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${doctor != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${doctor == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${doctor != null}">
            			Edit User
            		</c:if>
						<c:if test="${doctor == null}">
            			Add New Doctor
            		</c:if>
					</h2>
				</caption>

				<c:if test="${doctor != null}">
					<input type="hidden" name="id" value="<c:out value='${doctor.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Doctor Name</label> <input type="text"
						value="<c:out value='${doctor.name}' />" class="form-control"
						name="name" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Doctor Email</label> <input type="text"
						value="<c:out value='${doctor.email}' />" class="form-control"
						name="email">
				</fieldset>

				<fieldset class="form-group">
					<label>Doctor Speciality</label> <input type="text"
						value="<c:out value='${doctor.category}' />" class="form-control"
						name="category">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Doctor Experience</label> <input type="text"
						value="<c:out value='${doctor.experience}' />" class="form-control"
						name="experience">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Doctor Location</label> <input type="text"
						value="<c:out value='${doctor.location}' />" class="form-control"
						name="location">
				</fieldset>
							
				<fieldset class="form-group">
					<label>Doctor Fee</label> <input type="text"
						value="<c:out value='${doctor.fee}' />" class="form-control"
						name="fee">
				</fieldset>
				
				

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>