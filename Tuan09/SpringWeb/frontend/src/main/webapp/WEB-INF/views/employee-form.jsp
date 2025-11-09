<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>${employee.id == 0 ? 'Add' : 'Edit'} Employee</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/styles/bootstrap.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/styles/main.css">
</head>
<body>
<div class="container mt-5">
	<div class="card">
		<div class="card-header">
			<h2>${employee.id == 0 ? 'Add New' : 'Edit'} Employee</h2>
		</div>
		<div class="card-body">
			<c:if test="${not empty errors}">
				<div class="alert alert-danger">
					<strong>Validation Errors:</strong>
					<ul>
						<c:forEach items="${errors}" var="error">
							<li>${error.value}</li>
						</c:forEach>
					</ul>
				</div>
			</c:if>

			<c:if test="${not empty error}">
				<div class="alert alert-danger">
						${error}
				</div>
			</c:if>

			<form action="${pageContext.request.contextPath}/employees/save" method="post">
				<input type="hidden" name="id" value="${employee.id}">

				<div class="row">
					<div class="col-md-6 mb-3">
						<label for="firstName" class="form-label">First Name *</label>
						<input type="text" class="form-control" id="firstName"
							   name="firstName" value="${employee.firstName}" required>
					</div>

					<div class="col-md-6 mb-3">
						<label for="lastName" class="form-label">Last Name *</label>
						<input type="text" class="form-control" id="lastName"
							   name="lastName" value="${employee.lastName}" required>
					</div>
				</div>

				<div class="row">
					<div class="col-md-6 mb-3">
						<label for="email" class="form-label">Email *</label>
						<input type="email" class="form-control" id="email"
							   name="email" value="${employee.email}" required>
					</div>

					<div class="col-md-6 mb-3">
						<label for="phone" class="form-label">Phone</label>
						<input type="tel" class="form-control" id="phone"
							   name="phone" value="${employee.phone}">
					</div>
				</div>

				<h5 class="mt-4 mb-3">Address Information</h5>

				<div class="mb-3">
					<label for="street" class="form-label">Street</label>
					<input type="text" class="form-control" id="street"
						   name="address.street" value="${employee.address.street}">
				</div>

				<div class="row">
					<div class="col-md-4 mb-3">
						<label for="city" class="form-label">City</label>
						<input type="text" class="form-control" id="city"
							   name="address.city" value="${employee.address.city}">
					</div>

					<div class="col-md-4 mb-3">
						<label for="state" class="form-label">State</label>
						<input type="text" class="form-control" id="state"
							   name="address.state" value="${employee.address.state}">
					</div>

					<div class="col-md-4 mb-3">
						<label for="zipCode" class="form-label">Zip Code</label>
						<input type="text" class="form-control" id="zipCode"
							   name="address.zipCode" value="${employee.address.zipCode}">
					</div>
				</div>

				<div class="mt-4">
					<button type="submit" class="btn btn-primary">
						${employee.id == 0 ? 'Save' : 'Update'} Employee
					</button>
					<a href="${pageContext.request.contextPath}/employees"
					   class="btn btn-secondary">Cancel</a>
				</div>
			</form>
		</div>
	</div>
</div>

<script src="${pageContext.request.contextPath}/styles/bootstrap.bundle.min.js"></script>
</body>
</html>