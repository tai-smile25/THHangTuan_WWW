<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản lý</title>
</head>
<style>
body {
	font-family: Arial, sans-serif;
}

.container {
	width: 100%;
	max-width: 800px;
	margin: 0 auto;
	border: 1px solid black;
}

.header {
	display: flex;
	justify-content: space-between;
	align-items: center;
	border-bottom: 1px solid black;
}

img {
	width: 100%;
}

.menu {
	text-align: center;
	padding: 10px;
	border-bottom: 1px solid black;
	background-color: #f2f2f2;
}

.menu a {
	margin: 0 15px;
	text-decoration: none;
	color: black;
	font-weight: bold;
}

.content {
	height: 400px;
	padding: 20px;
	border-bottom: 1px solid black;
}

.footer {
	text-align: center;
	padding: 10px;
	font-weight: bold;
}

.cart-table {
	width: 100%;
	border-collapse: collapse;
	margin-bottom: 20px;
}

.cart-table th, .cart-table td {
	border: 1px solid #ccc;
	padding: 10px;
	text-align: center;
}

.cart-table th {
	background-color: #f4f4f4;
}

.cart-table img {
	width: 50px;
	height: auto;
}

.menu a {
	text-decoration: underline;
	color: blue;
}
</style>
</head>
<body>

	<div class="container">
		<!-- Header Section -->
		<div class="header">
			<img class="img" src="${pageContext.request.contextPath}/header.png" />
		</div>

		<!-- Menu Section -->
		<div class="menu">
			<a href="${pageContext.request.contextPath}/dienthoaiform">Thêm tin sản
				phẩm</a> | <a href="${pageContext.request.contextPath}/list">Danh sách sản phẩm</a>
		</div>

		<!-- Content Section -->
		<div class="content">
			<table class="cart-table">
				<tr>
					<th>Tên điện thoại</th>
					<th>Năm sản xuất</th>
					<th>Cấu hình</th>
					<th>Hình ảnh</th>
					<th>Chức năng</th>
				</tr>

				<c:forEach var="item" items="${dienThoai}">
					<tr>
						<td>${item.tenDT}</td>
						<td>${item.namSanXuat}</td>
						<td>${item.cauHinh}</td>
						<td><img
							src="${pageContext.request.contextPath}/resources/images/${item.hinhAnh}"></td>
						<td>
							<form action="${pageContext.request.contextPath}/managelist"
								method="post">
								<input type="hidden" name="action" value="remove"> <input
									type="hidden" name="maDT" value="${item.maDT}"> <input
									type="submit" value="Xóa">
							</form>
						</td>
				
				</c:forEach>

			</table>
		</div>

		<!-- Footer Section -->
		<div class="footer">TranHuuTai – 21039651 – DHKTPM17B</div>
	</div>

</body>
</html>