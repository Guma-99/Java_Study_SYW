
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
	<!-- header import -->
	<c:import url="../template/header.jsp"></c:import>
	<section class="container-fluid col-lg-8 mt-5">
		<div style="text-align: center">
			<h2>${board}<h2>
					<br>
		</div>
		<div>
			<form class="row row-cols-lg-auto g-3 align-items-center">
				<div class="col-12">
					<label class="visually-hidden" for="kind">kind</label> <select
						name="kind" class="form-select" id="kind">
						<option class="kinds" value="title">Title</option>
						<option class="kinds" value="contents">Contents</option>
						<option class="kinds" value="writer">Writer</option>
					</select>
				</div>

				<div class="col-12">
					<label class="visually-hidden" for="search">search</label>
					<div class="input-group">
						<input type="text" name="search" value="${param.search}" class="form-control"
							id="search" placeholder="검색어를 입력해주세요">
					</div>
				</div>

				<div class="col-12">
					<button type="submit" class="btn btn-primary">검색</button>
				</div>
			</form>

			<table class="table table-striped">
				<thead>
					<th>No</th>
					<th>Title</th>
					<th>Writer</th>
					<th>Date</th>
					<th>Hit</th>
				</thead>
				<tbody>

					<c:forEach items="${requestScope.list}" var="dto">
						<tr>
							<td>${dto.num}</td>
							<td>
								<c:catch>
									<c:forEach begin="1" end="${dto.depth}">--</c:forEach>
								</c:catch>
								<a href="./detail?num=${dto.num}">${dto.title}</a></td>
							<%-- <td><a href="./detail?num=${dto.num }">${dto.title}</a></td> --%>
							<td>${dto.writer}</td>
							<td>${dto.regDate}</td>
							<td>${dto.hit}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<button onclick="location='add'">글쓰기</button>
		</div>
		<nav aria-label="Page navigation example">
			<ul class="pagination">
				<li class="page-item  ${pager.pre?'':'disbled' }"><a
					class="page-link"
					href="./list?page=${pager.startNum - 1} &kind=${pager.kind} &search=${pager.search}}"
					aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
				</a></li>

				<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
					<li class="page-item"><a class="page-link"
						href="./list?page=${i} &kind=${pager.kind} &search=${pager.search}">${i}</a></li>
				</c:forEach>

				<%-- <c:choose>
					<c:when test="${pager.next}">
						<li class="page-item">
					</c:when>
					<c:otherwise>
						<li class="page-item disabled">
					</c:otherwise>
				</c:choose> --%>
				<li class="page-item ${pager.next?'':'disbled' }"><a
					class="page-link"
					href="./list?page=${pager.lastNum + 1} &kind=${pager.kind} &search=${pager.search}"
					aria-label="Next"> <span aria-hidden="true">&raquo;</span>
				</a></li>
			</ul>
		</nav>
	</section>

	<!-- footer import -->
	<c:import url="../template/footer.jsp"></c:import>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
		crossorigin="anonymous"></script>
	
	<script src="/resources/js/board.js"></script>
	<script>
		let k = '${param.kind}';
		const kind = document.getElementsByClassName("kinds");

		for(let i = 0; i < kinds.length; i++) {
			if(kinds[i].value == k) {
				kinds[i].selected = true;
				break;
			}
		}
		
	</script>
</body>
</html>