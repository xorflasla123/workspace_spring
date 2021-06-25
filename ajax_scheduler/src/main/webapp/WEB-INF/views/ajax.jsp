<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajax</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	function test(){
		$.ajax({ //비동기 방식(동작하는 부분만 서버와 통신하기 때문에 페이지 새로고침이 되지 않는다.)
			url:"ajax_result",//"ajax",
			type:"GET",
			success: function(cnt){
				console.log('connection success')
				$("#count").text(cnt)
			},
			error: function(){
				alert('connection failed')
			}
		})
	}
</script>
</head>
<body>
	<h1>1</h1> <h1>2</h1> <h1>3</h1>
	<h1>4</h1> <h1>5</h1> <h1>6</h1>
	<h1>7</h1> <h1>8</h1> <h1>9</h1>
	<hr>
	<button type="button" onclick="test()">클릭</button>
	<label id="count">0</label>
</body>
</html>