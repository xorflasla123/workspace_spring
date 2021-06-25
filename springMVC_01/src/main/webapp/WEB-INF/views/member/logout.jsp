<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>logout</title>
</head>
<body>
	logout.jsp<br>
	userId : ${requestScope.userId }<br>
	userId : <%= request.getAttribute("userId") %><br>
	userId : ${userId }<br>
	<a href="login">로그인 페이지</a>&nbsp;<a href="index">인덱스 페이지</a>
</body>
</html>