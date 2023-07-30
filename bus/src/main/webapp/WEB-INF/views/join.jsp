<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath"></c:set>
<c:set value="20230728-001" var="version" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${rootPath}/resources/css/join.css?${version}"
	rel="stylesheet" />
<script src="${rootPath}/resources/js/join.js?${version}"></script>
</head>
<body>
	<div class="wrapper">
		<header>
			<h1 class="home">시외버스</h1>
			<h2 class="signUpTitle">시외버스 회원가입</h2>
		</header>
		
		<form action="" method="POST" class="join">
			<input placeholder="ID" name="bu_id" class="id" />
			<div class="sameId">${SAMEID}</div> 
			<input	type="password" placeholder="비밀번호" name="bu_password" class="pwd1" />
			<input class="pwd2" name="bu_passwordcheck" type="password"	placeholder="비밀번호 확인" />
			<input class="name" name="bu_name"	placeholder="이름" />
			<input class="tel" name="bu_tel"	placeholder="휴대폰 번호" />

			<div class="divideLine"></div>
			<input type="submit" value="가입" class="submitBtn" />
		</form>
	</div>
</body>
</html>