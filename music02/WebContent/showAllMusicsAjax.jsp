<%@page import="com.music.entity.Music"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
	.fl{
		float:left;
	}
	.mr50{
		margin-right:50px;
	}
</style>
<body onload="getAllMusics()">
	<table id="info" width="60%" class="fl mr50" border="1px">
		<tr>
			<td>歌曲ID</td>
			<td>歌曲名称</td>
			<td>歌曲图片</td>
			<td>操作</td>
		</tr>
	</table>
<div class="fl">
	<iframe name="showAll"></iframe>
</div>
<script type="text/javascript">
var xhttp;
if(window.XMLHttpRequest){
	xhttp = new XMLHttpRequest();
}else{
	xhttp = new ActiveXObject("Microsoft.XMLHTTP");
}
function getAllMusics(){
	xhttp.onreadystatechange = function(){
		if(this.readyState == 4 && this.status == 200){
			let jsonArr = JSON.parse(this.responseText);
			let t = document.getElementById("info");
			
			let row;
			for(let m of jsonArr){
				row = t.insertRow();
				row.insertCell().innerHTML = m.music_id;
				row.insertCell().innerHTML = m.music_name;
				row.insertCell().innerHTML = "<img width='100px' src='."+m.music_img+"'/>"
				row.insertCell().innerHTML = "<a href='."+m.music_url+"' target='showAll'>ajax播放</a>";
			}
		}
	};
	xhttp.open("GET","MusicServletAjax",true);
	xhttp.send();
}
</script>
</body>
</html>