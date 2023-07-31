<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="C"%>
<C:set value="20230713-001" var="version"></C:set>
<C:set value="${pageContext.request.contextPath}" var="rootPath"></C:set>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>시외버스</title>
<link rel="stylesheet" href="${rootPath}/resources/css/main.css" />

<link rel="preconnect" href="https://fonts.googleapis.com" />
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
<link
	href="https://fonts.googleapis.com/css2?family=Dongle:wght@700&display=swap"
	rel="stylesheet" />

<script src="${rootPath}/resources/js/home.js"></script>
</head>
<body class="slide-in">
	<div class="container">
		<div class="circle red" color="red"></div>
		<div class="circle" color="yellow"></div>
		<div class="circle" color="green"></div>
	</div>
	<div id="full">
		<header>
			<h1>시외버스</h1>
		</header>
		<div class="user">
			<C:if test="${LOGINOUT == 'LOGIN'}">
				<h1>
					<a href="${rootPath}/login">${LOGINOUT}</a>
				</h1>
			</C:if>
			<C:if test="${LOGINOUT == 'LOGOUT'}">
				<h1>
					<a href="${rootPath}/logout">${LOGINOUT}</a>
				</h1>
			</C:if>

			<C:if test="${not empty LOGINUSER}">
				<h1>
					<a href="${rootPath}/mypage">${LOGINUSER.bu_name}</a>
				</h1>
			</C:if>
			
			<C:if test="${LOGINOUT == 'LOGIN'}">
				<h1>
					<a href="${rootPath}/join">회원가입</a>
				</h1>
			</C:if>
			<C:if test="${LOGINUSER.bu_id == 'test'}">
				<h1>
					<a href="${rootPath}/userprint">유저조회</a>
				</h1>
			</C:if>
		</div>

		<section class="main">
			<article>
				<a href="${rootPath}/nosun"> <img
					src="${rootPath}/resources/img/bus.png" width="125px"
					height="175px" /> <span>노선 조회</span>
				</a>
			</article>
			<article>
				<a href="${rootPath}/searcharea"> <img
					src="${rootPath}/resources/img/terminalarea.png" width="125px"
					height="175px" /> <span>터미널 위치 조회</span>
				</a>
			</article>
			<article>
				<a href="${rootPath}/usually"> <img
					src="${rootPath}/resources/img/usually.png" width="125px"
					height="175px" /> <span>즐겨찾기</span>
				</a>
			</article>
			<article>
				<a
					href="https://www.usquare.co.kr/kor/usquare/reservation.do?mode=reservationList&srCategoryId1=9"><img
					src="${rootPath}/resources/img/busStop.png" width="125px"
					height="175px" /> <span>예매 사이트 이동</span></a>
			</article>
		</section>
		<div id="light"></div>
		<div class="line"></div>
		<div class="line"></div>
	</div>
	<div id="bottom">
		<div></div>
		<div></div>
	</div>
</body>
</html>