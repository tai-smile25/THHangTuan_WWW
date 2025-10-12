<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<title>Insert title here</title>
<style>
body {
	display: flex;
	flex-direction: column;
	min-height: 800vh;
}

.table_center {
	margin-left: auto;
	margin-right: auto;
	width: 80%
}
</style>

</head>
<body>
<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato; padding-left: 100px">
			<div class="navbar-brand">
				<a href="<%=request.getContextPath()%>" class="nav-link">Sample Shopping</a>
			</div>
		</nav>
	</header>
	<div class="row">
		<div class="container">
			<h3 class="text-center">List of Products</h3>
			<hr>
			<br>
			<table cellpadding="2" cellspacing="2" border="1" class="table table-striped table_center">
				<thead class="alert alert-info">
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Photo</th>
					<th>Price</th>
					<th>Buy</th>
				</tr>
				</thead>
				<c:forEach var="product" items="${products}">
					<tr>
						<td>${product.id }</td>
						<td>${product.name }</td>
						<td>
							<img src="${pageContext.request.contextPath}/resources/images/${product.image}" width="120">
						</td>
						<td>${product.price }</td>
						<td align="center">
						<a href="${pageContext.request.contextPath}/CartController?action=buy&id=${product.id}">Buy</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	
</body>
</html>