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
<form:form action="/onthiclient3/home" method="get" modelAttribute="tp">
	
		<label style="width:10%; ">maTP :</label>
		<label >${tp.maTP }</label>
		<br>
		<label style="width:10%; ">tenTP :</label>
		<label >${tp.tenTP }</label>
		<br>
		<label style="width:10%; ">loaiTP :</label>
		<label >${tp.loaiTP }</label>
		<br>
		<label style="width:10%; ">soTrang :</label>
		<label >${tp.soTrang }</label>
		<br>
		<label style="width:10%; ">gia :</label>
		<label >${tp.gia }</label>
		<br>
		<label style="width:10%; ">tomtat :</label>
		<label >${tp.tomtat }</label>
		<br>
		<label style="width:10%; ">hinh :</label>
		<br>
		<img alt="" style="width: 100px;height: 100px;margin:  auto auto;" src="<c:url value="/images/${tp.hinh}"/>">
		<br>
		
		<input type="submit" value="Quay Lai">
</form:form>
<%@include file="../layouts/footer.jsp" %>
</body>
</html>