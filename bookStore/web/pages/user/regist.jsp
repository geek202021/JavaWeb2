<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>尚硅谷会员注册页面</title>
<%--	<link type="text/css" rel="stylesheet" href="../../static/css/style.css" >--%>
<%--	<script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>--%>
	<%@ include file="/pages/common/head.jsp" %>
	<script type="text/javascript">
		$(function () {
			//使用Ajax验证用户名是否可用
			$("#username").blur(function () {
				var username = this.value;
				$.getJSON("http://localhost:8080/bookStore/userServlet", "action=ajaxExistUsername&username="+username, function (data) {
					if (data.existUsername) {
						$("span.errorMsg").text("用户名已存在！")
					} else{
						$("span.errorMsg").text("用户名可用！")
					}
				});
			});

			// 给验证码图片绑定单击事件
			$("#img_code").click(function () {
				// 在事件响应的function函数中有一个this对象。这个this对象，是当前正在响应事件的dom对象
				// src 属性表示验证码 img 标签的 图片路径。它可读，可写
				// alert(this.src);
				this.src = "${basePath}kaptcha.jpg?dt=" + new Date();
			});

			$("#sub_btn").click(function () {
				var usernameText = $("#username").val();
				var usernameRE = /^\w{5,12}$/;
				if (!usernameRE.test(usernameText)) {
					$("span.errorMsg").text("用户名只能是由字母，数字下划线组成，并且长度为5到12位");
					return false;
				}
				var passwordText = $("#password").val();
				var passwordRE = /^\w{5,12}$/;
				if (!passwordRE.test(passwordText)) {
					$("span.errorMsg").text("密码只能是由字母，数字下划线组成，并且长度为5到12位");
					return false;
				}
				var repwText = $("#repwd").val();
				if (repwText != passwordText) {
					$("span.errorMsg").text("两次输入密码不一致！请重新输入");
					return false;
				}
				var emailText = $("#email").val();
				var emailRE = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
				// var emailPatt = /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
				if (!emailRE.test(emailText)) {
					$("span.errorMsg").text("邮箱格式有误,请重新输入！");
					return false;
				}
				var codeText = $("#code").val();
				codeText = $.trim(codeText);
				if (codeText == null || codeText == "") {
					$("span.errorMsg").text("验证码不能为空！");
					return false;
				}
				$("span.errorMsg").text("");
			});
		});
	</script>
	<style type="text/css">
		.login_form{
			height:420px;
			margin-top: 25px;
		}
	</style>
</head>
<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
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
								<span class="errorMsg">
									${requestScope.msg}
								</span>
							</div>
							<div class="form">
								<form action="userServlet" method="post">
									<input type="hidden" name="action" value="regist"/>
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off"
										   tabindex="1" name="username" id="username"
										   value="${requestScope.username}"/><br /><br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password" id="password" /><br /><br />
									<label>确认密码：</label>
									<input class="itxt" type="password" placeholder="确认密码" autocomplete="off" tabindex="1" name="repwd" id="repwd" /><br /><br />
									<label>电子邮件：</label>
									<input class="itxt" type="text" placeholder="请输入邮箱地址" autocomplete="off"
										   tabindex="1" name="email" id="email"
										   value="${requestScope.email}"/><br /><br />
									<label>验证码：</label>
									<input class="itxt inp" type="text" name="code" style="width: 140px;" id="code"/>
									<img id="img_code" alt="" src="kaptcha.jpg" style="float: right; margin-right: 22px;width:100px;height:35px;"><br /><br />
									<input type="submit" value="注册" id="sub_btn" />
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>

		<%@ include file="/pages/common/foot.jsp" %>
</body>
</html>