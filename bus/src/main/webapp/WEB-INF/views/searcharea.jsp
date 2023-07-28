<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>터미널 위치조회</title>

</head>
<body>
	<header>
		<h1 class="home">시외버스</h1>
		<h2 class="signUpTitle">시외버스 터미널위치조회</h2>
	</header>
	<select>
		<select name="busStopSelect" id="busStop"
		onchange="selectOption(this.value);">
			<option value="1" selected>선택</option>
			<option value="광주송정역시외버스정류소">광주송정역시외버스정류소</option>
			<option value="송정리시외버스정류소">송정리버스정류소</option>
			<option value="우산동하남시외버스정류장">우산동(하남)시외버스정류장(승차)</option>
	</select>
	</select>
	<!-- 이미지 지도를 표시할 div 입니다 -->
	<div id="staticMap" style="width: 600px; height: 350px;"></div>
	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=393af6ea3a14898bb3bb27dd83f161cc
"></script>
	<script>
		// 이미지 지도에서 마커가 표시될 위치입니다 
		var markerPosition = new kakao.maps.LatLng(37.1775, 126.8811);

		// 이미지 지도에 표시할 마커입니다
		// 이미지 지도에 표시할 마커는 Object 형태입니다
		var marker = {
			position : markerPosition
		};

		var staticMapContainer = document.getElementById('staticMap'), // 이미지 지도를 표시할 div  
		staticMapOption = {
			center : new kakao.maps.LatLng(37.1775, 126.8811), // 이미지 지도의 중심좌표
			level : 3, // 이미지 지도의 확대 레벨
			marker : marker
		// 이미지 지도에 표시할 마커 
		};

		// 이미지 지도를 생성합니다
		var staticMap = new kakao.maps.StaticMap(staticMapContainer,
				staticMapOption);
	</script>
</body>
</html>