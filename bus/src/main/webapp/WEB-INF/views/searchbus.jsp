<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
      href="https://fonts.googleapis.com/css2?family=Dongle:wght@700&display=swap"
      rel="stylesheet"
    />
    <link rel="stylesheet" href="${rootPath}/resources/css/searchbus.css" />
    <script src="${rootPath}/resources/js/searchbus.js"></script>
    <script>
      var rootPath = "${rootPath}";
      var scode = "${USNOSUN.us_stcode}";
      var ecode = "${USNOSUN.us_etcode}";
    </script>
    <title>노선 조회</title>
  </head>
  <body class="slide-in">
    <section id="view">
      <section class="topview">
        <div class="toptitle">
          <a href="${rootPath}/">시외버스</a>
        </div>
        <div class="topbody">
          <form action="#">
            <select name="str_bus" id="select1">
              <option value="str_default" selected>
                출발지를 선택해주세요
              </option>
              <c:forEach items="${DEPTERS}" var="DEPTER">
                <option value="${DEPTER.tl_depTerId}">
                  ${DEPTER.depTerName}
                </option>
              </c:forEach>
            </select>
          </form>

          <c:if test="${not empty sessionScope.USER}">
            <div id="bookmark">즐겨 찾기 등록</div>
          </c:if>
          <c:if test="${empty sessionScope.USER}">
            <div>노선 조회</div>
          </c:if>
          <form action="#">
            <select name="end_bus" id="select2">
              <option value="end_default">도착지를 선택해주세요</option>
              <option value="end0001">전라북도 순창</option>
              <option value="end0002">서울</option>
              <option value="end0003">하와이</option>
              <option value="end0004">도쿄</option>
              <option value="end0005">시공의폭풍</option>
              <option value="end0006">우리집</option>
              <option value="end0007">아무데나</option>
            </select>
          </form>
        </div>
        <div class="toptail">
          <div class="image-container" id="image_container">
            <img
              src="${rootPath}/resources/img/busStop.png"
              class="stop-image-str"
              id="stop-image-str"
              alt="Stop Image"
            />
            <img
              src="${rootPath}/resources/img/busimg.png"
              class="moving-image"
              id="moving-image"
              alt="Moving Image"
            />
            <img
              src="${rootPath}/resources/img/busStop.png"
              class="stop-image-end"
              id="stop-image-end"
              alt="Stop Image"
            />
          </div>
        </div>
      </section>

      <section class="middleview" id="mainview">
        <section class="top">
          <section class="title">
            <span class="title_left" id="title_left">광주광역시 문화동</span>
            <span class="title_middle">→</span>
            <span class="title_right" id="title_right">전라북도 순창</span>
          </section>
        </section>
        <section class="center">
          <table id="list">
            <thead class="list_index" id="list_top">
              <tr>
                <th>출발 시간</th>
                <th>도착 시간</th>
                <th>요 금</th>
                <th>도착 예정</th>
              </tr>
            </thead>
            <tbody class="list_body" id="list_body"></tbody>
          </table>
        </section>
      </section>
    </section>
  </body>
</html>
