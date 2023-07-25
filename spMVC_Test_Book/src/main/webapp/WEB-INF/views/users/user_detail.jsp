<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath}" var="rootPath"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>detail</title>
</head>
<body>
	<form method="POST" class="main update" action="${rootPath}/users/update?id=${USER.u_code}">
		<fieldset>
			<legend>회원 상세 정보</legend>
			<div>
				<label>회원코드</label><input name="u_code" value="${USER.u_code}"
					readonly="readonly" />
			</div>
			<div class="message u_code">
				<label></label><span></span>
			</div>

			<div>
				<label>회원명</label><input name="u_name" value="${USER.u_name}" />
			</div>
			<div class="message u_name">
				<label></label><span></span>
			</div>

			<div>
				<label>전화번호</label><input name="u_tel" value="${USER.u_tel}" />
			</div>

			<div>
				<label>주소</label><input name="u_addr" value="${USER.u_addr}" />
			</div>
			
			<div>
				<label></label>
				<button class="detail update" data-id="${USER.u_code}">수정하기</button>
			</div>
		</fieldset>
	</form>
</body>
</html>