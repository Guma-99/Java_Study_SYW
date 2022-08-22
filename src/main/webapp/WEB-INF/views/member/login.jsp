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
		<form action="./login.do" method="post">
		<section class="col-lg-6 container-fluid mt-4">
			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">ID</label>
				<input type="text" name="userName" value="admin" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
				<div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
			</div>
			
			<div class="mb-3">
				<label for="exampleInputPassword1" class="form-label">PW</label>
				<input type="password" name="password" value="admin" class="form-control" id="exampleInputPassword1">
			</div>
			
			<div class="mb-3 form-check">
				<input type="checkbox" class="form-check-input" id="exampleCheck1">
				<label class="form-check-label" for="exampleCheck1">로그인 상태 유지</label>
			</div>
			<button type="submit" class="btn btn-dark">로그인</button>
			</section>
		</form>

	<c:import url="../template/footer.jsp"></c:import>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
		crossorigin="anonymous"></script>
</body>
</html>