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
<script src="${rootPath}/static/js/books.js${version}"></script>
</head>
<body>
	<div>도서 조회 및 수정</div>
	<div>
		<form method="POST">
			<div class="input">
				<input name="b_code" placeholder="도서코드(중복불가)" value="${BOOK.b_code}" />
			</div>
			<div class="input">
				<input name="b_name" placeholder="도서명(중복불가)" value="${BOOK.b_name}" />
			</div>
			<div class="input">
				<input name="b_auther" placeholder="저자" value="${BOOK.b_auther}" />
			</div>
			<div class="input">
				<input name="b_comp" placeholder="출판사" value="${BOOK.b_comp}" />
			</div>
			<div class="input">
				<input name="b_year" placeholder="구입연도" value="${BOOK.b_year}" />
			</div>
			<div class="input">
				<input name="b_iprice" placeholder="구입가격" value="${BOOK.b_iprice}" />
			</div>
			<div class="input">
				<input name="b_rprice" placeholder="대여가격" value="${BOOK.b_rprice}" />
			</div>
			<button>저장</button>
		</form>
	</div>
	<table class="main list">
			<tr>
				<th>도서코드</th>
				<th>도서명</th>
				<th>저자</th>
				<th>출판사</th>
				<th>구입연도</th>
				<th>구입가격</th>
				<th>대여가격</th>
			</tr>
		<c:if test="${empty BOOKLIST}">
			<tr>
				<td>데이터가 없습니다</td>
			</tr>
		</c:if>
		<c:forEach items="${BOOKLIST}" var="BOOK">
			<tr data-id ="${BOOK.b_code}">
				<td>${BOOK.b_code}</td>
				<td>${BOOK.b_name}</td>
				<td>${BOOK.b_auther}</td>
				<td>${BOOK.b_comp}</td>
				<td>${BOOK.b_year}</td>
				<td>${BOOK.b_iprice}</td>
				<td>${BOOK.b_rprice}</td>
			</tr>
		</c:forEach>
	</table>
	<div>
		<a href="${rootPath}/">홈으로</a>
	</div>
</body>
</html>