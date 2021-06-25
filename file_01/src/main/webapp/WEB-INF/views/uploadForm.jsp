<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>uploadForm</title>
</head>
<body>
	<h1>File Upload</h1>
	<form action="upload" enctype="multipart/form-data" method="post">
		<input type="text" name="id" placeholder="input id"><br>
		<input type="text" name="name" placeholder="input name"><br>
		<input type="file" name="file"><br>
		<input type="submit" value="Upload">
	</form>
	<hr>
	<a href="${contextPath }/views">파일보기</a>
</body>
</html>