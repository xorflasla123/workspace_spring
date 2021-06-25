<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>non_ajax</title>
<script type="text/javascript">
	function test(){ //동기 형식(동작을 할 때 서버에 통신을 해서 페이지가 새로 띄워진다.)
		location.href='non_ajax';
	}
</script>
</head>
<body>
	<h1>1</h1> <h1>2</h1> <h1>3</h1>
	<h1>4</h1> <h1>5</h1> <h1>6</h1>
	<h1>7</h1> <h1>8</h1> <h1>9</h1>
	<hr>
	<button type="button" onclick="test()">클릭</button>
</body>
</html>