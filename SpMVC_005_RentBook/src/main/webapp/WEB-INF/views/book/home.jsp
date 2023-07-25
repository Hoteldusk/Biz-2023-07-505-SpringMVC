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
	<h1>도서 정보 관리</h1>
	<table class="book">
		<tr>
			<th>도서코드</th>
			<th>도서명</th>
			<th>저자</th>
			<th>출판사</th>
			<th>대여가격</th>
		</tr>
		<c:choose>
			<c:when test="${not empty BOOKS}">
				<c:forEach items="${BOOKS}" var="book">
					<tr>
						<td>${book.b_code}</td>
						<td><a href="${rootPath}/book/${book.b_code}/detail">${book.b_name}</a></td>
						<td>${book.b_auther}</td>
						<td>${book.b_comp}</td>
						<td>${book.b_rprice}</td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="5">도서정보 없음</td>
				</tr>
			</c:otherwise>
		</c:choose>
	</table>
	<div class="book button">
		<a href="${rootPath}/">처음으로</a>
		<a href="${rootPath}/book/input">도서정보 추가</a>
	</div>
</body>
</html>