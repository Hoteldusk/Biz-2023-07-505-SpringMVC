<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${rootPath}/resources/css/join.css?${version}" />
<link rel="preconnect" href="https://fonts.googleapis.com" />
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
<link
	href="https://fonts.googleapis.com/css2?family=Dongle:wght@700&display=swap"
	rel="stylesheet" />
<script src="${rootPath}/resources/js/findIdPw.js?${version}"></script>
</head>
<body>
<div class="wrapper">
		<h1>
			<a href="${rootPath}/">시외버스</a>
		</h1>
		<div class="findTitle">시외버스 ID/PW 찾기</div>

		<form class="findID" method="POST" action="${rootPath}/find_Id">
			<div class="subTitle">ID 찾기</div>
			<div>
				<input class="form" id="bu_name" name="bu_name"
					placeholder="이름을 입력해 주세요." />
			</div>
			<div>
				<input class="form" id="bu_tel" name="bu_tel"
					placeholder="휴대폰 번호를 입력해 주세요." />
			</div>
			<button type="button" class="find_button" id="find_button1">
				아이디 찾기</button>
		</form>

		<form class="findPW" method="POST" action="${rootPath}/find_Pw">
			<div class="subTitle">PASSWORD 찾기</div>
			<div>
				<input class="form" id="bu_id" name="bu_id"
					placeholder="이메일을 입력해주세요." />
			</div>
			<div>
				<input class="form" id="bu_tel" name="bu_tel"
					placeholder="휴대폰 번호를 입력해 주세요." />
			</div>
			<button type="submit" class="find_button" id="find_button2">
				비밀번호 찾기</button>
		</form>
	</div>
</body>
</html>