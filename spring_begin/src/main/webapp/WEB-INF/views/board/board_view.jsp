<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false" %>
<html>
<head>
	<%@ include file="/WEB-INF/views/common/doc_header.jsp" %>
	<title>view</title>
	
</head>
<body>

<div class="container show-grid">
	<div class="row"> 
      	<div class="col-md-4">
      		<div class="form">
				<span> 제목 : </span><span><c:out value="${boardList[0].boardTitle}"/></span>	
				<br> 
				<span> 내용 : </span><span><c:out value="${boardList[0].boardContent}"/></span>	<!-- C턔끄로 빠로 싸용 -->
				<br>
				<span> 날짜 : </span><span><c:out value="${boardList[0].boardDate}"/></span>
				<br>
				<br>
				<button id="btn_edit" onclick="location.href='/board/edit?boardIndex=${boardList[0].boardIndex}'">수정</button>	<!-- 끄냥 빠로 싸용 -->
			</div>
		</div>
	</div>
</div>

</body>
</html>
