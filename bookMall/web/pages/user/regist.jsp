<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>尚硅谷会员注册页面</title>
	<%@ include file="/pages/common/head.jsp" %>
	<script type="text/javascript">
		$(function () {
			$("#sub_btn").click(function () {
				let usernameText = $("#username").val();
				let usernameRE = /^\w{5,12}$/;
				if (!usernameRE.test(usernameText)) {
					$("span.errorMsg").text("用户名只能是由字母，数字下划线组成，并且长度为5到12位");
					return false;
				}
				let pwdText = $("#password").val();
				let pwdRE = /^\w{5,12}$/;
				if (!pwdRE.test(pwdText)) {
					$("span.errorMsg").text("密码只能是由字母，数字下划线组成，并且长度为5到12位");
					return false;
				}
				let repwdText = $("#repwd").val();
				if (repwdText != pwdText) {
					$("span.errorMsg").text("两次输入密码不一致！请重新输入");
					return false
				}
				let emailText = $("#email").val();
				let emailRE = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
				if (!emailRE.test(emailText)) {
					$("span.errorMsg").text("邮箱格式有误，请重新输入！");
					return false;
				}
				let codeText = $("#code").val();
				codeText = $.trim(codeText);
				if (codeText == null || codeText == "") {
					$("span.errorMsg").text("验证码不能为空");
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
								<span class="errorMsg"></span>
							</div>
							<div class="form">
								<form action="regist_success.jsp">
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1" name="username" id="username" /><br /><br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password" id="password" /><br /><br />
									<label>确认密码：</label>
									<input class="itxt" type="password" placeholder="确认密码" autocomplete="off" tabindex="1" name="repwd" id="repwd" /><br /><br />
									<label>电子邮件：</label>
									<input class="itxt" type="text" placeholder="请输入邮箱地址" autocomplete="off" tabindex="1" name="email" id="email" /><br /><br />
									<label>验证码：</label>
									<input class="itxt inp" type="text" style="width: 155px;" id="code"/>
									<img alt="" src="static/img/code.bmp" style="float: right; margin-right: 22px"><br /><br />
									<input type="submit" value="注册" id="sub_btn" />
									
								</form>
							</div>
							
						</div>
					</div>
				</div>
			</div>
		<%@include file="/pages/common/foot.jsp"%>

</body>
</html>