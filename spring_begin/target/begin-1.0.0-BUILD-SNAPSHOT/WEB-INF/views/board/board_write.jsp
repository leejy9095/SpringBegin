<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false" %>
<html>
<head>
	<%@ include file="/WEB-INF/views/common/doc_header.jsp" %>
	<title>write page</title>
</head>
<body>

	<form type="submit" >
		<span> 제목 : </span><input id="input_title" size="30" type="text" value="" />
		<br>
		<span> 내용 : </span><input id="input_content" style="height:100px;" size="30" type="text" value="" />
	</form>

</body>
</html>
