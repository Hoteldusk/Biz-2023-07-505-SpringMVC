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
	<h1>회원정보</h1>
	<div>
		<strong>회원코드 : </strong><span>${MEMBER.m_code}</span>
	</div>
	<div>
		<strong>회원명 : </strong><span>${MEMBER.m_name}</span>
	</div>
	<div>
		<strong>전화번호 : </strong><span>${MEMBER.m_tel}</span>
	</div>
	<div>
		<strong>주소 : </strong><span>${MEMBER.m_addr}</span>
	</div>
	<div><button type="button"><a href="${rootPath}/member/${MEMBER.m_code}/update">수정하기</a></button></div>
</body>
</html>