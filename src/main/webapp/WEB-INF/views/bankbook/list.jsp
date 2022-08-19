<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Page</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	<section class="container-fluid col-lg-8 mt-5">
		<div>
			<div style="text-align: center">
				<h2>회원 검색 결과</h2>
				<br>
			</div>
			<table class="table table-striped">
				<tr>
					<th>계좌 이름</th>
					<th>이자율</th>
				</tr>
				<c:forEach items="${list}" var="dto">
					<tr>
						<td><a href="./detail.do?bookNum=${dto.bookNum}">${dto.bookName}</a>
						</td>
						<td>${dto.bookRate}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</section>
	<br>
	
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
		crossorigin="anonymous"></script>
</body>
</html>