<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<c:set value="20230707-001" var="version" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${rootPath}/resources/css/userList.css?${version}"
	rel="stylesheet" />
<script src="${rootPath}/resources/js/userPrint.js?${version}"></script>
</head>
<body>
	<header>
		<h1 class="home">시외버스</h1>
	</header>
	<div class="table-box">
		<table>
			<tr>
				<th>아이디</th>
				<th>패스워드</th>
				<th>이름</th>
				<th>전화번호</th>
			</tr>
			<c:forEach items="${USERS}" var="USER">
				<tr>
					<td>${USER.bu_id}</td>
					<td>${USER.bu_password}</td>
					<td>${USER.bu_name}</td>
					<td>${USER.bu_tel}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>