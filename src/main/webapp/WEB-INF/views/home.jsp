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

<h2><a href="./member/login.do">Login</a></h2>
<h2><a href="./member/join.do">Join</a></h2>
<h2><a href="./member/search.do">Search</a></h2>
<h2>--------------------------</h2>
<h2><a href="./bankbook/list.do">List</a></h2>
<h2><a href="./bankbook/add.do">Add</a></h2>

</body>
</html>
