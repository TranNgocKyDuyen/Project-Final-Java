<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Thông tin Sách</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

	<div class="container" style="width: 50%">
		<form action="Sanpham" method="POST">
			<input type="hidden" id="currSanphamID" name="currSanphamID">
			<table class="table table-striped">
				<thead>
					<tr>
						<th scope="col">Mã sản phẩm</th>
						<th scope="col">Tên sản phẩm</th>
						<th scope="col">Giá</th>
						<th scope="col">Mô tả sản phẩm</th>

					</tr>
				</thead>
				<tbody>

					<c:forEach items="${Sanpham}" var="book">
						<tr id = "${Sanpham.id}" onclick="rowClick(this)">
							<td><c:out value="${Sanpham.id}" /></td>
							<td><c:out value="${Sanpham.tensp}" /></td>
							<td><c:out value="${Sanpham.Gia}" /></td>
							<td><c:out value="${Sanpham.mota}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div style="float: right;">

				<button type="submit" class="btn btn-primary" name="button" value="add">Thêm</button>
				<button type="submit" class="btn btn-primary" name="button" value="delete">Xóa</button>
				<button type="submit" class="btn btn-primary" name="button" value="edit">Chỉnh sửa</button>
				<button type="submit" class="btn btn-primary" name="button" value="close">Đóng</button>

			</div>
			
		</form>
	</div>
	
	<script type="text/javascript">
		function rowClick(e){
			document.getElementById("currSanphamID").value =e.id;
		}
	</script>

</body>
</html>