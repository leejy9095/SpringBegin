<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false" %>
<html>
<head>
	<%@ include file="/WEB-INF/views/common/doc_header.jsp" %>
	<title>list page</title>
</head>
<body>
	<div class="container show-grid">
		<div class="row">
	      <div class="col-md-4 "></div>
	      <div class="col-md-4 well"></div>
	      <div class="col-md-4 well"></div>
	    </div>
	    <div class="row">
	      <div class="col-md-4 well"></div>
	      <div class="col-md-4 well"></div>
	      <div class="col-md-4 well"></div>
	    </div>
	    <div class="row">
	      <div class="col-md-4 well"></div>
	      <div class="col-md-4 well"></div>
	      <div class="col-md-4 well"></div>
	    </div>
	</div>
	
	<!-- button section -->
	<div class="">
		<a href="/board/write" class="">글쓰기</a>
	</div>

</body>
</html>
