<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>login page</h1>

	<form action="./login.gm" method="post">
		<table border="1">
			<tr>
				<th>ID</th>
				<td><input type="text" name="userName" placeholder="아이디"></td>
			</tr>
			<tr>
				<th>PW</th>
				<td><input type="password" name="password" placeholder="비밀번호"></td>
			</tr>
		</table>
		<button type="submit">로그인</button>
	</form>
</body>
</html>