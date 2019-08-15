<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>错误页面</title>
<!-- 通过include引入 base.jsp -->
<%@ include file="/WEB-INF/include/base.jsp" %>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">错误页面</span>
			<!-- 引入 用户导航栏 -->
			<%@ include file="/WEB-INF/include/user_head.jsp" %>
	</div>
	
	<div id="main">
		<h2 style="color:red;text-align: center;margin-top: 200px;">系统发生了不可描述的异常，请联系管理员处理！！！</h2>
	</div>
	
	<div id="bottom">
		<span>
			尚硅谷书城.Copyright &copy;2015
		</span>
	</div>
</body>
</html>