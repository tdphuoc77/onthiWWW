<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header style="width: 100%;height: 100px;text-align: center;">
		<a href="<c:url value="/home" />">Danh sach tac pham</a>
		||
		<a href="<c:url value="/tacgia" />">Danh sach tac gia</a>
		||
		<a href="<c:url value="/tacpham/add" />">Them tac pham</a>
		||
		<a href="<c:url value="/tacgia/add" />">Them tac gia</a>
		||
		<a href="<c:url value="/tacpham/quanly" />">Quan ly</a>
		||
		<a href="<c:url value="/logout" />">Logout</a>
		<hr>
	</header>

</body>
</html>