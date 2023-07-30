<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보수정</title>
<link href="${rootPath}/resources/css/update.css?${version}"
	rel="stylesheet" />
</head>
<body>

	<div class="wrapper">
		<header>
			<h1>
				<a href="${rootPath}/">시외버스</a>
			</h1>
			<h2>회원정보수정</h2>
		</header>
		<form method="POST" class="updateuser">
			<div>
				<label>아이디</label> <input value="${MYUSER.bu_id}" name="bu_id"
					readonly></input>
			</div>
			<div>
				<label>패스워드</label> <input value="${MYUSER.bu_password}"
					name="bu_password"></input>
			</div>
			<div>
				<label>이름</label> <input value="${MYUSER.bu_name}" name="bu_name"></input>
			</div>
			<div>
				<label>전화번호</label> <input value="${MYUSER.bu_tel}" name="bu_tel"></input>
			</div>
			<div>
				<button type="submit" class="update-btn">정보수정</button>

			</div>

		</form>
	</div>
</body>
</html>