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
	<p>${BBS.b_seq}</p>
	<p>${BBS.b_date}</p>
	<p>${BBS.b_time}</p>
	<p>${BBS.b_username}</p>
	<p>${BBS.nickname}</p>
	<p>${BBS.b_subject}</p>
	<p>${BBS.b_content}</p>
	<p><img src="${rootPath}/files/${BBS.b_image}" width="200px" />
</body>
</html>