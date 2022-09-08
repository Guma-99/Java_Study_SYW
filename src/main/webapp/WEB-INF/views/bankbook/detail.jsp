<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Detail Page</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">

</head>

<body>
	<c:import url="../template/header.jsp"></c:import>
	<section class="container-fluid col-lg-6">
		<div class="row">
			<div style="text-align: center">
				<h1>Detail Page</h1>
				<br>
			</div>
			<table class="table table-dark">
				<thead>
					<tr>
						<td>BOOKNUM</td>
						<td>BOOKNAME</td>
						<td>BOOKRATE</td>
						<td>BOOKSALE</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>${one.bookNum}</td>
						<td>${one.bookName}</td>
						<td>${one.bookRate}</td>
						<td>${one.bookSale}</td>
					</tr>

				</tbody>
			</table>
			<br> <a href="./list.do">리스트 보기</a> <br> <br> <a
				href="./update.do?bookNum=${one.bookNum}">수정하기</a> <a
				href="./delete.do?bookNum=${one.bookNum}">삭제하기</a>
			<c:if test="${not empty sessionScope.member}">
				<a href="../bankAccount/add.do">가입하기</a>
			</c:if>

			<!-- Comment insert -->
			<div class="row">
				<div class="mb-3">
					<label for="writer" class="form-label">USERNAME</label> <input
						type="text" class="form-control" id="writer">
				</div>
				<div class="mb-3">
					<label for="contents" class="form-label">WRITER CONTENTS</label>
					<textarea class="form-control" id="contents" rows="3"></textarea>
				</div>
				<div class="mb-3">
					<button id="comment_btn" type="button"
						data-booknum="${one.bookNum}">작성</button>
				</div>
			</div>
			<!-- Comment list 영업시작-->
			<div>
				<table id="commentList" class="table table-striped">


				</table>
			</div>
			<button id="more" class="btn btn-danger disabled">더보기</button>


			<!-- modal button -->
			<div>
				<button type="button" style="display: none;" class="btn btn-primary" id="up" data-bs-toggle="modal" data-bs-target="#exampleModal" data-bs-whatever="@getbootstrap">
					Open modal for @getbootstrap</button>

				<div class="modal fade" id="exampleModal" tabindex="-1"
					aria-labelledby="exampleModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="exampleModalLabel">update</h5>
								<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
							</div>
							<div class="modal-body">
								<form>
									<div class="mb-3">
										<label for="recipient-name" class="col-form-label">writer</label>
										<input type="text" class="form-control" id="recipient-name">
									</div>
									<div class="mb-3">
										<label for="message-text" class="col-form-label">contents</label>
										<textarea class="form-control" id="message-text"></textarea>
									</div>
								</form>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
								<button type="button" class="btn btn-primary">Send message</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<c:import url="../template/footer.jsp"></c:import>




	<script src="/resources/js/bankbookComment.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
		crossorigin="anonymous"></script>

</body>

</html>