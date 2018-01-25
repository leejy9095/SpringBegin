<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false" %>
<html>
<head>
	<%@ include file="/WEB-INF/views/common/doc_header.jsp" %>
	<title>edit</title>
</head>
<body>

<div class="container show-grid">
	<div class="row"> 
      	<div class="col-md-4">
      		<div class="view_form">
				<form type="submit" action="/board/update">
					<span> 제목 : </span><input id="input_title" name="input_title" size="30" type="text" value="<c:out value="${boardList[0].boardTitle}"/>" />
					<br> 
					<span> 내용 : </span><input id="input_content" name="input_content" style="height:100px;" size="30" type="text" value="<c:out value="${boardList[0].boardContent}"/>" />
					<br>
					<br>
					<input id="btn_update" type="submit" value="저장" />
				</form>
			</div>
		</div>
	</div>
</div>

</body>
</html>
