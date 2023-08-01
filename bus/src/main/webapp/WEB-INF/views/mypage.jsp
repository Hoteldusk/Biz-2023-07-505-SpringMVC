<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<link href="${rootPath}/resources/css/mypage.css" rel="stylesheet" />
<script>
	var rootPath = "${rootPath}";
</script>
<script src="${rootPath}/resources/js/mypage.js"></script>
</head>
<body>
	<header>
		<h1>
			<a href="${rootPath}/">시외버스</a>
		</h1>
	</header>

	<div id = "mypage" class="mypage">
		<div>
			<strong>아이디</strong>
			<div>${MYUSER.bu_id}</div>
		</div>
		<div>
			<strong>패스워드</strong>
			<div>${MYUSER.bu_password}</div>
		</div>
		<div>
			<strong>이름</strong>
			<div>${MYUSER.bu_name}</div>
		</div>
		<div>
			<strong>전화번호</strong>
			<div>${MYUSER.bu_tel}</div>
		</div>
		<div class="button">
			<a href="${rootPath}/updateuser">정보수정</a> <a
				href="${rootPath}/delete?id=${MYUSER.bu_id}">회원탈퇴</a>
		</div>

		<div>
			<c:if test="${MYUSER.bu_id == 'test'}">
				<button type="button" id="db_btn" class="db_btn">DB갱신</button>
			</c:if>
		</div>
	</div>
</body>
</html>