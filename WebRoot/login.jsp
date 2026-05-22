<%@ page language="java" import="com.spring.util.*,java.util.*,com.spring.util.QueryUtil.*" pageEncoding="UTF-8" %>
 <%@ taglib prefix="ssm" uri="http://ssm" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>长包房管理系统-后台登录</title>

	<link href="assets/fontAwesome/css/fontawesome-all.min.css" rel="stylesheet">
	<link href="assets/css/lib/themify-icons.css" rel="stylesheet">
	<link href="assets/css/lib/bootstrap.min.css" rel="stylesheet">
	<link href="assets/css/lib/nixon.css" rel="stylesheet">
	<link href="assets/css/style.css" rel="stylesheet">

</head>
<body>



<style>
	body{
		background: #00838F;
		color: #fff;
	}
	.form-control-lg{
		width: 180px;
		float: left;
	}
	.input-group-append{
		float: left;
	}

</style>

	<div class="Nixon-login">
		<div class="container">
			<div class="row">
				<div class="col-lg-6 col-lg-offset-3">
					<div class="login-content">
						<div class="login-logo">
							<a href="./"><span>长包房管理系统</span></a>
						</div>
						<div class="login-form">
							<h4>输入账号密码，登录系统.</h4>
							<form action="authAdminLogin.do?a=a" id="loginForm" name="loginForm" method="post" onsubmit="return submitForm()">
								<div class="form-group">
									<label>账号</label>
									<input type="text" class="form-control" placeholder="账号" id="username" name="username">
								</div>
								<div class="form-group">
									<label>密码</label>
									<input type="password" class="form-control"  placeholder="密码" id="password" name="pwd" >
								</div>
								<div class="form-group">
									<label>验证码</label>
									 <div class="row">
										 <div class="col-md-12">
											<div class="form-group">
												<input type="text" class="form-control form-control-lg" name="pagerandom" id="pagerandom" placeholder="验证码">
												<span class="input-group-append">
												 <img src="captcha.do" style="min-width: 70px;min-height: 40px;" onClick="this.src='captcha.do?time='+new Date().getTime();" alt="点击刷新"></span>
											 </div>
										 </div>
                       				 </div>
								</div><br>
								<div class="form-group">
									<select id="sys" name="cx" class="form-control">
										<option value="管理员">管理员</option>
										<option value="用户">用户</option>
									</select>
								</div>


								<button type="submit" class="btn btn-primary btn-flat m-b-30 m-t-30">Sign in</button>

								<div class="register-link m-t-15 text-center">
									<p>Don't have account ? <a href="./"> 返回首页 </a></p>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script>
		function submitForm() {
			var frm = $('#loginForm');
			var form = $(frm);
			var input;
			input = form.find('#username');
			if(input.val() == '')
			{
				alert('请填写账号');
				return false;
			}
			input = form.find('#password');
			if(input.val() == '')
			{
				alert('请填写密码');
				return false;
			}
			input = form.find('#pagerandom');
			if(input.val() == '')
			{
				alert('请填写验证码');
				return false;
			}
			return true;
		}
	</script>

</body>
</html>