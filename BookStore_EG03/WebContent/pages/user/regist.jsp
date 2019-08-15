<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>尚硅谷会员注册页面</title>
<%@ include file="/WEB-INF/include/base.jsp" %>
<style type="text/css">
.login_form {
	height: 420px;
	margin-top: 25px;
}
</style>
<script type="text/javascript">
	$(function(){
		
		//1、查找注册按钮绑定单击事件
		$("#sub_btn").click(function(){
			//2、点击时 获取用户注册信息逐个验证
			var $name = $("[name='username']").val();
			//js中直接支持正则对象
			//创建验证姓名的正则对象
			var nameReg = /^[a-zA-Z0-9_-]{3,16}$/;//包含大小写字母a-z,数字0-9,_,-的用户名
			//使用正则对象 验证姓名字符串   reg.test(要验证的字符串) 如果匹配上返回ture，匹配不上返回false
			if(!nameReg.test($name)){
				//提示
				alert("请输入一个包含大小写字母a-z,数字0-9,_,-的三位以上的用户名");
				//如果用户输入错误，取消按钮的默认行为
				return false;
			}
			var $password = $("[name='password']").val();
			//创建验证密码的正则对象
			var pwdReg = /^[a-z0-9_-]{6,18}$/;
			if(!pwdReg.test($password)){
				alert("请输入一个包含小写字母a-z,数字0-9,_,-的六位以上的密码");
				return false;
			};
			var $repwd = $("[name='repwd']").val();
			//直接和$password比较是否一致，如果一致可以提交，不一致取消提交
			if($repwd != $password){
				alert("两次密码输入不一致！");
				return false;
			}
			var $email = $("[name='email']").val();
			//创建邮箱正则对象
			var emailReg = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
			//测试邮箱
			if(!emailReg.test($email)){
				alert("邮箱地址错误!");
				return false;
			}

		});
	});
</script>
<script type="text/javascript">
	$(function(){
		var i=0;
		$("#img_code").click(function(){
			$(this).attr("src","code.jpg?"+i++);
		})
		
		
		$("[name='username']").change(function(){
			var name=this.value;
			$.post("${pageContext.request.contextPath}/UserServlet",{"method":"checkName","username":name,"n":Math.random()},function(result){
				if(result.name!="用户名可以使用"){
					$("#sub_btn").attr("disabled",true);
					$("#sub_btn").css("background-color","gray");
				}else{
					$("#sub_btn").attr("disabled",false);
					$("#sub_btn").css("background-color","#bbffaa");
				}
				$(".errorMsg").text(result.name);
			},"json");
		})
	})

</script>
</head>
<body>
	<div id="login_header">
		<img class="logo_img" alt="" src="static/img/logo.gif">
	</div>
	<div class="login_banner">

		<div id="l_content">
			<span class="login_word">欢迎注册</span>
		</div>

		<div id="content">
			<div class="login_form">
				<div class="login_box">
					<div class="tit">
						<h1>注册尚硅谷会员</h1>
						<%
							String msg=(String)request.getAttribute("errMsg");
							if(msg==null){
								msg="";
							}
						%>
<%-- 						<span class="errorMsg"><%=msg %></span> --%>
						<span class="errorMsg">${requestScope.errMsg }</span>
					</div>
					<div class="form">
						<form action="UserServlet" method="post">
							<input type="hidden" name="method" value="UserRegist">
							<label>用户名称：</label> <input class="itxt" type="text"
								placeholder="请输入用户名" autocomplete="off" tabindex="1"
								name="username"
								value="<%=request.getParameter("username") == null ? "" : request.getParameter("username")%>" />
							<br /> <br /> <label>用户密码：</label> <input class="itxt"
								type="password" placeholder="请输入密码" autocomplete="off"
								tabindex="1" name="password"
								value="${param.password }" />
							<br /> <br /> <label>确认密码：</label> <input class="itxt"
								type="password" placeholder="确认密码" autocomplete="off"
								tabindex="1" name="repwd"
								value="${param.repwd }" />
							<br /> <br /> <label>电子邮件：</label> <input class="itxt"
								type="text" placeholder="请输入邮箱地址" autocomplete="off"
								tabindex="1" name="email"
								value="${param.email }" />
							<br /> <br /> <label>验证码：</label> <input class="itxt"
								type="text" style="width: 150px;" name="code" /> <img alt=""
								src="code.jpg" 
								style="float: right; margin-right: 40px ;width: 90px;height: 40px" id="img_code"> <br /> <br />
							<input type="submit" value="注册" id="sub_btn" />

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