<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
<title>艾琪母婴-预约信息</title>
<script type="text/javascript" src="../js/jquery/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="../js/laydate/laydate.js"></script>
<script type="text/javascript" src="../js/layui/layui.all.js"></script>
<script type="text/javascript" src="../js/page/orderBabysitter.js"></script> 
<link rel="stylesheet" href="../css/layui/css/layui.css" />
<link rel="stylesheet" href="../css/page/common.css" />
<link rel="stylesheet" href="../css/page/orderBabysitter.css" />
<link rel="shortcut icon" type="image/x-icon" href="../img/title.ico" />
</head>
<body>
  <form action="orderBabysitter.do" method="post" class="layui-form" id="form">
     <div class="layui-form-item">
		<label class="layui-form-label"><i class='layui-icon layui-icon-username'></i> 用户名:</label>
		<div class="layui-input-inline" >
			<input type="text" name="customer" autocomplete="off"
				class="layui-input" value="${user.name }"
				style="background-color:#EBEBE4" readonly />
		</div> 
	 </div>
	 <div class="layui-form-item">
		<label class="layui-form-label"><i class='layui-icon layui-icon-user'></i> 育婴师:</label>
		<div class="layui-input-inline" >
			<input type="text" name="babysitterName" autocomplete="off"
				class="layui-input" value="${babysitter.babysitterName }"
				style="background-color:#EBEBE4" readonly />
		</div> 
	 </div>
	 <div class="layui-form-item">
		<label class="layui-form-label"><i class='layui-icon layui-icon-cellphone-fine'></i> 用户电话:</label>
		<div class="layui-input-inline" >
			<input type="text" name="customerTel" autocomplete="off"
				class="layui-input" value="${user.telphone }" 
			onkeyup="value=value.replace(/[^0-9]/g,'')" maxlength="11" required/>
		</div> 
	 </div>
	 <div class="layui-form-item">
		<label class="layui-form-label"><i class='layui-icon layui-icon-cellphone'></i> 育婴师电话:</label>
		<div class="layui-input-inline" >
			<input type="text" name="babysittertel" autocomplete="off"
				class="layui-input" value="${babysitter.telphone}" 
			onkeyup="value=value.replace(/[^0-9]/g,'')" maxlength="11" required/>
		</div> 
	 </div>
	 <div class="layui-form-item">
		<label class="layui-form-label"><i class='layui-icon layui-icon-form'></i> 育婴内容:</label>
		<div class="layui-input-inline" >
			<input type="text" name="requestInfo" autocomplete="off"
				class="layui-input" value="${babysitter.workInfo}" required />
		</div> 
	 </div>
	
	 <div class="layui-form-item" style="margin-top: 20px;">
			<label class="layui-form-label"><i class='layui-icon layui-icon-home'></i> 育婴中心:</label>
			<div class="layui-input-block">
				<div class="layui-input-inline">
				<select name="address">
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
	  <div class="layui-form-item">
		<label class="layui-form-label"><i class='layui-icon layui-icon-date'></i> 预产期:</label>
		<div class="layui-input-inline">
			<input type="text" name="childbirthDate" autocomplete="off" id="time"
				class="layui-input" required placeholder="点击文本框选择预产期"/>
		</div> 
	 </div>
	  <div class="layui-form-item">
		<label class="layui-form-label"><i class='layui-icon layui-icon-tips'></i> 预约时间:</label>
		<div class="layui-input-inline">
			<input type="text" name="requestDate" autocomplete="off" id ="time"
				class="layui-input" required/>
		</div> 
	 </div>
	 <div class="layui-form-item" id="buttonGroup"> 
		<div class="layui-input-block">
			<button type="submit" class="layui-btn" id="registerSubmit">立即提交</button>
			<button type="reset" class="layui-btn" id="reset">重置</button> 
		</div>
	</div>
  </form>
</body>
</html>