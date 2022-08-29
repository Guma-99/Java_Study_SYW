<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">
</head>
<body>
	<!-- header import -->
	<c:import url="../template/header.jsp"></c:import>
	<section class="container-fluid col-lg-8 mt-5">
		<div>
			<div style="text-align: center">
				<h2>상세보기</h2>
				<br>
			</div>
			<h1>${board}</h1>
			<table class="table table-striped">
				<thead>
					<tr>
						<th>No</th>
						<th>Title</th>
						<th>contents</th>
						<th>writer</th>
						<th>date</th>
						<th>hit</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>${boardDTO.num}</td>
						<td>${boardDTO.title}</td>
						<td>${boardDTO.contents}</td>
						<td>${boardDTO.writer}</td>
						<td>${boardDTO.regDate}</td>
						<td>${boardDTO.hit}</td>
					</tr>
					<tr>
						<th>청부파일</th>
						<td><c:forEach items="${boardDTO.boardFileDTOs}" var="fileDTO">
								<p>
									<a href="../resources/upload/${board}/${fileDTO.fileName}">${fileDTO.oriName}</a>
								</p>
							</c:forEach></td>
					</tr>

				</tbody>
			</table>
			<br> <a href="./list.do">리스트 보기</a> <br> <br> <a
				href="./update.do?bookNum=${boardDTO.num}">수정하기</a> <a
				href="./delete.do?bookNum=${boardDTO.num}">삭제하기</a>
			<c:if test="${not empty sessionScope.member}">
				<a href="./add?num=${boardDTO.num}">가입하기</a>
			</c:if>
		</div>
	</section>

	<div class="row">
		<a href="./reply?num=${boardDTO.num }" class="btn btn-danger">Reply</a>
	</div>

	<!-- footer import -->
	<c:import url="../template/footer.jsp"></c:import>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
		crossorigin="anonymous"></script>
</body>
</html>