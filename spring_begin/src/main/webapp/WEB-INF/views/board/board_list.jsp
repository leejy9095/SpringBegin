<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false" %>
<html>
<head>
	<%@ include file="/WEB-INF/views/common/doc_header.jsp" %>
	
	<style type="text/css">
    .div_post {
        
          height: 20px;
          padding: 5px 5px 5px 5px; /* 상, 우, 좌, 하 */
          text-align: left; /* left, center, right */
    }
	</style>	
	
	<title>list page</title>
</head>
<body>
	<div class="container show-grid">
		<div class="row">
	      <div class="col-md-4 div_post"></div>
	      <div class="col-md-4 div_post"></div>
	      <div class="col-md-4 div_post"></div>
	    </div>
	    <div class="row">
	      <div class="col-md-4 div_post"></div>
	      <div class="col-md-4 div_post"></div>
	      <div class="col-md-4 div_post"></div>
	    </div>
	    <div class="row">
	      <div class="col-md-4 div_post"></div>
	      <div class="col-md-4 div_post"></div>
	      <div class="col-md-4 div_post"></div>
	    </div>
	</div>
	
	
	<c:forEach items="${boardList}" var="v">
        <c:out value="${v.boardIndex}"/><br>
        <c:out value="${v.boardTitle}"/><br>
        <c:out value="${v.boardContent}"/><br>
        <c:out value="${v.boardDate}"/><br>
    </c:forEach>
	
	
	
	<!-- button section -->
	<div class="">
		<a href="/board/write" class="">글쓰기</a>
	</div>

</body>
</html>
