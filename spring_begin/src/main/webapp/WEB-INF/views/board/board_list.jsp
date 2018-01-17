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

<%
	Object x = request.getAttribute("boardList");	/* 이런식으로 받아올수도있는거 예시 */
	String test = "Hello Java";
	int indexList = 0;
	request.setAttribute("test", test);
%>


	<div class="container show-grid">
		<div class="row"> 
	    	<div class="col-md-4 div_post">
	      		<div class="write_form">
	      			<form type="submit" action="/board/save">
						<span> 제목 : </span><input id="input_title" name="input_title" size="30" type="text" value="" />
						<br> 
						<span> 내용 : </span><input id="input_content" name="input_content" style="height:100px;" size="30" type="text" value="" />
					
						<input id="btn_save" type="submit" value="저장" />
					</form>
	      		</div>
	     	</div>
	    <c:forEach items="${boardList}" var="v" varStatus="vStat">
		
	      	<div class="col-md-4 div_post">
	      		<div class="view_form">
	      			<c:out value="${v.boardIndex}"/><br>
			        <c:out value="${v.boardTitle}"/><br>
			        <c:out value="${v.boardContent}"/><br>
			        <c:out value="${v.boardDate}"/><br>
		      	</div>
		    </div>
		    
		<c:if test="${vStat.index=='2' || vStat.index=='${pageScope.str}'}">	<!-- 3으로 나눈나머지가 1일때 -->
		</div>
		<div class="row">
		</c:if>
		
		</c:forEach>
	</div>
	
	<!-- button section -->
	<div class="">
		<a href="/board/write" class="">글쓰기</a>
	</div>

</body>
</html>
