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
<%
	List<Music> list = (List<Music>)request.getAttribute("list");
%>
<body>
   <table width="60%" class="fl mr50">
   		<tr>
   			<td>歌曲ID</td>
   			<td>歌曲名称</td>
   			<td>歌曲图片</td>
   			<td>操作</td>
   		</tr>
   	<%
   		for(Music m: list){
   	%>
   		<tr>
   			<td><%=m.getMusic_id() %></td>
   			<td><%=m.getMusic_name() %></td>
   			<td><img width="100px" src=".<%=m.getMusic_img() %>" /></td>
   			<td>
   				<a href=".<%=m.getMusic_url() %>" target="showAll">播放</a>
   			</td>
   		</tr>
   	<%
   		}
   	%>
   	
   </table>
<div class="fl">
	<iframe name="showAll"></iframe>
</div>

</body>
</html>