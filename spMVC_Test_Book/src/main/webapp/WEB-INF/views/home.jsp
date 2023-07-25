<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath}" var="rootPath"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<a href="${rootPath}/books">도서 조회 및 수정</a>
	</div>
	<div>
		<a href="${rootPath}/users">회원 조회 및 수정</a>
	</div>
	<div>
		<a href="${rootPath}/rentbooks">도서 대출 관리</a>
	</div>
</body>
</html>