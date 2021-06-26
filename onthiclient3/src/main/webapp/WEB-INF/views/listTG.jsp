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

<table >
	
	<tr> 
		<th>STT </th>
		<th>maTG </th>
		<th>hoTen </th>
		<th>linhVuc </th>
		<th>tieuSu </th>
		<th>Quan ly </th>
	</tr>
	
<c:forEach items="${listTG}" var="tg" varStatus="count">

		<tr> 
			<td>${count.count }</td>
			<td>${tg.maTG } </td>
			<td>${tg.hoTen } </td>
			<td>${tg.linhVuc } </td>
			<td>${tg.tieuSu } </td>
			<td>
			<a href="<c:url value="/tacgia/update/${tg.maTG}" />">Update</a>
			||
			<a href="<c:url value="/tacpham/tacgia/${tg.maTG}" />">Xem tac Pham</a>
			</td>
		</tr>
		
		
		
</c:forEach>
</table>
</div>

<%@include file="../layouts/footer.jsp" %>
</body>
</html>