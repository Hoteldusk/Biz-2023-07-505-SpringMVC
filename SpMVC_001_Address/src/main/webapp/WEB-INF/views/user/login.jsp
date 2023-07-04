<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<form method="POST" class="user login">
	<fieldset>
		<legend>로그인</legend>
		<c:if test="${ERROR == 'F_USERNAME'}">
			<div class="error">
				USER NAME이 없습니다
			</div>
		</c:if>
		<c:if test="${ERROR == 'F_PASSWORD'}">
			<div class="error">
				비밀번호를 확인하세요
			</div>
		</c:if>

		<input placeholder="USER NAME" name="username" /> <input
			type="password" placeholder="PASSWORD" name="password" />
		<button>로그인</button>
	</fieldset>
</form>