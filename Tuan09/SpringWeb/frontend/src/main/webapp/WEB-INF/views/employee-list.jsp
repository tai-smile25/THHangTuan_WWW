<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Employee List</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/styles/bootstrap.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/styles/main.css">
</head>
<body>
<div class="container mt-5">
	<div class="card">
		<div class="card-header">
			<h2>Employee Management System</h2>
		</div>
		<div class="card-body">
			<!-- Search Form -->
			<div class="row mb-3">
				<div class="col-md-6">
					<form action="${pageContext.request.contextPath}/employees/search" method="get" class="d-flex">
						<input type="text" name="keyword" class="form-control me-2"
							   placeholder="Search by name or email..." value="${param.keyword}">
						<button type="submit" class="btn btn-primary">Search</button>
					</form>
				</div>
				<div class="col-md-6 text-end">
					<a href="${pageContext.request.contextPath}/employees/showForm"
					   class="btn btn-success">
						Add New Employee
					</a>
				</div>
			</div>

			<!-- Pagination Info -->
			<c:if test="${not empty totalItems}">
				<div class="alert alert-info">
					Showing page ${currentPage} of ${totalPages} (Total: ${totalItems} employees)
				</div>
			</c:if>

			<!-- Employee Table -->
			<c:choose>
				<c:when test="${not empty employees}">
					<table class="table table-striped table-hover">
						<thead class="table-dark">
						<tr>
							<th>ID</th>
							<th>First Name</th>
							<th>Last Name</th>
							<th>Email</th>
							<th>Phone</th>
							<th>City</th>
							<th>Actions</th>
						</tr>
						</thead>
						<tbody>
						<c:forEach items="${employees}" var="employee">
							<tr>
								<td>${employee.id}</td>
								<td>${employee.firstName}</td>
								<td>${employee.lastName}</td>
								<td>${employee.email}</td>
								<td>${employee.phone}</td>
								<td>${employee.address.city}</td>
								<td>
									<a href="${pageContext.request.contextPath}/employees/update?employeeId=${employee.id}"
									   class="btn btn-warning btn-sm">Edit</a>
									<a href="${pageContext.request.contextPath}/employees/delete?employeeId=${employee.id}"
									   class="btn btn-danger btn-sm"
									   onclick="return confirm('Are you sure you want to delete this employee?')">Delete</a>
								</td>
							</tr>
						</c:forEach>
						</tbody>
					</table>

					<!-- Pagination -->
					<c:if test="${not empty totalPages && totalPages > 1}">
						<nav>
							<ul class="pagination justify-content-center">
								<li class="page-item ${currentPage == 1 ? 'disabled' : ''}">
									<a class="page-link"
									   href="${pageContext.request.contextPath}/employees/page/${currentPage - 1}?pageSize=${pageSize}&sort=${sort}">
										Previous
									</a>
								</li>

								<c:forEach begin="1" end="${totalPages}" var="i">
									<li class="page-item ${currentPage == i ? 'active' : ''}">
										<a class="page-link"
										   href="${pageContext.request.contextPath}/employees/page/${i}?pageSize=${pageSize}&sort=${sort}">
												${i}
										</a>
									</li>
								</c:forEach>

								<li class="page-item ${currentPage == totalPages ? 'disabled' : ''}">
									<a class="page-link"
									   href="${pageContext.request.contextPath}/employees/page/${currentPage + 1}?pageSize=${pageSize}&sort=${sort}">
										Next
									</a>
								</li>
							</ul>
						</nav>
					</c:if>
				</c:when>
				<c:otherwise>
					<div class="alert alert-warning text-center">
						<strong>No employees found!</strong>
						<c:if test="${not empty param.keyword}">
							<br>Try different search terms or
							<a href="${pageContext.request.contextPath}/employees">view all employees</a>.
						</c:if>
					</div>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</div>

<script src="${pageContext.request.contextPath}/styles/bootstrap.bundle.min.js"></script>
</body>
</html>