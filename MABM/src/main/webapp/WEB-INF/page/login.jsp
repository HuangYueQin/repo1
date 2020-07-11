<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
<title>艾琪母婴服务系统-登录</title>
<script type="text/javascript" src="./js/jquery/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="./js/layui/layui.all.js"></script>
<script type="text/javascript" src="./js/verificationCode/gVerify.js"></script>
<script type="text/javascript" src="./js/page/login.js"></script>
<link rel="stylesheet" href="./css/layui/css/layui.css" />
<link rel="stylesheet" href="./css/page/login.css" />
<link rel="stylesheet" href="./css/page/common.css" />
<link rel="shortcut icon" type="image/x-icon" href="./img/title.ico" />
</head>
<body>

	<div class="container layui-row">
		<div class="header"
			class="header layui-col-xs6 layui-col-sm6 layui-col-md4">
			<div class="header-logo">
				<a href="javascript:;"><img alt="logo图" src="./img/logo.png"></a>
			</div>
			<div class="header-title">
				<a href="javascript:;"><img alt="logo图"
					src="./img/logoTitle.png" height="64px"></a>
			</div>
		</div>
		<div class="center layui-col-xs6 layui-col-sm6 layui-col-md4">
		   <div class="center-form layui-card">
		        <div class="layui-card-header"></div>
		        <div class="layui-card-body" style="margin-left:-30px;margin-top: 20px">   
					<form id="loginForm" class="layui-form" action="toLogin.do" method="post">
						<div class="layui-form-item">
							<label class="layui-form-label">
							  <i class="layui-icon layui-icon-username"></i> 用户名:
							 </label>
							<div class="layui-input-block">
								<input type="text" name="name" required lay-verify="required"
									placeholder="请输入用户名" autocomplete="off" class="layui-input">
							</div>
						</div>
						<div class="layui-form-item">
							<label class="layui-form-label">
							   <i class="layui-icon layui-icon-password"></i> 密&nbsp;码:
							</label> 
							<div class="layui-input-block"> 
								<input type="password" name="password" required
									lay-verify="required" placeholder="请输入密码" autocomplete="off"
									class="layui-input">
							</div>
						</div>
						<div class="layui-form-item" id="vertify"> 
							<label class="layui-form-label">
							   <i class="layui-icon layui-icon-vercode"></i> 验证码:
							</label> 
							<div class="layui-input-block"> 
								<input type="text" id="code_input" name="vercode" required
									lay-verify="code" placeholder="请输入验证码" autocomplete="off"
									class="layui-input">
								<input type="hidden" id="codeNum" name = "codeNum"/>
							</div>
						</div>
						<div class="layui-form-item" id="vertification"></div><!-- 验证码模块 -->
						<div class="layui-form-item" id="login-button" style="margin-top:25px;">
							<div class="layui-input-block"> 
								<input type="submit" value="登录" class="layui-btn" id="loginSubmit"/>
								<input type="reset" value="重置" class="layui-btn" id="reset"/>
							</div>
						</div> 
						<div id="return" style="position:relative;left:280px;top:-5px;">
						  <a href="index" style="text-decoration:underline;color:green;">返回主页</a>
						</div>
					</form>
				</div>
		  </div>
		</div>
		<div class="footer layui-col-xs6 layui-col-sm6 layui-col-md4">
			<p>
				© 2019 <a href="javascript:;"> MABM.com</a> MIT license
			</p>
			<p>Copyright & 2019.4.11,HuangYueQin, All Rights Reserved</p>
		</div>
	</div>
</body>
</html>