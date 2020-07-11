<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
<title>艾琪母婴-用户评价</title>
<script type="text/javascript" src="../js/jquery/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="../js/laydate/laydate.js"></script>
<script type="text/javascript" src="../js/layui/layui.all.js"></script>
<script type="text/javascript" src="../js/page/userApprise.js"></script>
<script type="text/javascript" src="../js/ckeditor/ckeditor.js"></script>
<link rel="stylesheet" href="../css/layui/css/layui.css" />
<link rel="stylesheet" href="../css/page/common.css" />
<link rel="stylesheet" href="../css/page/userApprise.css" />
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
			<img alt="" src="../img/appriseLogo.png" style="margin-left: 66px;">
			<span id="contTitle">用户评价-Apprise</span> <i
				class="layui-icon layui-icon-down"
				style="font-size: 20px; color: gray;"></i>
			<hr style="color: #F6F6F6; margin-top: 20px;" />
		</div>
		<div class="content layui-col-xs6 layui-col-sm6 layui-col-md12">
			<form action="userApprise.do" method="post" class="layui-form">
				<div class="left layui-col-xs6 layui-col-sm6 layui-col-md5">
					<div class="layui-card" id="myform" style="height:472px;margin-top:-10px;">
						<div class="layui-card-body">
							<div class="layui-form-item" style="margin-top: 20px;">
								<label class="layui-form-label">用户名:</label>
								<div class="layui-input-block">
									<input type="text" name="userName" lay-verify="title"
										autocomplete="off" placeholder="请输入用户名" class="layui-input"
										value = "${user.name }"
										style="background-color:#EBEBE4" readonly/>
								</div>
							</div>

							<div class="layui-form-item">
								<label class="layui-form-label">选择育婴师:</label>
								<div class="layui-input-inline" style="width: 265px">
									<select name="babysitterName">
										<option value="zhanglanlan">张兰兰</option>
										<option value="wanglili">王丽丽</option>
										<option value="yijuying">易桔颖</option>
										<option value="baijie">白洁</option>
										<option value="wangjiao">王姣</option>
										<option value="huangyue">黄悦</option>
										<option value="kuangyaxing">旷亚婞</option>
										<option value="xiejuying">谢菊颖</option>
										<option value="yiyunwan">易运绾</option>
										<option value="liuzhimei">刘智梅</option>
									</select>
								</div>
							</div>

							<div class="layui-form-item">
								<label class="layui-form-label">评价时间:</label>
								<div class="layui-input-block">
									<input type="text" name="appriseTime" id="time" required
										lay-verify="title" autocomplete="off" placeholder="点击文本框选择时间"
										class="layui-input">
								</div>
							</div>

							<div class="layui-form-item">
								<label class="layui-form-label">评价标题:</label>
								<div class="layui-input-block">
									<input type="text" name="appriseInfo" lay-verify="title" required
										autocomplete="off" placeholder="请输入标题" class="layui-input">
								</div>
							</div>

							<div class="layui-form-item">
								<label class="layui-form-label">评分:</label>
								<div class="layui-input-block">
									<div id="score"></div>
									<input type="hidden" name="appriseScore" />
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
									<label class="layui-form-label">评价与建议:</label>
								</div>
								<div class="layui-input-block"
									style="float: left; margin-left: 15px;">
									<textarea class="ckeditor" id="appriseRecommend"
										name="appriseRecommend"></textarea>
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