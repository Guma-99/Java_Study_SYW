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
	<section class="container-fluid col-lg-3 mt-5">
		<div>
			<form action="search.do" method="post" class="row g-8">
				<div class="col-auto">
					<label for="inputPassword2" class="visually-hidden">search</label>
					<input type="text" name="search" class="form-control" id="inputPassword2" placeholder="검색할 아이디를 입력하세요.">
				</div>
				<div class="col-auto">
					<button type="submit" class="btn btn-primary mb-3">검색</button>
				</div>
			</form>
		</div>
	</section>
	<c:import url="../template/footer.jsp"></c:import>

	<scriptsrc ="https://cdn.jsdelivr.net/npm/bootstrap
		@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
		crossorigin="anonymous"> </script>
</body>
</html>