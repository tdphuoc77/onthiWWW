<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<%@include file="../layouts/header.jsp" %>

<div style="width: 70%;margin: auto auto;">

<c:forEach items="${listTP}" var="tp" varStatus="count">
		<div style="width: 30%;height: 200px;text-align: center;float: left;">
			<img alt="" style="width: 90%;height: 100px;margin:  auto auto;" src="<c:url value="/images/${tp.hinh}"/>">
			<br>
			<p>${tp.tenTP}</p>
			<a href="<c:url value="/tacpham/xemchitiet/${tp.maTP}" />">Xem chi tiet</a>
			
		</div>
		
</c:forEach>
	
</div>

<%@include file="../layouts/footer.jsp" %>
</body>
</html>