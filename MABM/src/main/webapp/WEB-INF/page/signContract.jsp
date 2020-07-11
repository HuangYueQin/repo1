<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
<title>艾琪母婴-合同签订</title>
<script type="text/javascript" src="../js/jquery/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="../js/laydate/laydate.js"></script>
<script type="text/javascript" src="../js/layui/layui.all.js"></script>
<script type="text/javascript" src="../js/page/signContract.js"></script>
<link rel="stylesheet" href="../css/layui/css/layui.css" />
<link rel="stylesheet" href="../css/page/common.css" />
<link rel="stylesheet" href="../css/page/signContract.css" />
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
				<i class="layui-icon layui-icon-home"></i><a href="../index.do">返回主页</a>
			</div>
		</div>
		<div class="content layui-col-xs6 layui-col-sm6 layui-col-md12">
				<form class="layui-form" action="signContract.do" method="post">
				  <div class=" left layui-card layui-col-sm6 layui-col-md5">
				    <div class="layui-form-item" id="title"> 
				      <label class="layui-form-label" style="width:100px;"> 
				                                   签订合同<i class="layui-icon layui-icon-edit"></i>
				       </label>
				     </div> 
				    <hr style="color: #F6F6F6; "/>
						<div class="layui-form-item">
							<label class="layui-form-label">客户名:
							</label>
							<div class="layui-input-inline" style="width:206px;">
								<input type="text" name="customerName" autocomplete="off"
									class="layui-input" value="${user.name }"
									style="background-color:#EBEBE4" readonly />
							</div> 
						 </div>
					<hr style="color: #F6F6F6; "/>
							<div class="layui-form-item" style="margin-left:-20px;">
								<label class="layui-form-label" style="width:100px;">客户电话:
								</label>
								<div class="layui-input-inline">
									<input type="text" name="customerTel" autocomplete="off"
										class="layui-input" value="${user.telphone}"
										style="background-color:#EBEBE4" readonly style="width:200px;" /> 
								</div>
							</div>
					<hr style="color: #F6F6F6; "/>	
							<div class="layui-form-item">
								<label class="layui-form-label">选择育婴师:</label>
								<div class="layui-input-inline" style="width:200px;">
									<select name="babysitterName" id="babysitter">
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
					<hr style="color: #F6F6F6; "/>		
							<div class="layui-form-item">
								<label class="layui-form-label">保密级别:</label> 
								<div class="layui-input-inline" style="width:200px;">
									<select name="level">
										<option value="公开">公开</option>
										<option value="保密">保密</option>
									</select>
								</div>
							</div>
					<hr style="color: #F6F6F6; "/>
					       <div class="layui-form-item">
								<label class="layui-form-label" style="width:80px;">合同金额:
								</label>
								<div class="layui-input-inline" style="width:200px;">
									<input type="text"  required name="amount" required
										 autocomplete="off" class="layui-input" placeholder="请填写合同金额"/>
								</div>
							</div> 	
					<hr style="color: #F6F6F6; "/>	
							<div class="layui-form-item">
								<label class="layui-form-label">预产期:
								</label>
								<div class="layui-input-inline" style="width:200px;">
									<input type="text" required name="childBirthday" 
										lay-verify="date" autocomplete="off" class="layui-input" 
										placeholder="输入格式为yyyy-MM-dd"/>
								</div>
							</div>
						</div> 
				 <div class="right layui-col-sm6 layui-col-md7">
				   <div class="layui-form-item" id="title"> 
				      <label class="layui-form-label" style="width:100px;"> 
				                           合同信息<i class="layui-icon layui-icon-list" style="font-size:20px;"></i>
				       </label> 
				     </div> 
					<hr style="color: #F6F6F6; "/>	   
							<div class="layui-form-item">
								<label class="layui-form-label" style="width:120px;">合同生效时间:
								</label> 
								<div class="layui-input-inline" style="width:200px;"> 
									<input type="text"  required name="serviceTime"
										 lay-verify="date" autocomplete="off" class="layui-input" 
										 placeholder="输入格式为yyyy-MM-dd"/>
								</div>
							</div>
					<hr style="color: #F6F6F6; "/>
					       <div class="layui-form-item">
								<label class="layui-form-label" style="width:120px;">合同签订时间:
								</label>
								<div class="layui-input-inline" style="width:176px;">
									<input type="text"  required name="contractTime" style="width:200px;"
										lay-verify="date" autocomplete="off" class="layui-input" 
										placeholder="输入格式为yyyy-MM-dd"/>
								</div>
							</div>	 
				    <hr style="color: #F6F6F6; "/>
							<div class="layui-form-item" style="margin-left:25px">
								<label class="layui-form-label">合同内容:</label> 
								<div class="layui-input-inline">
									<textarea class="layui-textarea" required id="contractInfo"
										name="info" lay-verify="date" autocomplete="off"
										class="layui-input" placeholder="请填写合同内容"></textarea>
								</div> 
								<a id="mould" href="javascript:void(0);" style="position:relative;left:-300px;
								top:40px;color:blue;text-decoration: underline;">导入合同模板</a>
							</div>
				        <div class="layui-form-item" id="login-button" style="margin-top:25px;">
							<div class="layui-input-block button">
								<input type="submit" value="提交" class="layui-btn" id="loginSubmit"/>
								<input type="reset" value="重置" class="layui-btn" id="reset"/>
							</div>
						</div> 
				 </div>
				</form>
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