<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<%@include file="../layouts/header.jsp"%>

	<div style="width: 40%; margin: auto auto">
		<form:form method="POST" modelAttribute="tg">
			<form:hidden path="maTG" />

			<table>
				<tr>
					<td>hoTen:</td>
					<td><form:input path="hoTen" /></td>
					<td><form:errors path="hoTen" />  </td>
				</tr>
				<tr>
					<td>linhVuc:</td>
					<td><form:input path="linhVuc" /></td>
					<td><form:errors path="linhVuc" />  </td>
				</tr>
				<tr>
					<td>tieuSu:</td>
					<td><form:input path="tieuSu" /></td>
					<td><form:errors path="tieuSu" />  </td>
					
				</tr>
				<tr>
					<td><input type="submit" value="Submit"></td>
				</tr>
			</table>




		</form:form>


	</div>

	<%@include file="../layouts/footer.jsp"%>
</body>
</html>