<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${rootPath}/static/css/detail.css?${version}">
</head>
<body>
	<div class="bbs-info">
		<div class="label">작성일자:</div>
		<div>${BBS.b_date}</div>

		<div class="label">작성시각:</div>
		<div>${BBS.b_time}</div>

		<div class="label">작성자:</div>
		<div>${BBS.nickname}</div>

		<div class="label">제목:</div>
		<div>${BBS.b_subject}</div>

		<div class="label">내용:</div>
		<div>${BBS.b_content}</div>
	</div>
</body>
</html>