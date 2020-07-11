<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
<title>艾琪母婴-更改评价记录</title>
<script type="text/javascript" src="./js/jquery/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="./js/laydate/laydate.js"></script>
<script type="text/javascript" src="./js/layui/layui.all.js"></script>
<link rel="stylesheet" href="./css/layui/css/layui.css" />
<link rel="stylesheet" href="./css/page/common.css" />
<link rel="stylesheet" href="./css/page/register.css" />  <!-- 更新评价记录css与注册用户css类似，不在独立编写 -->
<link rel="shortcut icon" type="image/x-icon" href="./img/title.ico" />
</head>
<body>
	<div class="container layui-row" style="width:450px;">
	  <div class="content" style="width:430px;margin-left:10px;">
		<form class="layui-form" action="updateApprise.do" method="post" style="margin-top:20px;">
			<div class="layui-form-item">
				<label class="layui-form-label">
				   <i class="layui-icon layui-icon-username"></i> 用户:  
				</label>
				<div class="layui-input-inline" style="width:265px;"> 
					<input type="text"  required lay-verify="required" style="background-color:#EBEBE4;"
						value="${apprise.userName }" autocomplete="off" class="layui-input" disabled>
					<input type="hidden" name="id" value="${apprise.id}" /> <!-- 保存评价记录id，表单发送回id -->
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">
				  <i class="layui-icon layui-icon-user"></i> 育婴师:
				</label>
				<div class="layui-input-inline" style="width:265px;">
					<input type="text"  required lay-verify="required" style="background-color:#EBEBE4;"
					value="${apprise.babysitterName }" autocomplete="off" class="layui-input" disabled>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">
				  <i class="layui-icon layui-icon-date"></i> 评价时间:
				</label>
				<div class="layui-input-inline" style="width:265px;">
					<input type="text"  required lay-verify="required"  placeholder="输入格式为yyyy-MM-dd"
					autocomplete="off" class="layui-input" name="appriseTime"/>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">
				  <i class="layui-icon layui-icon-edit"></i> 评价标题:
				</label>
				<div class="layui-input-inline" style="width:265px;">
					<input type="text"  required lay-verify="required"  placeholder="请输入评价标题"
					autocomplete="off" class="layui-input" name="appriseInfo"/>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">
				  <i class="layui-icon layui-icon-diamond"></i> 星级评价:
				</label>
				<div class="layui-input-inline" style="width:360px;height:0px;">
					<div class="layui-input-block" style="position:relative;top: -40px;">
						<div id="score"></div>
						<input type="hidden" name="appriseScore" />
					</div>
				</div>
			</div>
			<div class="layui-form-item layui-form-text">
			    <label class="layui-form-label">
			      <i class="layui-icon layui-icon-praise"></i> 评价建议:
			    </label>
			    <div class="layui-input-block" style="position:relative;top:-30px;">
			      <textarea placeholder="请输入评价与建议" class="layui-textarea" name="appriseRecommend"></textarea>
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
    layui.use(['rate'], function(){  //加载layui评分插件
  	  var rate = layui.rate;
  	  rate.render({
  	    elem: '#score'
  	    ,theme: '#009688'
  	    ,value: 3
  	    ,text: true
  	    ,setText: function(value){ //自定义文本的回调
  	      var arrs = {
  	        '1': '极差'
  	        ,'2': '差'
  	        ,'3': '一般'
  	        ,'4': '好'
  	        ,'5': '极好'
  	      };
  	      this.span.text(arrs[value] || ( value + "星"));
  	      $("input[name='appriseScore']").attr("value",value);    //将评分填写入input hidden框，供提交表单用
  	                                                              //注意不是html(),html是添加html的文本，而是attr()的属性
  	    }
  	  });
  	});
 </script>
 </body>
</html>