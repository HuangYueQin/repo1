<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
<title>艾琪母婴-用户回访</title>
<script type="text/javascript" src="../js/jquery/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="../js/laydate/laydate.js"></script>
<script type="text/javascript" src="../js/layui/layui.all.js"></script>
<script type="text/javascript" src="../js/page/userInterview.js"></script> 
<script type="text/javascript" src="../js/ckeditor/ckeditor.js"></script>
<link rel="stylesheet" href="../css/layui/css/layui.css" />
<link rel="stylesheet" href="../css/page/common.css" />
<link rel="stylesheet" href="../css/page/userApprise.css" /> <!-- 此处和评价页面css一样,不单独再写css -->
<link rel="shortcut icon" type="image/x-icon" href="../img/title.ico" />
</head>
<body>
	<div class="container layui-row">
		<div class="header layui-col-xs6 layui-col-sm6 layui-col-md12">
			<div class="header-logo">
				<a href="javascript:;"><img alt="logo图" src="../img/logo.png"></a>
			</div>
			<div class="header-title">
				<span class="header-title-text">艾琪母婴</span><br /> <span
					class="header-title-text-english">MABM.COM</span> <span
					class="header-title-english">AiQi Maternal And Child Manage
					System</span>
			</div>
			<div class="return">
				<i class="layui-icon layui-icon-home" style="color: white;"></i><a
					href="../index.do">返回主页</a>
			</div>
		</div>
		<div class="content-title layui-col-xs6 layui-col-sm6 layui-col-md12"
			style="margin-top: 20px;">
			<img alt="" src="../img/interviewLogo.png" style="margin-left: 66px;">
			<span id="contTitle">回访记录表-Interview</span> <i
				class="layui-icon layui-icon-down"
				style="font-size: 20px; color: gray;"></i>
			<hr style="color: #F6F6F6; margin-top: 20px;" />
		</div>
		<div class="content layui-col-xs6 layui-col-sm6 layui-col-md12">
			<form action="userInterview.do" method="post" class="layui-form">
				<div class="left layui-col-xs6 layui-col-sm6 layui-col-md5">
					<div class="layui-card" id="myform" style="height: 472px;margin-top:-10px;">
						<div class="layui-card-body">
							<div class="layui-form-item" style="margin-top: 20px;">
								<label class="layui-form-label">用户名:</label>
								<div class="layui-input-block">
									<input type="text" name="username" lay-verify="title"
										autocomplete="off" placeholder="请输入用户名" class="layui-input"
										value = "${user.name }"
										style="background-color:#EBEBE4" readonly/>
								</div>
							</div>

							<div class="layui-form-item">
								<label class="layui-form-label">回访方式:</label>
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
								<label class="layui-form-label">申请时间:</label>
								<div class="layui-input-block">
									<input type="text" name="interviewDate" id="time" required
										lay-verify="title" autocomplete="off" placeholder="点击文本框选择时间"
										class="layui-input">
								</div>
							</div>

							<div class="layui-form-item">
								<label class="layui-form-label">接待人员:</label>
								<div class="layui-input-block">
									<div class="layui-input-inline" style="width: 265px">
									<select name="recepteName">
									    <option value="adminDing">丁经理</option>
										<option value="adminChen">陈经理</option>
										<option value="adminHuang">黄经理</option>
										<option value="adminLiu">刘经理</option>
										<option value="adminWang">王经理</option>
									</select>
								</div>
								</div>
							</div>

							<div class="layui-form-item" style="margin-top: 20px;">
								<label class="layui-form-label">育婴中心:</label>
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
					</div>
				  </div>
				</div>
				<div class="right layui-col-xs6 layui-col-sm6 layui-col-md7">
					<div class="layui-card" id="myform">
						<div class="layui-card-body">
							<div class="layui-form-item">
								<div style="float: left;">
									<label class="layui-form-label">沟通内容:</label>
								</div>
								<div class="layui-input-block"
									style="float: left; margin-left: 15px;">
									<textarea class="ckeditor" id="interviewInfo" required
										name="interviewInfo"></textarea>
								</div>
							</div>
							<div class="layui-form-item" id="login-button">
								<div class="layui-input-block button">
									<input type="reset" value="重置" class="layui-btn" id="reset" />
									<input type="submit" value="提交" class="layui-btn"
										id="loginSubmit" />
								</div>
							</div>
						</div>
					</div>
				</div>
			</form>
		</div>
		<div class="footer layui-col-xs6 layui-col-sm6 layui-col-md12">
			<p>
				© 2019 <a href="javascript:;"> MABM.com</a> MIT license
			</p>
			<p>Copyright & 2019.4.11,HuangYueQin, All Rights Reserved</p>
		</div>
	</div>
</body>
</html>