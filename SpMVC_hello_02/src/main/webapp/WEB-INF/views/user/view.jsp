<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>USERNAME : ${USER.username}</p>
	<p>PASSWORD : ${USER.password}</p>
	<p>NAME : ${USER.name}</p>
	<p>AGE : ${USER.age}</p>
	<p>TEL : ${USER.tel}</p>
	<p>ADDRESS : ${USER.addr}</p>
</body>
</html>