<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>result</title>
</head>
<body>
	<c:forEach var="dto" items="${list }">
		ID : ${dto.id }<br>
		NAME : ${dto.name }<br>
		IMAGE : ${dto.imgName }<br>
		<img alt="no image" src="${contextPath }/download?file=${dto.imgName }" width="100px" height="100px"><br>
		<a href="${contextPath }/download?file=${dto.imgName }">${dto.imgName }</a><hr>
	</c:forEach>
	<a href="${contextPath }/form">Re-Upload</a>
</body>
</html>