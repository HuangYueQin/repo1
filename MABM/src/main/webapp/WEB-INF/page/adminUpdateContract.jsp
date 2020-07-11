<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
<title>艾琪母婴-合同签订</title>
<script type="text/javascript" src="./js/jquery/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="./js/laydate/laydate.js"></script>
<script type="text/javascript" src="./js/layui/layui.all.js"></script>
<script type="text/javascript" src="./js/page/signContract.js"></script>
<link rel="stylesheet" href="./css/layui/css/layui.css" />
<link rel="stylesheet" href="./css/page/common.css" />
<link rel="stylesheet" href="./css/page/signContract.css" /> <!-- css类似，不需要单独编写 -->
<link rel="shortcut icon" type="image/x-icon" href="./img/title.ico" />
</head>
<body>
	<div class="container layui-row" style="margin-top:-10px;">
		<div class="content layui-col-xs6 layui-col-sm12 layui-col-md12">
				<form class="layui-form" action="updateContract.do" method="post">
				  <div class=" left layui-card layui-col-xs6 layui-col-sm4 layui-col-md5" style="height:540px;">
				    <div class="layui-form-item" id="title"> 
				      <label class="layui-form-label" style="width:100px;"> 
				                                   基本信息<i class="layui-icon layui-icon-edit"></i>
				       </label>
				     </div> 
				    <hr style="color: #F6F6F6; "/>
						<div class="layui-form-item">
							<label class="layui-form-label">客户名:
							</label>
							<div class="layui-input-inline" style="width:206px;">
								<input type="text" name="customerName" autocomplete="off"
									class="layui-input" value="${contract.customerName}" 
									disabled/>
								<input type="hidden" name="id" value="${contract.id }"/>
							</div> 
						 </div>
					<hr style="color: #F6F6F6; "/>
							<div class="layui-form-item" style="margin-left:-20px;">
								<label class="layui-form-label" style="width:100px;">客户电话:
								</label>
								<div class="layui-input-inline">
									<input type="text" name="customerTel" autocomplete="off"
										class="layui-input" value="${contract.customerTel}"
										 style="width:200px;" lay-verify="required|phone" maxlength="11"
										 onkeyup="value=value.replace(/[^0-9]/g,'')" required/> 
								</div>
							</div>
					<hr style="color: #F6F6F6; "/>	
							<div class="layui-form-item">
								<label class="layui-form-label">选择育婴师:</label>
								<div class="layui-input-inline" style="width:200px;">
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
									<input type="text"  required name="amount"
										 autocomplete="off" class="layui-input" value="${contract.amount }"
										 onkeyup="value=value.replace(/[^.0-9]/g,'')"/>
								</div>
							</div> 	
					     <hr style="color: #F6F6F6; "/>	
							<div class="layui-form-item">
								<label class="layui-form-label">预产期:
								</label>
								<div class="layui-input-inline" style="width:200px;">
									<input type="text" id="time" required name="childBirthday"
										autocomplete="off" class="layui-input" 
										value="${timeMap.childBirthday }"/>
								</div>
							</div>
						</div> 
				 <div class="right layui-col-xs6 layui-col-sm8 layui-col-md7">
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
									<input type="text" id="time" required name="serviceTime"
									    autocomplete="off" class="layui-input" 
										value="${timeMap.serviceTime }"/>
								</div>
							</div>
					<hr style="color: #F6F6F6; "/>
					       <div class="layui-form-item">
								<label class="layui-form-label" style="width:120px;">合同签订时间:
								</label>
								<div class="layui-input-inline" style="width:176px;">
									<input type="text" id="time" required name="contractTime" style="width:200px;"
									    autocomplete="off" class="layui-input" 
										value="${timeMap.contractTime }"/>
								</div>
							</div>	 
				    <hr style="color: #F6F6F6; "/>
							<div class="layui-form-item" style="margin-left:25px;width:300px;">
								<label class="layui-form-label">合同内容:</label> 
								<div class="layui-input-inline">
									<textarea class="layui-textarea" required
										name="info"  autocomplete="off"
										class="layui-input">${contract.info }</textarea>
								</div> 
							</div>
				        <div class="layui-form-item" id="login-button" style="margin-top:25px;margin-right:200px;">
							<div class="layui-input-block button">  
								<input type="submit" value="提交" class="layui-btn" id="loginSubmit"/>
								<input type="reset" value="重置" class="layui-btn" id="reset"/>
							</div>
						</div> 
				 </div>
				</form>
			</div>
		</div>
		
		<script type="text/javascript">
			laydate.render({
				  elem: '#time' //指定元素
			});
			layui.use('form', function(){  //加载layui表单
				  var form = layui.form; //只有执行了这一步，部分表单元素才会自动修饰成功
				  form.render();
			});
		</script>
</body>
</html>