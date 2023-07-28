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
</head>
<body>
	<header>
		<h1>
			<a href="${rootPath}/">시외버스</a>
		</h1>
	</header>

	<div class="mypage">
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
		
		
		<div>
			<button type="button" class="update-btn">정보수정</button>
			<button type="button" class="delete-btn">회원탈퇴</button>
			<c:if test="${MYUSER.bu_id == 'test'}">
				<c:if test="${MSG != 'OK'}"><a href="mypage/savedb" class="db-btn">DB갱신</a></c:if>
				<c:if test="${MSG == 'OK'}"><div>DB갱신에 성공했습니다</div></c:if>
				<c:if test="${MSG == 'NO'}"><div>DB갱신에 실패했습니다</div></c:if>
			</c:if>
		</div>

	</div>
</body>
</html>