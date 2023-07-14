<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이미지 갤러리</title>
<link rel="stylesheet"
	href="${rootPath }/static/css/home.css?${version}">
</head>
<body>
	<div class="top">이미지 갤러리</div>
	<div class="middle">
		<table>
			<tr>
				<td>no.</td>
				<td>작성일자</td>
				<td>작성시각</td>
				<td>작성자ID</td>
				<td>제목</td>

				<td class="count">조회수</td>
			</tr>
			<c:forEach var="BBS" items="${BBS_LIST}" begin="0" end="10" step="1"
				varStatus="status">
				<tr>
					<td>${BBS.b_seq}</td>
					<td>${BBS.b_date}</td>
					<td>${BBS.b_time}</td>
					<td>
						<a href="${rootPath}/search/user?username=${BBS.b_username}"> 
							${BBS.nickname}
						</a>
					</td>
					<td>
						<a href="${rootPath}/search/detail?seq=${BBS.b_seq}">
							${BBS.b_subject}"
						</a>
					</td>

					<td class="count">${BBS.b_count}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div >
		<button class="writebutton">글쓰기</button>
	</div>
</body>
</html>