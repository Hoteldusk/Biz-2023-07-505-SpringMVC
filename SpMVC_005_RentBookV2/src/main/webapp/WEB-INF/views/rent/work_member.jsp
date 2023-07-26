<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${rootPath}/static/css/input.css" rel="stylesheet" />
<script type="text/javascript">
	var rootPath = "${rootPath}"
</script>
<script type="text/javascript" src="${rootPath}/static/js/main.js"></script>
<script type="text/javascript" src="${rootPath}/static/js/member.js"></script>
</head>
<body>
	<h1>회원검색</h1>
	<div>
		<p>도서코드 : ${RENT_WORK.rent_bcode}, 도서명 : ${RENT_WORK.b_name},
			도서출판사 : ${RENT_WORK.b_comp}</p>
	</div>
	<f:form action="${rootPath}/rent/go/complete" modelAttribute="RENT_WORK">
	<%
	/*
	첫 화면에서 입력된 도서 정보를 이 화면에서
	입력하는 회원정보와 함께 묶어서 다음 화면으로
	전달하기 위해서는 감춰진 또는 다른 위치에 있는
	input tag를 생성하고 그 input tag에 데이터를 담아 놓아야 한다.
	 	<div>
			<input hidden="hidden" name="rent_bcode" value="${RENT_WORK.rent_bcode}"> 
			<input hidden="hidden" name="b_name" value="${RENT_WORK.b_name}">
			<input hidden="hidden" name="b_comp" value="${RENT_WORK.b_comp}">
		</div>
	하지만 Spring 에서는 SessionAttributes(), ModelAttribute()
	그리고 Spring form tag를 사용하므로써 데이터를 일일이 챙기는
	코드를 생략할 수 있다.
	 */
	%>
		<div>
			<label>회원명</label>
			<div class="search container">
			<f:input path="m_name" />
			<div class="search list"></div>
			</div>
		</div>
		<div>
			<label>회원코드</label>
			<f:input path="rent_mcode" />
		</div>
		<div>
			<label>전화번호</label>
			<f:input path="m_tel" />
		</div>
		<div>
			<button>다음 >></button>
		</div>
	</f:form>
</body>
</html>