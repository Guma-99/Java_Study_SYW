
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Book</title>
</head>
<body>
<h1>Add Book Page</h1>
<form action="add.do" method = "POST">
<div>
계좌명
<br>
<input type="text" name= "bookName"><br>
</div>
<div>
이자율
<br>
<input type= "text" name = "bookRate"><br><br>
</div>
<div>
<input type="submit" value="계좌 등록">
<button type="submit">Add</button>
</div>
</form> 
</body>
</html>