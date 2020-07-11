<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
<title>艾琪母婴-更改回访记录</title>
<script type="text/javascript" src="./js/jquery/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="./js/laydate/laydate.js"></script>
<script type="text/javascript" src="./js/layui/layui.all.js"></script>
<link rel="stylesheet" href="./css/layui/css/layui.css" />
<link rel="stylesheet" href="./css/page/common.css" />
<link rel="stylesheet" href="./css/page/register.css" />  <!-- 更新回访记录css与注册用户css类似，不在独立编写 -->
<link rel="shortcut icon" type="image/x-icon" href="./img/title.ico" />
</head>
<body>
	<div class="container layui-row" style="width:450px;">
	  <div class="content" style="width:430px;margin-left:10px;">
		<form class="layui-form" action="updateInterview.do" method="post" style="margin-top:20px;" id="form">
			<div class="layui-form-item">
				<label class="layui-form-label">
				   <i class="layui-icon layui-icon-username"></i> 用户:  
				</label>
				<div class="layui-input-inline" style="width:265px;"> 
					<input type="text"  required lay-verify="required" style="background-color:#EBEBE4;"
						value="${interview.username }" autocomplete="off" class="layui-input" disabled>
					<input type="hidden" name="id" value="${interview.id}" /> <!-- 保存回访记录id，表单发送回id -->
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">
				  <i class="layui-icon layui-icon-user"></i> 接待人员:
				</label>
				<div class="layui-input-inline" style="width:265px;">
					<input type="text"  required lay-verify="required" style="background-color:#EBEBE4;"
					value="${interview.recepteName }" autocomplete="off" class="layui-input" disabled>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">
				  <i class="layui-icon layui-icon-date"></i> 申请时间:
				</label>
				<div class="layui-input-inline" style="width:265px;">
					<input type="text"  required lay-verify="required"  placeholder="输入格式为yyyy-MM-dd"
					autocomplete="off" class="layui-input" name="interviewDate"/>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">
				  <i class="layui-icon layui-icon-cellphone-fine"></i> 回访方式:
				</label>
				<div class="layui-input-inline" style="width: 265px">
					<select name="interviewClassify">
					    <option value="来电">打电话</option>
						<option value="来访">去公司到访</option>
						<option value="邮件">发邮件</option>
						<option value="来信">写信</option>
					</select>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">
				   <i class="layui-icon layui-icon-home"></i> 育婴中心:
				</label>
				<div class="layui-input-block">
					<div class="layui-input-inline" style="width: 265px">
					<select name="interviewAddress">
					    <option value="四川省成都市锦江区艾琪母婴服务中心">成都市锦江区艾琪母婴服务中心</option>
						<option value="四川省成都市金牛区艾琪母婴服务中心">成都市金牛区艾琪母婴服务中心</option>
						<option value="四川省成都市青白江区艾琪母婴服务中心">成都市青白江区艾琪母婴服务中心</option>
						<option value="四川省成都市成华区艾琪母婴服务中心">成都市成华区艾琪母婴服务中心</option>
						<option value="四川省都市郫都区艾琪母婴服务中心">都市郫都区艾琪母婴服务中心</option>
						<option value="四川省成都市龙泉驿区艾琪母婴服务中心">成都市龙泉驿区艾琪母婴服务中心</option>
						<option value="四川省成都市双流区艾琪母婴服务中心">成都市双流区艾琪母婴服务中心</option>
					</select>
				</div>
			</div>
		 </div>
			<div class="layui-form-item layui-form-text">
			    <label class="layui-form-label">
			      <i class="layui-icon layui-icon-dialogue"></i> 沟通内容:
			    </label>
			    <div class="layui-input-block" style="position:relative;top:-30px;">
			      <textarea placeholder="请输入沟通内容" class="layui-textarea" name="interviewInfo" lay-verify="required"></textarea>
			    </div>
		    </div>
			<div class="layui-form-item" id="buttonGroup"> 
				<div class="layui-input-block" style="margin-left:180px;">
					<button type="submit" class="layui-btn" lay-submit id="registerSubmit" lay-filter="formDemo">立即提交</button>
					<button type="reset" class="layui-btn" id="reset">重置</button> 
				</div>
			</div>
		</form>
	</div>
 </div>
 <script type="text/javascript">
    layui.use('form', function() {
		var form = layui.form;
		form.render();   //加载layui表单
	});
 </script>
 </body>
</html>