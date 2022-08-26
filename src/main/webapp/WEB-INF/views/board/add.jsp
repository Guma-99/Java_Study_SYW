<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- JQUERY -->
<script type="text/javascript"
	src="//code.jquery.com/jquery-3.6.0.min.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">

<!-- include summernote css/js -->
<link
	href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>

</head>
<body>
	<!-- header import -->
	<c:import url="../template/header.jsp"></c:import>

	<h1>${board}</h1>
	<form action="add" method="POST" enctype="multipart/form-data">
		<section class="container-fluid col-lg-8 mt-5">
			<div>
				<div style="text-align: center">
					<h2>추가</h2>
					<br>
				</div>
				<table class="table table-striped">
					<tr>
						<th>title</th>
						<th>writer</th>
						<th>content</th>
					</tr>
					<tr>
						<input type="hidden" name="num" value="${boardDTO.num}">
						<td><input type="text" name="title"></td>
						<td><input type="text" name="writer"></td>
						<td>
							<textarea class="form-control" name="contents" id="contents" rows="3">${boardDTO.contents}</textarea>
						</td>
						<td><input type="file" name="files"></td>
						<td><input type="file" name="files"></td>
						<td><input type="file" name="files"></td>
					</tr>
				</table>
				<br>
				<div class="mb-3">
					<button class="btn btn-success">WRITE</button>
				</div>
			</div>
		</section>
	</form>
	<!-- footer import -->
	<c:import url="../template/footer.jsp"></c:import>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
		crossorigin="anonymous"></script>

	<script type="text/javascript">
		$("#contents").summernote();
		</script>
</body>
</html>