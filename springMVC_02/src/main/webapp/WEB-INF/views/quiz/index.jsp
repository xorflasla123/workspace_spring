<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
<script type="text/javascript">
	function check(ch) {
		console.log(ch);
		if(ch==1){
			alert("로그인 실패");
		}else if(ch==0){
			alert(${dto.name}+"로그인 성공")
		}
	}
</script>
</head>
<body>
	dto : ${dto }

	<c:choose>
		<c:when test="${dto.check == 1 || dto == null}">
			<script>check(${dto.check})</script><br>
			<form action="check" method="post">
				<input type="text" placeholder="id" name="id"><br> 
				<input type="password" placeholder="password" name="pwd"><br>
				<input type="submit" value="로그인"><br>
			</form>
			<hr>
			<a href="saveView">회원 가입</a>&nbsp;&nbsp;
			<a href="list">게시글 보기</a>
		</c:when>
		<c:otherwise>
			<script>check(${dto.check})</script><br>
			<img src="<c:url value = '/img/10.jpg'/>" width="50px" height="50px">
			${dto.name } 님 환영합니다.
		</c:otherwise>
	</c:choose>


</body>
</html>