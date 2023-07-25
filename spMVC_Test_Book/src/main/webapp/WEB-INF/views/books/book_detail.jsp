<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>detail</title>
<script>
	var rootPath = "${rootPath}"
</script>

</head>
<body>
	<form method="POST" class="main update" action="${rootPath}/books/update?id=${BOOK.b_code}">
		<fieldset>
			<legend>도서 상세 정보</legend>
			<div>
				<label>도서코드</label><input name="b_code" value="${BOOK.b_code}"
					readonly="readonly" />
			</div>
			<div class="message b_code">
				<label></label><span></span>
			</div>

			<div>
				<label>도서명</label><input name="b_name" value="${BOOK.b_name}" />
			</div>
			<div class="message b_name">
				<label></label><span></span>
			</div>

			<div>
				<label>저자</label><input name="b_auther" value="${BOOK.b_auther}" />
			</div>

			<div>
				<label>출판사</label><input name="b_comp" value="${BOOK.b_comp}" />
			</div>

			<div>
				<label>구입연도</label><input name="b_year" value="${BOOK.b_year}" />
			</div>

			<div>
				<label>구입가격</label><input name="b_iprice" value="${BOOK.b_iprice}" />
			</div>

			<div>
				<label>대여가격</label><input name="b_rprice" value="${BOOK.b_rprice}" />
			</div>

			<div>
				<label></label>
				<button class="detail update" data-id="${BOOK.b_code}">수정하기</button>
			</div>
		</fieldset>
	</form>
</body>
</html>