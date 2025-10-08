<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm Điện Thoại</title>
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

form {
	background-color: #fff;
	max-width: 500px;
	margin: auto;
}

label {
	display: block;
}

input[type="text"], input[type="number"], input[type="date"], textarea{
	width: 100%;
	padding: 10px;
	margin-bottom: 15px;
	border: 1px solid #ccc;
	border-radius: 4px;
	font-size: 16px;
}

textarea {
	resize: vertical;
}

.submit-button {
	display: block;
	margin: 0 auto;
	padding: 10px;
}

select {
    width: 100%;
    padding: 10px;
    margin-bottom: 15px;
    border: 1px solid #ccc;
    border-radius: 4px;
    font-size: 16px;
    appearance: none; /* Xóa style mặc định của trình duyệt */
    background-color: white; /* Đặt nền trắng cho select */
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
			<a href="${pageContext.request.contextPath}/list">Danh sách sản
				phẩm</a> | <a href="${pageContext.request.contextPath}/managelist">Chức
				năng quản lý</a>
		</div>

		<!-- Form -->
		<form action="DienThoaiFormServlet" method="post"
			onsubmit="return validateForm()">
			<br> <label>Tên điện thoại:</label> <input type="text"
				id="tenDT" name="tenDT" required><br> <br> <label>Năm
				sản xuất:</label> <input type="text" id="namSanXuat" name="namSanXuat"
				required pattern="\d{4}"
				title="Năm sản xuất phải là số nguyên 4 chữ số"><br> <br>
			<label>Cấu hình:</label>
			<textarea id="cauHinh" name="cauHinh" rows="4" cols="50" required
				maxlength="255" pattern=".{1,255}"
				title="Cấu hình không được vượt quá 255 ký tự"></textarea>
			<br> <br> <label>Mã nhà cung cấp:</label> <select
				id="maNCC" name="maNCC" required>
				<c:forEach var="nhaCungCap" items="${nhaCungCapList}">
					<option class="nhaCC" value="${nhaCungCap.maNCC}">${nhaCungCap.maNCC}</option>
				</c:forEach>
			</select><br> <br> <label>Hình ảnh:</label> <input type="file"
				id="hinhAnh" name="hinhAnh"
				accept="image/png, image/jpg, image/jpeg" required><br>

			<br> <input class="submit-button" type="submit" value="Thêm">
		</form>

		<!-- Footer Section -->
		<div class="footer">TranHuuTai – 21039651 – DHKTPM17B</div>
	</div>

	<script>
		function validateForm() {
			// Kiểm tra file hình ảnh
			var fileInput = document.getElementById('hinhAnh');
			var filePath = fileInput.value;

			// Định dạng được phép
			var allowedExtensions = /(\.jpg|\.jpeg|\.png)$/i;

			if (!allowedExtensions.exec(filePath)) {
				alert('Chỉ chấp nhận các định dạng: .png, .jpg, .jpeg');
				fileInput.value = '';
				return false;
			}

			return true; // Cho phép gửi form nếu kiểm tra hợp lệ
		}
	</script>


</body>
</html>