<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
<title>艾琪母婴服务系统-注册</title>
<script type="text/javascript" src="./js/jquery/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="./js/laydate/laydate.js"></script>
<script type="text/javascript" src="./js/layui/layui.all.js"></script>
<script type="text/javascript" src="./js/verificationCode/gVerify.js"></script>
<script type="text/javascript" src="./js/page/register.js"></script>
<link rel="stylesheet" href="./css/layui/css/layui.css" />
<link rel="stylesheet" href="./css/page/register.css" />
<link rel="stylesheet" href="./css/page/common.css" />
<link rel="shortcut icon" type="image/x-icon" href="./img/title.ico" />
</head>
<body>
	<div class="container layui-row">
	  <div class="content layui-col-xs6 layui-col-sm6 layui-col-md4">
		<form class="layui-form" action="toRegister.do" method="post" style="margin-top:20px;margin-left:20px;">
			<div class="layui-form-item">
				<label class="layui-form-label">
				   <i class="layui-icon layui-icon-username"></i> 用户名:  
				</label>
				<div class="layui-input-inline"> 
					<input type="text" name="name" required lay-verify="required"
						placeholder="请输入用户名" autocomplete="off" class="layui-input"
						onkeyup="value=value.replace(/[^0-9a-zA-Z]/g,'')" maxlength="15">
				</div>
				<div class="layui-form-mid layui-word-aux">
				    <span class="import" style="color:red">*</span>
				    <span style="color:#169D8B;">5~15位字符组成，用户名可以包含英文和数字</span>  
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">
				  <i class="layui-icon layui-icon-password"></i> 密&nbsp;码:
				</label>
				<div class="layui-input-inline">
					<input type="password" name="password" required
						lay-verify="required" placeholder="请输入密码" autocomplete="off"
						class="layui-input" onkeyup="value=value.replace(/[^0-9a-zA-Z!~#@%]/g,'')" maxlength="15">
				</div>
				<div class="layui-form-mid layui-word-aux">
				   <span class="import" style="color:red">*</span>
				   <span style="color:#169D8B;">5~15位字符组成，必须包含英文和数字（包含特殊字符包含特殊字符！~#@%）</span>  
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">
				  <i class="layui-icon layui-icon-password"></i> 确认密码:
				</label>
				<div class="layui-input-inline">
					<input type="password" name="repassword" required
						lay-verify="repassword" placeholder="请再次输入密码" autocomplete="off"
						class="layui-input" onkeyup="value=value.replace(/[^0-9a-zA-Z!~#@%]/g,'')" maxlength="15">
				</div>
				<div class="layui-form-mid layui-word-aux">
				   <span class="import" style="color:red">*</span>
				   <span style="color:#169D8B;">请再次输入密码进行密码确认</span>  
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">
				  <i class="layui-icon layui-icon-cellphone"></i> 电&nbsp;话:
				</label>
				<div class="layui-input-inline">
					<input type="text" name="telphone" required lay-verify="required|phone"
						placeholder="请输入电话" autocomplete="off" class="layui-input" maxlength="11">
				</div>
				<div class="layui-form-mid layui-word-aux">
				   <span class="import" style="color:red">*</span>
				   <span style="color:#169D8B;">电话号码只能为11位数字组成</span>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">
				   <i class="layui-icon layui-icon-tabs"></i> 地&nbsp;址: 
				</label>
				<div class="layui-input-inline">
					<input type="text" name="userFrom" required
						lay-verify="required" placeholder="请输入地址" autocomplete="off"
						class="layui-input">
				</div>
				<div class="layui-form-mid layui-word-aux">
				    <span class="import" style="color:red">*</span>
				    <span style="color:#169D8B;">输入家庭地址</span>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">
				   <i class="layui-icon layui-icon-date"></i> 出生年月: 
				</label>
				<div class="layui-input-inline">
					<input type="text" id="time" required name="birthday"
						lay-verify="date" placeholder="请点击文本框选择出生年月" autocomplete="off"
						class="layui-input"/> 
				</div>
				<div class="layui-form-mid layui-word-aux">
				   <span class="import" style="color:red">*</span>
				   <span style="color:#169D8B;">点击文本框选择出生年月</span>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">
				   <i class="layui-icon layui-icon-male"></i> 性&nbsp;别:
				</label> 
				<div class="layui-input-block">
					<input type="radio" name="sex" value="男" title="男" checked /> 
					<input type="radio" name="sex" value="女" title="女" />
				</div>
			</div>
			<div class="layui-form-item" id="vertify"> 
				<label class="layui-form-label">
				   <i class="layui-icon layui-icon-vercode"></i> 验证码: 
				</label> 
				<div class="layui-input-inline">  
					<input type="text" id="code_input" name="code" required
						lay-verify="code" placeholder="请输入验证码" autocomplete="off"
						class="layui-input">
				</div>
				<div class="layui-input-inline" id="vertification"></div><!-- 验证码模块 -->
				<input name ="codeNum" id="codeNum" type="hidden" />
			</div>
			<div class="layui-form-item" id="buttonGroup"> 
				<div class="layui-input-block" style="margin-left:116px;">
					<button type="submit" class="layui-btn" lay-submit id="registerSubmit" lay-filter="formDemo">立即提交</button>
					<button type="reset" class="layui-btn" id="reset">重置</button> 
				</div>
			</div>
		</form>
	</div>
	<div class="return">
	   <a href="index">返回主页</a>
	</div>
 </div>
</body>
</html>