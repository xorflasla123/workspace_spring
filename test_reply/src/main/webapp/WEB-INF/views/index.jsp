<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>reply, re-reply test</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	//대댓글 적는 방식 네이버 블로그처럼 수정 예정, 댓글 수정 기능 추가 예정

	let data; //삭제를 돕기 위해 데이터 저장
	let re_id;
	
	//댓글 test용이기 때문에 table에 게시판id, userId가 없음.
	function rep(){ //댓글 저장
		let form={}; let arr=$("#frm").serializeArray();
		for(i=0; i<arr.length; i++){
			form[arr[i].name] = arr[i].value
		}
		console.log(form); //null값 체크
		$.ajax({
			url: "addReply", type: "POST", //com.reply.root.controller.ReplyController.java에 있는 addReply
			data: JSON.stringify(form),
			contentType: "application/json; charset=utf-8",
			success: function(list){
				alert("성공적으로 댓글이 달렸습니다");
				$('textarea').val(''); //textarea 비우기
				replyData(); //화면에 보여주는 function
			}, error: function(){
				alert("내용을 적어주세요!!!");
			}
		})
	}
	
	function rerep(i){ //대댓글 저장
		let form={}; let arr=$("#re"+i).serializeArray();
		for(i=0; i<arr.length; i++){
			form[arr[i].name] = arr[i].value
		}
		//console.log(form);
		$.ajax({
			url: "addReply2", type: "POST", //com.reply.root.controller.ReplyController.java에 있는 addReply2
			data: JSON.stringify(form),
			contentType: "application/json; charset=utf-8",
			success: function(list){
				alert("성공적으로 대댓글이 달렸습니다");
				$('textarea').val('');
				invisible();
				replyData();
			}, error: function(){
				alert("내용을 적어주세요!!!");
			}
		})
	}
	
	function remove(i){ //댓글 삭제(댓글 삭제 시 딸려있는 대댓글도 삭제되게 service쪽을 해놓음)
		$.ajax({
			url: "removeReply", type: "POST", 
			data: JSON.stringify(data[i]),
			contentType: "application/json; charset=utf-8",
			success: function(){
				alert("댓글이 삭제되었습니다.");
				replyData();
			}, error: function(){
				alert("문제 발생!!!");
			}
		})
	}
	
	function replyData(){ //댓글 보여주는 부분
		$.ajax({
			url : "replyData", type : "GET",
			dataType : "json",
			success : function(rep){
				let html = '';
				data = rep;
				console.log('reply list : ');
				console.log(data);
				if(rep.length==0){
					html += "<h3>댓글이 없습니다.</h3>"
				} else{
					/* html += `<tr> //멋져!
								<td>내용</td> <td>작성일자</td> <td></td>
							</tr>` */
					for(i=0;i<rep.length;i++){
						let date = new Date(rep[i].date);
						let hours = date.getHours();
						let minutes = date.getMinutes();
						let seconds = date.getSeconds();
						hours = hours > 9 ? hours : "0" + hours;
						minutes = minutes > 9 ? minutes : "0" + minutes;
						seconds = seconds > 9 ? seconds : "0" + seconds;
						let writeDate = date.getFullYear()+"."+(date.getMonth()+1)+"."
						writeDate += date.getDate()+" "+hours+":"
						writeDate += minutes+":"+seconds
					
						if(rep[i].layer==0){ //부모 댓글은 [댓글]버튼 추가
							html += "<div class= 'reply'>"
							html +=		rep[i].content+"<br>"
							html +=		"<font class= 'time'>"+writeDate+"</font><br>"
							html +=		"<input type='button' id='"+i+"' value='삭제' onclick='remove(this.id)'>"
							html +=		"<input type='button' id='"+rep[i].id+"' value='댓글' onclick='visible("+i+")'>"
							html +=		"<hr>"
							html += "</div>"
							
							html += "<div id='hidden"+i+"' class= 'reply' style='display:none'>"
							html +=		"<form id='re"+i+"' name='reform'>"
							html +=			"<input type='hidden' name='group_id' value='"+rep[i].id+"'>"
							html +=			"<textarea class= 'writeBox' id='content' name='content'></textarea>"
							html +=			"<button type='button' onclick='rerep("+i+")'>대댓글 달기</button>"
							html +=			"<button type='button' onclick='invisible("+i+")'>취소</button>"
							html +=		"</form>"
							html += 	"<hr>"
							html += "</div>"
						}
						if(rep[i].layer==1){
							html += "<div class= 'reply' style= 'background-color: #D5D5D5'>"
							html +=		"└>"+rep[i].content+"<br>"
							html +=		"<font class= 'time'>"+writeDate+"</font><br>"
							html +=		"<input type='button' id='"+i+"' value='삭제' onclick='remove(this.id)'>"
							html +=		"<hr>"
							html += "</div>"
						}
					}
				}
				$("#show1").html(html)
			}, error : function(){
				alert('데이터를 가져올 수 없습니다')
			}
		})
	}
	
	function visible(i){
		$("#hidden"+i).show();
	}
	
	function invisible(i){
		$("#hidden"+i).hide();
	}
	
	window.onload = function (){ //브라우저 시작과 동시에 댓글 보여주기
		replyData();
	}
</script>

<style type="text/css">
	#hidden{
		display: none;
		align-content: center;
	}
	.time{
		font-size: 13px;
	}
	.replyBG{
		margin: auto;
		width: 600px;
		background-color: #EAEAEA;
	}
	.reply{
		width: 580px;
		padding: 10px 10px 0px 10px;
		word-break: break-all;
	}
	.writeBox{
		width: 570px;
		height: 60px;
		resize: none;
	}
</style>
</head>

<body>
	<div style="margin: auto; width: 600px;">
		<div style="padding: 10px 10px 10px 10px;">
			<form id="frm">
				<textarea class="writeBox" id="content" name="content"></textarea>
				<div align="right">
					<button type="button" onclick="rep()">댓글 달기</button>
				</div>
			</form>
		</div>	
	</div>
	
	<div id="show1" class="replyBG"></div>
	
	<table border="1" id="show" style="margin: auto;"></table> <!-- 댓글 보여주는 부분 -->
</body>
</html>








