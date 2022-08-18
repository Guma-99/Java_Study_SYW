<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<h2>----------BankMembers--------</h2>
<h4><a href="./member/login.do">로그인</a></h4>
<h4><a href="./member/join.do">회원가입</a></h4>
<h4><a href="./member/search.do">회원 검색</a></h4>
<h2>-----------BankBook---------</h2>
<h4><a href="./bankbook/list.do">통장 리스트</a></h4>
<h4><a href="./bankbook/add.do">통장 추가</a></h4>
<h2>-----------BankAccount----------</h2>
<h4><a href="./bankaccount/add.do">계좌 추가</a></h4>

</body>
</html>
