<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
<title>艾琪母婴-选择育婴师</title> 
<script type="text/javascript" src="../js/jquery/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="../js/layui/layui.all.js"></script>
<script type="text/javascript" src="../js/page/chooseBabysitter.js"></script>
<link rel="stylesheet" href="../css/layui/css/layui.css" />
<link rel="stylesheet" href="../css/page/common.css" />
<link rel="stylesheet" href="../css/page/chooseBabysitter.css" />
<link rel="shortcut icon" type="image/x-icon" href="../img/title.ico"/>
</head>
<body>
  <div class="container layui-row">
	<div class="header layui-col-xs6 layui-col-sm6 layui-col-md12">
			  <div class="header-logo">
				<a href="javascript:;"><img alt="logo图" src="../img/logo.png"></a>
			  </div>
			<div class="header-title">
				<span class="header-title-text">艾琪母婴</span><br/> 
				<span class="header-title-text-english">MABM.COM</span>  
				 <span class="header-title-english">AiQi Maternal And Child Manage System</span>
			</div>
			<div class = "return">
			  <i class="layui-icon layui-icon-home"></i><a href = "../index.do">返回主页</a>
			</div>
	   </div>
	 <div class="content layui-col-xs6 layui-col-sm6 layui-col-md12" >
	    <div class="left" style="float:left">
	        <img src="../img/selectBabysitter.jpg" style="margin-top:16px;"/>
	        <div class="left-bottom layui-card"> 
	              <div class="layui-card-header">育婴师</div>
		          <div class="layui-card-body">
		           <p style="text-indent:2em;">育婴师是用现代教育观念和科学方法对0-3岁婴儿进行生活照料、护理和教育的专业人员。主要从事0-3岁婴儿照料、护理和教育工作。</p>
		           </div>
	        </div> 
	    </div>
	    <div class="right layui-col-xs6 layui-col-sm6 layui-col-md8"> 
	      <table class="layui-table" id="layui_table_id" lay-filter="test"></table>
           <div id="laypage"></div>
			 <script type="text/html" id="barDemo"> 
 				<a class="layui-btn layui-bg-green layui-btn-sm" lay-event="choose">预约</a>
	         </script>
	    </div>
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