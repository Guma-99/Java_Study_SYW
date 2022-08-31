<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<header class="container-fluid">
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="../">GOODEE</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarText"
				aria-controls="navbarText" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarText">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link"
						href="../notice/list">공지사항</a></li>
						<li class="nav-item"><a class="nav-link"
						href="../qna/list">QnA</a></li>
					<li class="nav-item"><a class="nav-link"
						href="../bankbook/list.do">상품리스트</a></li>
					<li class="nav-item"><a class="nav-link"
						href="../member/search.do">회원검색</a></li>

						<c:choose>
							<c:when test="${not empty member}">
								<li class="nav-item"><a class="nav-link"
									href="../member/myPage.do">마이페이지</a></li>
								<li class="nav-item"><a class="nav-link"
									href="../member/logout.do">로그아웃</a></li>
							</c:when>
							<c:otherwise>
								<li class="nav-item"><a class="nav-link"
									href="../member/login.do">로그인</a></li>
								<li class="nav-item"><a class="nav-link"
									href="../member/agree">회원가입</a></li>
							</c:otherwise>
						</c:choose>
				</ul>
			</div>
		</div>
	</nav>
</header>