<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>
<link rel="stylesheet"
	href="${rootPath}/resources/css/find_idpw.css?${version}" />
</head>
<body>
<div class="wrapper">
		<h1>
			<a href="${rootPath}/">시외버스</a>
		</h1>
			<div class="findTitle">시외버스 ID/PW 찾기</div>
		<div>
	<c:choose>
		<c:when test="${empty F_ID }">
			<div>정보 없음</div>
		</c:when>
		<c:otherwise>
			<div>찾으시는 비밀번호 : ${F_ID.bu_password} 입니다! </div>
		</c:otherwise>
	</c:choose>
		</div>
</div>
	
</body>
</html>