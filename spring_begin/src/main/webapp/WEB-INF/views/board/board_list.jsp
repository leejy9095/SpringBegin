<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false" %>
<html>
<head>
	<%@ include file="/WEB-INF/views/common/doc_header.jsp" %>
	
	<style type="text/css">
    .div_post {
          padding: 5px 5px 5px 5px; /* 상, 우, 좌, 하 */
          text-align: left; /* left, center, right */
    }
	</style>	
	
	<title>list page</title>
</head>
<body>

<%
	Object x = request.getAttribute("boardList");	/* 이런식으로 받아올수도있는거 예시 */
%>


	<div class="container show-grid">
		<div class="row"> 
	    
	    <c:forEach items="${boardList}" var="v" varStatus="vStat">
	      	<div class="col-md-4 div_post">
	      		<div class="view_form">
	      			<a href="/board/view?boardIndex=<c:out value='${v.boardIndex}'/>"/><c:out value='${v.boardIndex}'/></a><br>
			        <c:out value="${v.boardTitle}"/><br>
			        <c:out value="${v.boardContent}"/><br>
			        <c:out value="${v.boardDate}"/><br>
		      	</div>
		    </div>
	<c:if test="${vStat.index%3==2}">
		</div>
		<div class="row"> 
	</c:if>
		</c:forEach>
	</div>
	
	<!-- paging section -->
	<div class="page_div" style='text-align:center'>
		<nav aria-label="Page navigation example">
			<ul class="pagination">
		    	<li class="page-item"><a class="page-link" href="#"><<</a></li>
			    <li class="page-item"><a class="page-link" href="#">1</a></li>
			    <li class="page-item"><a class="page-link" href="#">2</a></li>
			    <li class="page-item"><a class="page-link" href="#">3</a></li>
			    <li class="page-item"><a class="page-link" href="#">4</a></li>
			    <li class="page-item"><a class="page-link" href="#">4</a></li>
			    <li class="page-item"><a class="page-link" href="#">3</a></li>
			    <li class="page-item"><a class="page-link" href="#">>></a></li> 
			</ul>
		</nav>
	</div>
	
	<!-- button section -->
	<div class="btn_div">
		<a href="/board/write" class="">글쓰기</a>
	</div>

</body>
</html>
