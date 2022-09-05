<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<section class="container-fluid col-lg-8 mt-5 ml-5">
		<div>
			<form action="./join.do" method="post" enctype="multipart/form-data" id="joinForm">
				<div class="col-md-3">
					<label for="id" class="form-label">아이디</label>
					<input type="text" name="userName" class="form-control" id="id">
					<div id="id_div" style="color: red; display: none">
						아이디는 2글자 이상이어야 합니다.
					</div>
				</div>
				<div class="col-md-3">
					<label for="pw" class="form-label">비밀번호</label>
					<input type="password" name="password" class="form-control" id="pw">
					<div id="pw_div" style="color: red; display: none">
						비밀번호는 최소 6글자 이상이어야 합니다.
					</div>
				</div>
				<div class="col-md-3">
					<label for="pw2" class="form-label">비밀번호 재확인</label>
					<input type="password" name="password2" class="form-control" id="pw2">
					<div id="pw2_div" style="color: red; display: none">
						비밀번호가 일치하지 않습니다.
					</div>
				</div>
				<div class="col-3">
					<label for="names" class="form-label">이름</label>
					<input type="text" name="name" class="form-control" id="names" placeholder="홍길동">
					<div id="names_div" style="color: red; display: none">
						이름은 최소 1글자 이상이어야 합니다.
					</div>
				</div>
				<div class="col-3">
					<label for="email" class="form-label">이메일</label>
					<input type="email" name="email" class="form-control" id="email" placeholder="***@goodee.co.kr">
					<div id="email_div" style="color: red; display: none">
						이메일은 최소 1글자 이상이어야 합니다.
					</div>
				</div>
				<div class="col-md-3">
					<label for="phone" class="form-label">전화번호</label>
					<input type="text" name="phone" class="form-control" id="phone" placeholder="하이픈(-)없이 숫자만 입력">
					<div id="phone_div" style="color: red; display: none">
						전화번호는 최소 1글자 이상이어야 합니다.
					</div>
				</div>
				<div class="col-md-3">
					<label for="photo" class="form-label">첨부파일</label>
					<input type="file" name="photo" class="form-control" id="photo">
				</div>
				<div class="col-12">
					<button type="button" id="joinButton" class="btn btn-primary">가입하기</button>
					<br>
				</div>
			</form>
		</div>
	</section>
	<c:import url="../template/footer.jsp"></c:import>

	<scriptsrc ="https://cdn.jsdelivr.net/npm/bootstrap
		@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
		crossorigin="anonymous"> </script> <script
		src="/resources/js/member.js"></script> <script>
			joinCheck();
		</script>
</body>
</html>