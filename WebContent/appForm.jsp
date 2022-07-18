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
				<a class="navbar-brand"> Appointment Management Application </a>
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
				<c:if test="${user != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${user == null}">
					<form action="insert1" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${user != null}">
            			Edit User
            		</c:if>
						<c:if test="${user == null}">
            			Add New Appointment
            		</c:if>
					</h2>
				</caption>

				<c:if test="${user != null}">
					<input type="hidden" name="id" value="<c:out value='${user.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Patient Name</label> <input type="text"
						value="<c:out value='${user.patientName}' />" class="form-control"
						name="patientName" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Patient Email</label> <input type="text"
						value="<c:out value='${user.patientEmail}' />" class="form-control"
						name="patientEmail">
				</fieldset>

				<fieldset class="form-group">
					<label>Patient Age</label> <input type="text"
						value="<c:out value='${user.patientAge}' />" class="form-control"
						name="patientAge">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Patient Reason</label> <input type="text"
						value="<c:out value='${user.reason}' />" class="form-control"
						name="reason">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Slot</label> 
						<select name="slot">
    						<c:forEach items="${slots}" var="slots">
        					<option value="${slots}">${slots}</option>
    					</c:forEach>
						</select>
				</fieldset>
				
				<fieldset class="form-group">
					<label>Doctor Name</label> 
						<select name="doctorName">
    						<c:forEach items="${listNames}" var="names">
        					<option value="${names.name}">${names.name}</option>
    					</c:forEach>
						</select>
				</fieldset>
				
				<fieldset class="form-group">
					<label>Location</label>
						<select name="location">
    <c:forEach items="${listNames}" var="location">
        <option value="${location.location}">${location.location}</option>
    </c:forEach>
</select>
				</fieldset>
				<fieldset class="form-group">
					<label>Speciality</label>
						<select name="category">
    <c:forEach items="${listNames}" var="category">
        <option value="${category.category}">${category.category}</option>
    </c:forEach>
</select>
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>