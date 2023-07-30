<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>터미널 위치조회</title>
<link href="${rootPath}/resources/css/area.css" rel="stylesheet">
</head>
<body>
	<div class="area">
		<header>
			<h1 class="home">
				<a href="${rootPath}/">시외버스</a>
			</h1>
		</header>
		<h2 class="signUpTitle">시외버스 터미널위치조회</h2>
		<form action="#">
			<label for="busStopSelect">터미널(정류장)</label> <select
				name="busStopSelect" id="busStop"
				onchange="selectOption(this.value);">
				<option value="1" selected>선택</option>
				<option value="광주송정역시외버스정류소">광주송정역시외버스정류소</option>
				<option value="송정리시외버스정류소">송정리버스정류소</option>
				<option value="우산동하남시외버스정류장">우산동(하남)시외버스정류장(승차)</option>
			</select>
		</form>

		<div id="map"></div>
	</div>

	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=393af6ea3a14898bb3bb27dd83f161cc&
	libraries=services">
		
	</script>
	<script src="${rootPath}/resources/js/searchArea.js" defer></script>
</body>
</html>