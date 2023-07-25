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
	<h1>대여 목록 추가</h1>

	<form>
	<div>
		<label>칼럼1</label>
		<input path="" />
	</div>
	<div>
		<label>칼럼2</label>
		<input path="" />
	</div>
	<div>
		<label>칼럼3</label>
		<input path="" />
	</div>
	<div>
		<button type="button">
			<a href="${rootPath}/rent">리스트로</a>
		</button>
		<button type="submit">저장하기</button>
		<button type="reset">새로작성</button>
	</div>
	</form>
</body>
</html>