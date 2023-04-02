<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="checkLogin.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
    <h3>登录成功后的界面</h3>
    <h4>
    <%
    	if("jack".equals(loginName)){
    %>
    	<font color='red'><%=loginName %></font>
    <%	
    	}else{
    %>	
    	<font color='purple'><%=loginName %></font>
    <%
    	}
    %>	
    回来，使用本系统。</h4>
    <p><a href="loginOut.jsp">Login Out</a></p>
</body>
</html>