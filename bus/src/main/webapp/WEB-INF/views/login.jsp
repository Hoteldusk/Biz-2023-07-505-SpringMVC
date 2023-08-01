<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<c:set value="20230728-001" var="version" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>시외버스 - 로그인</title>

<link rel="stylesheet"
	href="${rootPath}/resources/css/join.css?${version}" />
<link rel="preconnect" href="https://fonts.googleapis.com" />
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
<link
	href="https://fonts.googleapis.com/css2?family=Dongle:wght@700&display=swap"
	rel="stylesheet" />
<script src="${rootPath}/resources/js/login.js?${version}"></script>
</head>
<body>
	<div class="wrapper">
		<header>
			<h1 class="home"><a href="${rootPath}/">시외버스</a></h1>
			<h2 class="signUpTitle">시외버스 로그인</h2>
		</header>
		<div class="failLogin">${FAIL}</div>
		<form action="" method="POST" class="join">
			<input placeholder="ID" name="bu_id" class="id" /> <input
				type="password" placeholder="비밀번호" name="bu_password" class="pwd1" />
			<input type="submit" value="로그인" class="submitBtn" />
		</form>
		<div class="login_etc">
			<a href="join.html">회원가입</a> | <a href="findIdPw.html">아이디/비번찾기</a>
		</div>
	</div>
</body>
</html>