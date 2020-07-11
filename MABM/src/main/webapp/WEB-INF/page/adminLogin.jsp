<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
<title>艾琪母婴-管理员登录</title>
<script type="text/javascript" src="./js/jquery/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="./js/laydate/laydate.js"></script>
<script type="text/javascript" src="./js/layui/layui.all.js"></script>
<script type="text/javascript" src="./js/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="./js/bootstrap-3.3.7-dist/css/bootstrap.min.css"/>
<link rel="stylesheet" href="./css/layui/css/layui.css" />
<link rel="stylesheet" href="./css/page/common.css" /> 
<link rel="stylesheet" href="./css/page/adminLogin.css" />
<link rel="shortcut icon" type="image/x-icon" href="./img/title.ico"/>
</head>
<body>
<body>
    <div class="container">
     <div class="center-form layui-card">
		        <div class="layui-card-header">
		           <img src="./img/logo.png"/>
		           <span>艾琪母婴服务管理系统</span>
		        </div>
		        <div class="layui-card-body" style="margin-left:-30px;margin-top: 20px">   
					<form id="loginForm" class="layui-form" action="admin.do" method="post">
					    <div id="logo" style="float:left;">
					     <img src="./img/adminLogo.png"/>
					    </div>
						<div class="layui-form-item">
							<label class="layui-form-label">
							       用户名:
							 </label>
							<div class="layui-input-block">
								<input type="text" name="name" required lay-verify="required"
									placeholder="请输入用户名" autocomplete="off" class="layui-input">
							</div>
						</div>
						<div class="layui-form-item">
							<label class="layui-form-label">
							         密&nbsp;码:
							</label> 
							<div class="layui-input-block"> 
								<input type="password" name="password" required
									lay-verify="required" placeholder="请输入密码" autocomplete="off"
									class="layui-input">
							</div>
						</div>
						<div class="layui-form-item" id="login-button" style="margin-top:25px;">
							<div class="layui-input-block"> 
								<input type="submit" value="登录" class="layui-btn" id="loginSubmit"/>
								<input type="reset" value="重置" class="layui-btn" id="reset"/>
							</div>
						</div> 
						<div id="return" style="float:right;">
						  <a href="index" style="text-decoration:underline;color:green;">返回主页</a>
						</div>
					</form>
				</div>
      </div>
      </div>
  </body>
</body>
</html>