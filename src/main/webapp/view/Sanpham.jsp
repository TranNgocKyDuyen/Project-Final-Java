<%@page import="dao.Sanphams"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Thông tin sản phẩm</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<%@ page import = "model.Sanpham" %>
	<%@ page import = "dao.Sanphams" %>
    <%
    String id=request.getParameter("currSanphamID"); 
            	System.out.print(id);
        		Sanpham Sanpham = Sanphams.getSanpham(id);
    %>
	<form action="Sanpham" method="post">
		<div class="container" style="width: 50%; justify-content: center;">
			<div >
				<label class="form-label">Mã sản phẩm</label> 
				<input type="text" class="form-control" placeholder="Nhập mã sản phẩm" name ="id" value="<%= Sanpham.getId()%>"/>
			</div>
			<div >
				<label class="form-label">Tên sản phẩm</label> 
				<input type="text" class="form-control" placeholder="Nhập mã sản phẩm" name ="id" value="<%= Sanpham.getTensp() %>"/>
			</div>
			<div >
				<label class="form-label">Giá bán</label> 
				<input type="text" class="form-control" placeholder="Nhập giá bán" name ="Gia"  value="<%= Sanpham.getGia()%>"/>
			</div>
			<div >
				<label class="form-label">Mô tả sản phẩm</label> 
				<input type="text" class="form-control" placeholder="Nhập mã sản phẩm" name ="id" value="<%= Sanpham.getMota()%>"/>
			</div>
			
			<div style="float: right;">
				<button type="submit" class="btn btn-primary" name="button" value="save">Lưu</button>
				<button type="submit" class="btn btn-primary" name="button" value="closebook">Đóng</button>
			</div>
		</div>
	</form>



</body>
</html>
