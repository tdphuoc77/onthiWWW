<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<%@include file="../layouts/header.jsp"%>
	
	<div style="width: 40%; margin:  auto auto">
		<form:form method="post"  modelAttribute="tp" enctype="multipart/form-data">
		<form:hidden path="maTP"/>
		<br>
		tenTP:
		<form:input path="tenTP"/>
		<form:errors path="tenTP" />
		<br>
		<br>
		soTrang:
		<form:input type="number" path="soTrang"/>
		<form:errors path="soTrang" />
		<br>
		<br>
		loaiTP:
		<form:input path="loaiTP"/>
		<form:errors path="loaiTP" />
		<br>
		<br>
		gia:
		<form:input type="number" path="gia"/>
		<form:errors path="gia" />
		<br>
		<br>
		tomtat:
		<form:input path="tomtat"/>
		<form:errors path="tomtat" />
		<br>
		<br>
		Chọn hình :
		<input type="file" name="h">
		<form:errors path="hinh" />
		<br>
		<br>
		
		tac gia:
		<select name="maTG">
				<c:forEach items="${listTG}" var="tg">
					<option value="${tg.maTG}">${tg.hoTen}</option>
				</c:forEach>
		</select>
			<br>
			<br>
			<input type="submit" value="Submit" >
			
		</form:form>


	</div>
	
	<%@include file="../layouts/footer.jsp"%>
</body>
</html>