<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Account Add</title>
</head>
<body>
<h1>Account Add Page</h1>
<form action="add.do" method="post">
	<table border="1">
		<tr>
			<td>아이디</td>
			<td>일련번호</td>
		</tr>
		<tr>
			<td><input type="text" name="userName"></td>
			<td><input type="text" name="bookNum"></td>
		</tr>
	</table>
	<br>
	<button type="submit" value="계좌 등록">계좌 등록</button>
</form>

</body>
</html>