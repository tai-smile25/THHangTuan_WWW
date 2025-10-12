<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
	<div class="container text-center">
		<h1 class="p-5">GIỎ HÀNG</h1>
		<table border="1" class="table">
			<thead>
				<tr>
					
					<th>ID</th>
					<th>TÊN SẢN PHẨM</th>
					<th>ẢNH</th>
					<th>GIÁ SẢN PHẨM</th>
					<th>SỐ LƯỢNG</th>
					<th>THÀNH TIỀN</th>
					<th>XÓA</th>
				</tr>
			</thead>
			<c:set var="total" value="0"></c:set>
			<c:forEach items="${sessionScope.carts}" var="item">
				<c:set var="total"
					value="${total + item.product.price * item.quantity}"></c:set>
				<tr>
					
					<td>${item.product.id}</td>
					<td>${item.product.name}</td>
					<td><img
						src="${pageContext.request.contextPath}/resources/images/${item.product.image}"
						width="100px" height="100px"></td>
					<td>${item.product.price}đ</td>
					<td>${item.quantity}</td>
					<td>${item.product.price * item.quantity }đ</td>
					<td><a class="btn btn-danger"
						href="${pageContext.request.contextPath}/CartController?action=remove&id=${item.product.id}">Remove</a></td>
				</tr>
			</c:forEach>
		</table>
		<div>
		   
			<h3 class="text-end">TỔNG TIỀN: ${total}đ</h3>
			  <a class="btn btn-success" href="${pageContext.request.contextPath}/CartController?action=checkout">Quay về trang chủ</a>
		</div>
	</div>
</body>
</html>