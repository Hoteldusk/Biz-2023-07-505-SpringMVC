<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 정보 관리</h1>
	<table>
		<tr>
			<th>회원코드</th>
			<th>회원명</th>
			<th>전화번호</th>
			<th>주소</th>
		</tr>
		<tr>
			<td></td>
		</tr>
	</table>
	<div class="member button">
		<a href="/rent/home">처음으로</a>
		<a href="/rent/insert">회원정보</a>
	</div>
</body>
</html>