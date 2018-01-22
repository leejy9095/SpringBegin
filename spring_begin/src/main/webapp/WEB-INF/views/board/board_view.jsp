<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false" %>
<html>
<head>
	<%@ include file="/WEB-INF/views/common/doc_header.jsp" %>
	<title>view</title>
	
</head>
<body>

<% 
	Object boardListObject = request.getAttribute("boardList");	/* 이런식으로 받아올수도있는거 예시 */
	System.out.println(boardListObject);

%>

<div class="container show-grid">
	<div class="row"> 
      	<div class="col-md-4">
      		<div class="form">
				<span> 제목 : </span><span>${boardListObject}</span>
				<br> 
				<span> 내용 : </span><span><c:out value="${boardList[Board]}"/><br></span>
				<br>
				<span> 날짜 : </span><span><c:out value="${Board.boardDate}"/><br></span>
				<br>
				<br>
				<input id="btn_save" type="submit" value="저장" />
			</div>
		</div>
	</div>
</div>

</body>
</html>
