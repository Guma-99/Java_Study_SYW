<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Join Page</h2>
	<hr>
	<form action="./join.do" method="post">

		<h4>아이디</h4>
		<input type="text" name="userName">
		<h4>비밀번호</h4>
		<input type="password" name="password">
		<h4>이름</h4>
		<input type="text" name="name">
		<h4>이메일</h4>
		<input type="email" name="email" placeholder="***@goodee.co.kr">
		<h4>전화번호</h4>
		<input type="tel" name="phone" placeholder="하이픈(-)없이 숫자만 입력">
		<br> <br> <input type="submit" value="가입하기"> <br>

	</form>
	<a href="../">home</a>
</body>
</html>