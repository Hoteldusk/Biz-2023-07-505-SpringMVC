<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<link rel="preconnect" href="https://fonts.googleapis.com" />
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
<link
	href="https://fonts.googleapis.com/css2?family=Dongle:wght@700&display=swap"
	rel="stylesheet" />
<title>시외버스 - 즐겨찾기</title>
<link href="${rootPath}/resources/css/usually.css" rel="stylesheet">
<script type="text/javascript">
var rootPath = "${rootPath}";
</script>
<script type="text/javascript" src="${rootPath}/resources/js/usually.js"></script>

</head>
<body>
	<div class="usually box">
		<header>
			<h1>
				<a href="${rootPath}/">시외버스</a>
			</h1>
			<h2>즐겨찾기</h2>
		</header>
		<table class="us table">
			<tr>
				<th>출발지</th>
				<th>목적지</th>
			</tr>
			<c:forEach items="${USLIST}" var="US">
				<tr data-stcode = "${US.us_stcode}" data-etcode = "${US.us_etcode}">
					<td>${US.s_terminal}</td>
					<td>${US.e_terminal}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>