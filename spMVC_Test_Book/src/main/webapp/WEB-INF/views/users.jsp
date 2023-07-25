<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	var rootPath = "${rootPath}"
</script>
<script src="${rootPath}/static/js/users.js${version}"></script>
</head>
<body>
	<div>회원 조회 및 수정</div>
	<div>
		<form method="POST">
			<div class="input">
				<input name="u_code" placeholder="회원코드(중복불가)" value="${USER.u_code}" />
			</div>
			<div class="input">
				<input name="u_name" placeholder="회원명" value="${USER.u_name}" />
			</div>
			<div class="input">
				<input name="u_tel" placeholder="전화번호" value="${USER.u_tel}" />
			</div>
			<div class="input">
				<input name="u_addr" placeholder="회원주소" value="${USER.u_addr}" />
			</div>
			<button>저장</button>
		</form>
	</div>
	<table class="main list">
		<tr>
			<th>회원코드</th>
			<th>회원명</th>
			<th>전화번호</th>
			<th>회원주소</th>
		</tr>
		<c:if test="${empty USERLIST}">
			<tr>
				<td>데이터가 없습니다</td>
			</tr>
		</c:if>
		<c:forEach items="${USERLIST}" var="USER">
			<tr data-id ="${USER.u_code}">
				<td>${USER.u_code}</td>
				<td>${USER.u_name}</td>
				<td>${USER.u_tel}</td>
				<td>${USER.u_addr}</td>
			</tr>
		</c:forEach>
	</table>
	<div>
		<a href="${rootPath}/">홈으로</a>
	</div>
</body>
</html>