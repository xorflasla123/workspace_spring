<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
</head>
<body>
	<!-- server.xml 에서 설정한 기본 주소값을 보여줌 -->
	
	<h1>get 방식 전송</h1>
	<form action="<%= request.getContextPath() %>/result" method="get"> <!-- 절대경로 -->
	<!-- <form action="/root/my/result" method="get"> -->
		<input type="text" name="name"><br>
		<input type="text" name="age"><br>
		<input type="submit" value="전송">
	</form>
	
	<h1>post 방식 전송</h1>
	<form action="result" method="post"> <!-- 상대경로 -->
		<input type="text" name="name"><br>
		<input type="text" name="age"><br>
		<input type="submit" value="전송">
	</form>
	
	<h1>dto로 처리하기</h1>
	<form action="obj_result" method="post">
		<input type="text" name="name"><br>
		<input type="text" name="age"><br>
		<input type="submit" value="전송">
	</form>
</body>
</html>