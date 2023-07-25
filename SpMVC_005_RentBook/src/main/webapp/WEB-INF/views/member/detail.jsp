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
	<div><label>코드</label>${MEMBER.m_code}</div>
	<div><label>이름</label>${MEMBER.m_name}</div>
	<div><label>전화번호</label>${MEMBER.m_tel}</div>
	<div><label>주소</label>${MEMBER.m_addr}</div>
	<a href="${rootPath}/member/">리스트로</a>
	<a href="${rootPath}/member/${MEMBER.m_code}/update"> 수정하기 </a>
</body>
</html>