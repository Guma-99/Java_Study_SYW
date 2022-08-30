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
	<c:import url="../template/header.jsp"></c:import>
		<form action="./login.do" method="post" id="frm">
		<section class="col-lg-6 container-fluid mt-4">
			<div class="mb-3">
				<label for="userId" class="form-label">ID</label>
				<input type="text" name="userName" value="admin" class="form-control" id="userId" aria-describedby="emailHelp">
				<div class="empty_userId" id="empty_userId"><div class = "userId_message"><strong>아이디</strong>를 입력해 주세요.</div></div>
			</div>
			
			<div class="mb-3">
				<label for="password" class="form-label">PW</label>
				<input type="password" name="password" value="admin" class="form-control" id="password">
				<div class="empty_password" id="empty_password"><div class= = "password_message"><strong>비밀번호</strong>를 입력해 주세요.</div></div>
			</div>
			
			<div class="mb-3 form-check">
				<input type="checkbox" class="form-check-input" id="exampleCheck1">
				<label class="form-check-label" for="exampleCheck1">로그인 상태 유지</label>
			</div>
			<button type="button" class="btn btn-dark" id="btn">로그인</button>
			</section>
		</form>

	<c:import url="../template/footer.jsp"></c:import>

	
	<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
	crossorigin="anonymous"></script>

	<script src="/resources/js/member.js"></script>
</body>
</html>