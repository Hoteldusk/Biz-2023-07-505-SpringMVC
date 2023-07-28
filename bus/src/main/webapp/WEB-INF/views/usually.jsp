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
<title>시외버스 - 즐겨찾기</title>

<link rel="preconnect" href="https://fonts.googleapis.com" />
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
<link
	href="https://fonts.googleapis.com/css2?family=Dongle:wght@700&display=swap"
	rel="stylesheet" />

</head>
<body class="slide-in">
	<div id="all">
		<div id="middle">
			<div id="top-title">
				<header>
					<h1>
						<a href="${rootPath}/">시외버스</a>
					</h1>
					<h2>즐겨찾기</h2>
				</header>
			</div>
			<table>
				<tr>
					<th>출발지</th>
					<th>목적지</th>
					<th>선택</th>
				</tr>
				<c:forEach items="${USLIST}" var="US">
					<tr>
						<td>${US.s_terminal}</td>
						<td>${US.e_terminal}</td>
						<td>${US.us_buid}</td>
					</tr>
				</c:forEach>

			</table>
			<button>빠른 조회</button>
		</div>
	</div>
</body>
</html>
