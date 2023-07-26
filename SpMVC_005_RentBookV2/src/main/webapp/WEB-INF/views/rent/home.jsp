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
	<h1>도서 대여 처리</h1>

	<table>
		<tr>
			<th>도서코드</th>
			<th>도서명</th>
			<th>출판사</th>


			<th>회원코드</th>
			<th>회원명</th>
			<th>전화번호</th>
			
			<th>대출일</th>
			<th>반납예정일</th>
			<th>도서반납여부</th>
			<th>대여금액</th>
			<th>포인트</th>
		</tr>
		<c:forEach items="${RENTLIST}" var="rent">
			<tr>
				<td>${rent.rent_bcode}</td>
				<td>${rent.b_name}</td>
				<td>${rent.b_comp}</td>

				<td>${rent.rent_mcode}</td>
				<td>${rent.m_name}</td>
				<td>${rent.m_tel}</td>

				<td>${rent.rent_date}</td>
				<td>${rent.rent_return_date}</td>
				<td>${rent.rent_return_yn == 'Y' ? '반납' : '미반납'}</td>
				<td>${rent.rent_price}</td>
				<td>${rent.rent_point}</td>
			</tr>
		</c:forEach>
	</table>
	<div>
		<button>
			<a href="${rootPath}/">반납</a>
		</button>
		<button>
			<a href="${rootPath}/rent/insert">도서대여</a>
		</button>
	</div>
</body>
</html>