<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="${rootPath}/resources/js/home.js?${version}"></script>

<title>MY CAR MANAGER</title>
</head>
<body>
	<div>MY CAR MANAGER</div>
	<form method="POST" action="insert">
		<div>
			<label>운행등록</label>
			<input placeholder="구분" name="c_divison" />
			<input placeholder="시작거리(Km)" name="c_depDist" />
			<input placeholder="장소" name="c_location" />
		</div>
		<div>
			<input placeholder="종료거리(Km)" name="arrDist" />
			<input placeholder="소모비용" name="c_cost" />
			<button>저장</button>
		</div>
	</form>
	<div>
		<table class="main list">
			<tr>
				<td>No.</td>
				<td>구분</td>
				<td>출발일자</td>
				<td>출발시간</td>
				<td>출발거리(Km)</td>
				<td>도착일자</td>
				<td>도착시간</td>
				<td>도착거리(Km)</td>
				<td>장소</td>
				<td>소모비용</td>
			</tr>

			<c:forEach items="${RECORDS}" var="RECORD">
				<tr data-id = "${RECORD.c_sequence}">
					<td>${RECORD.c_sequence}</td>
					<td>${RECORD.c_divison}</td>
					<td>${RECORD.c_depDate}</td>
					<td>${RECORD.c_depTime}</td>
					<td>${RECORD.c_depDist}</td>
					<td>${RECORD.c_arrDate}</td>
					<td>${RECORD.c_arrTime}</td>
					<td>${RECORD.c_arrDist}</td>
					<td>${RECORD.c_location}</td>
					<td>${RECORD.c_cost}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>