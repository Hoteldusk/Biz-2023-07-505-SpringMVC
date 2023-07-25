<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath}" var="rootPath"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 수정</title>
</head>
<body>
	<h1>회원정보 수정</h1>
	<form method = "POST">
		<div>
			<label>코드</label><input type="text" name="m_code" readonly="readonly" value="${MEMBER.m_code}"/>
		</div>
		
		<div>
			<label>이름</label><input type="text" name="m_name" value="${MEMBER.m_name}"/>
		</div>
		
		<div>
			<label>전번</label><input type="text" name="m_tel" value="${MEMBER.m_tel}"/>
		</div>
		
		<div>	
			<label>주소</label><input type="text" name="m_addr" value="${MEMBER.m_addr}"/>
		</div>
		
		<div>
			<a href = "${rootPath}/member/">리스트로</a>
			<button>수정하기</button>
		</div>
	</form>
	
</body>
</html>