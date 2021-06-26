<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
</style>
</head>
<body>
<%@include file="../layouts/header.jsp" %>

<div style="width: 70%;margin: auto auto;">
<form action="<c:url value="/tacpham/quanly/timkiem" />">
	<label>Nhap:</label>
	<input name="key" type="text">
	<input type="submit" value="search"  >
	<br>
	<a href="<c:url value="/tacpham/quanly/gia/tang" />">Sắp xếp giá tăng</a>
	||
	<a href="<c:url value="/tacpham/quanly/gia/giam" />">Sắp xếp giá giảm</a>
	<br>
	<hr>
</form>
<table >
	
	<tr> 
		<th>STT </th>
		<th>maTP </th>
		<th>tenTP </th>
		<th>loaiTP </th>
		<th>soTrang </th>
		<th>gia </th>
		<th>tomtat </th>
		<th>hinh </th>
		<th>tacGia </th>
		<th>Quan ly </th>
	</tr>
	
<c:forEach items="${listTP}" var="tp" varStatus="count">

		<tr> 
			<td>${count.count }</td>
			<td>${tp.maTP } </td>
			<td>${tp.tenTP } </td>
			<td>${tp.loaiTP } </td>
			<td>${tp.soTrang } </td>
			<td>${tp.gia } </td>
			<td>${tp.tomtat } </td>
			<td><img alt="" style="width: 100px;height: 100px;margin:  auto auto;" src="<c:url value="/images/${tp.hinh}"/>"></td>
			<td>${tp.tacGia.hoTen } </td>
			<td>
			<a href="<c:url value="/tacpham/update/${tp.maTP}" />">Update</a>
			||
			<a href="<c:url value="/tacpham/delete/${tp.maTP}" />">Delete</a>
			</td>
		</tr>
		
		
		
</c:forEach>
</table>
</div>

<%@include file="../layouts/footer.jsp" %>
</body>
</html>