<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="/WEB-INF/include/base.jsp" %>
<title>尚硅谷会员登录页面</title>
</head>
<body>
	<div id="login_header">
		<img class="logo_img" alt="" src="static/img/logo.gif">
	</div>

	<div class="login_banner">

		<div id="l_content">
			<span class="login_word">欢迎登录</span>
		</div>

		<div id="content">
			<div class="login_form">
				<div class="login_box">
					<div class="tit">
						<h1>尚硅谷会员</h1>
						<a href="pages/user/regist.jsp">立即注册</a>
					</div>
					<div class="msg_cont">
						<b></b>
						<span class="errorMsg">${empty requestScope.errMsg? '请输入用户名和密码':requestScope.errMsg}</span>
					</div>
					<div class="form">
						<form action="UserServlet" method="post">
							<input type="hidden" name="method" value="UserLogin">
							<label>用户名称：</label> <input class="itxt" type="text"
								placeholder="请输入用户名" autocomplete="off" tabindex="1"
								name="username" /> <br /> <br /> <label>用户密码：</label> <input
								class="itxt" type="password" placeholder="请输入密码"
								autocomplete="off" tabindex="1" name="password" /> <br /> <br />
							<input type="submit" value="登录" id="sub_btn" />
						</form>
					</div>

				</div>
			</div>
		</div>
	</div>
	<div id="bottom">
		<span> 尚硅谷书城.Copyright &copy;2015 </span>
	</div>
</body>
</html>