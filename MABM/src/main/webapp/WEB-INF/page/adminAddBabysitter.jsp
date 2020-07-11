<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
<title>艾琪母婴服务系统-添加育婴师</title>
<script type="text/javascript" src="./js/jquery/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="./js/laydate/laydate.js"></script>
<script type="text/javascript" src="./js/layui/layui.all.js"></script>
<script type="text/javascript" src="./js/verificationCode/gVerify.js"></script>
<script type="text/javascript" src="./js/page/register.js"></script>
<link rel="stylesheet" href="./css/layui/css/layui.css" />
<link rel="stylesheet" href="./css/page/register.css" />  <!-- 添加育婴师css与主册用户css类似，不在独立编写 -->
<link rel="stylesheet" href="./css/page/common.css" />
<link rel="shortcut icon" type="image/x-icon" href="./img/title.ico" />
</head>
<body>
	<div class="container layui-row">
	  <div class="content layui-col-xs6 layui-col-sm6 layui-col-md4">
		<form class="layui-form" action="addBabysitter.do" method="post" style="margin-top:20px;margin-left:20px;">
			<div class="layui-form-item">
				<label class="layui-form-label">
				   <i class="layui-icon layui-icon-username"></i> 姓名:  
				</label>
				<div class="layui-input-inline"> 
					<input type="text" name="babysitterName" required lay-verify="required"
						placeholder="请输入姓名" autocomplete="off" class="layui-input"
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
				   <span style="color:#169D8B;">5~15位字符组成，必须包含英文和数字</span>  
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
				  <i class="layui-icon layui-icon-rate-solid"></i> 年&nbsp;龄:
				</label>
				<div class="layui-input-inline">
					<input type="text" name="age" required lay-verify="required"
						placeholder="请输入年龄" autocomplete="off" class="layui-input" maxlength="2"
						onkeyup="value=value.replace(/[^0-9]/g,'')">
				</div>
				<div class="layui-form-mid layui-word-aux">
				   <span class="import" style="color:red">*</span>
				   <span style="color:#169D8B;">年龄为2位数字组成</span>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">
				   <i class="layui-icon layui-icon-tabs"></i> 地&nbsp;址: 
				</label>
				<div class="layui-input-inline">
					<input type="text" name="babysitterFrom" required
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
				   <i class="layui-icon layui-icon-date"></i> 工作时间: 
				</label>
				<div class="layui-input-inline">
					<input type="text" id="time" required name="workTime"
						lay-verify="date" placeholder="请点击文本框选择工作时间" autocomplete="off"
						class="layui-input"/> 
				</div>
				<div class="layui-form-mid layui-word-aux">
				   <span class="import" style="color:red">*</span>
				   <span style="color:#169D8B;">点击文本框选择出生年月</span>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">
				   <i class="layui-icon layui-icon-tabs"></i> 服务内容: 
				</label>
				<div class="layui-input-inline">
					<input type="text" name="workInfo" required
						lay-verify="required" placeholder="请输入服务内容" autocomplete="off"
						class="layui-input">
				</div>
				<div class="layui-form-mid layui-word-aux">
				    <span class="import" style="color:red">*</span>
				    <span style="color:#169D8B;">请输入服务内容</span>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">
				   <i class="layui-icon layui-icon-tabs"></i> 星&nbsp;座: 
				</label>
				<div class="layui-input-inline">
					<input type="text" name="constellation" required
						lay-verify="required" placeholder="请输入星座" autocomplete="off"
						class="layui-input">
				</div>
				<div class="layui-form-mid layui-word-aux">
				    <span class="import" style="color:red">*</span>
				    <span style="color:#169D8B;">请输入星座</span>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">
				   <i class="layui-icon layui-icon-auz"></i> 已获证书:
				</label>
				<div class="layui-input-inline">
					<input type="text" name="certificate" required
						lay-verify="required" placeholder="请输入已获证书" autocomplete="off"
						class="layui-input">
				</div>
				<div class="layui-form-mid layui-word-aux">
				    <span class="import" style="color:red">*</span>
				    <span style="color:#169D8B;">输入已获育婴师类别的证书</span>
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
			<div class="layui-form-item">
				<label class="layui-form-label">育婴师等级:</label>
				<div class="layui-input-inline">
					<select name="level">
					    <option value="1">初级</option>
						<option value="2">中级</option>
					    <option value="3">高级</option>
					</select>
				</div>
				<div class="layui-form-mid layui-word-aux">
				    <span class="import" style="color:red">*</span>
				    <span style="color:#169D8B;">请选择育婴师等级</span>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">选择学历:</label>
				<div class="layui-input-inline">
					<select name="education">
					    <option value="本科">本科</option>
						<option value="专科">专科</option>
					    <option value="博士">博士</option>
					    <option value="研究生">研究生</option>
						<option value="其他">其他</option>
					</select>
				</div>
				<div class="layui-form-mid layui-word-aux">
				    <span class="import" style="color:red">*</span>
				    <span style="color:#169D8B;">请选择学历</span>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">
				   <i class="layui-icon layui-icon-user"></i> 婚姻状况:
				</label> 
				<div class="layui-input-block">
					<input type="radio" name="isMarital" value="no" title="未婚" checked /> 
					<input type="radio" name="isMarital" value="yes" title="已婚" />
				</div>
			</div>
			<div class="layui-form-item" id="buttonGroup"> 
				<div class="layui-input-block" style="margin-left:116px;">
					<button type="submit" class="layui-btn" lay-submit id="registerSubmit" lay-filter="formDemo">立即提交</button>
					<button type="reset" class="layui-btn" id="reset">重置</button> 
				</div>
			</div>
		</form>
	</div>
 </div>
 <script type="text/javascript">
    laydate.render({
		elem : '#time' // 指定元素
	});
 </script>
</body>
</html>