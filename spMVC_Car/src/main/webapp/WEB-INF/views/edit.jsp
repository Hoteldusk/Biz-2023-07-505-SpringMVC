<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도착 거리입력</title>
</head>
<body>
	<form method="POST" action="insert">
		<div>
			<label>운행등록</label><input placeholder="구분" name="c_divison" /><input
				placeholder="시작거리(Km)" name="c_depDist" /><input placeholder="장소"
				name="c_location" />
		</div>
		<div>
			<input placeholder="종료거리(Km)" name="arrDist" /><input
				placeholder="소모비용" name="c_cost" />
			<button>저장</button>
		</div>
	</form>
</body>
</html>