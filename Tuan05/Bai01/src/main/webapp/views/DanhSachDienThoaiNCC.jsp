<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách điện thoại</title>
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

.timKiem {
    display: inline-block;
    width: auto;
    margin-bottom: 10px;
}

input[type="text"] {
    padding: 10px;
    border: 1px solid #ccc;
    border-radius: 4px;
    font-size: 16px;
    display: inline-block;
}

input[type="submit"] {
    padding: 10px 15px;
    border: none;
    border-radius: 4px;
    background-color: #007bff;
    color: white;
    font-size: 16px;
    cursor: pointer;
    display: inline-block; 
    margin-left: 10px;
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
				phẩm</a> | <a href="${pageContext.request.contextPath}/managelist">Chức
				năng quản lý</a>
		</div>
		
		<!-- Form tìm kiếm -->
   

		<!-- Content Section -->
		<div class="content">
		
		<form class="timKiem" action="${pageContext.request.contextPath}/searchDienThoai" method="get"">
        <input type="text" name="tenDT" placeholder="Tìm theo tên điện thoại">
        <input type="submit" value="Tìm kiếm">
    	</form>
		
			<table class="cart-table">
				<tr>
					<th>Tên điện thoại</th>
					<th>Năm sản xuất</th>
					<th>Cấu hình</th>
					<th>Hình ảnh</th>
				</tr>

				<c:forEach var="item" items="${dienThoai}">
					<tr>
						<td>${item.tenDT}</td>
						<td>${item.namSanXuat}</td>
						<td>${item.cauHinh}</td>
						<td><img
							src="${pageContext.request.contextPath}/resources/images/${item.hinhAnh}"></td>
				</c:forEach>

			</table>
		</div>

		<!-- Footer Section -->
		<div class="footer">TranHuuTai – 21039651 – DHKTPM17B</div>
	</div>

</body>
</html>