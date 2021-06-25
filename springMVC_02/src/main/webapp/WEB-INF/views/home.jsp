<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
	<link href="resources/css/test.css" type="text/css" rel="stylesheet">
	<link href="<c:url value='/css/test.css'/>" type="text/css" rel="stylesheet">
	<link href="/css/test.css" type="text/css" rel="stylesheet">
</head>
<body>
<h1 class="test">
	Hello world!  
</h1>
<c:set var="contextPath" value="<%= request.getContextPath() %>"/>
<P>  The time on the server is ${serverTime}. </P>
<img src="<%= request.getContextPath() %>/resources/img/10.jpg" width="150px" height="150px"><br>
<img src="<c:url value='/img/10.jpg'/>" width="150px" height="150px"><br>
<img src="${contextPath }/img/10.jpg" width="150px" height="150px"><br>
<img src="img/10.jpg" width="150px" height="150px">
</body>
</html>
