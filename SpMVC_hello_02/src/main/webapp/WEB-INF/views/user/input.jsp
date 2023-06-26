<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>추가하기</h1>
	<form method ="POST">
		<div>
			아이디 : <input type="text" name="username" placeholder="USERNAME">
		</div>
		<div>
			비밀번호 : <input type="password" name="password" placeholder="PASSWORD">
		</div>
		<div>
			비밀번호 확인 : <input type="password" name="re_password"
				placeholder="PASSWORD 확인">
		</div>
		<div>
			이름 : <input type="text" name="name" placeholder="이름">
		</div>
		<div>
			나이 : <input type="text" name="age" placeholder="나이">
		</div>
		<div>
			전화번호 : <input type="text" name="tel" placeholder="전화번호">
		</div>
		<div>
			주소 : <input type="text" name="addr" placeholder="주소">
		</div>
		<div>
			<button type="submit">추가하기</button>
		</div>
	</form>


</body>
</html>