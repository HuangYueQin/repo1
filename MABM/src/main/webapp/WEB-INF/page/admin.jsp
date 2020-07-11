<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>艾琪母婴-后台管理</title>
<script type="text/javascript" src="./js/jquery/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="./js/laydate/laydate.js"></script>
<script type="text/javascript" src="./js/layui/layui.all.js"></script>
<script type="text/javascript" src="./js/page/admins.js"></script> <!-- 服务合同，服务资源，用户 -->
<script type="text/javascript" src="./js/page/admin.js"></script>  <!-- 评价记录，回访记录 -->
<link rel="stylesheet" href="./css/layui/css/layui.css" />
<link rel="stylesheet" href="./css/page/common.css" /> 
<link rel="stylesheet" href="./css/page/admin.css" />
<link rel="shortcut icon" type="image/x-icon" href="./img/title.ico"/>
<style>
    body{margin: 10px;}
    .demo-carousel{height: 200px; line-height: 200px; text-align: center;}
  </style>
</head>
  <div class="container layui-row">
	<div class="header layui-col-xs6 layui-col-sm6 layui-col-md4">
	    <div class="header-logo">
				<a href="javascript:;"><img alt="logo图" src="./img/logo.png"></a>
			</div>
			<div class="header-title">
				<span class="header-title-text">艾琪母婴服务后台管理</span> 
				<span class="header-title-english">AiQi Maternal and child backstage manager</span>
			</div>
			<div class="header-admin">
				<ul class="layui-nav layui-bg">
					<li class="layui-nav-item">
					  <a href="javascript:;">
					    <i class="layui-icon layui-icon-username"></i> Welcome
					      <%= session.getAttribute("adminName") %></a></li>
					<li class="layui-nav-item"><a href="index"><i class="layui-icon layui-icon-home"></i>Home</a></li> 
				</ul>
			</div>
		</div>
		<!-- a标签事件交给admin.js去处理 -->
	  <div class="nav layui-col-xs6 layui-col-sm6 layui-col-md3">
	    <div class="layui-card" style="border-radius:3px;margin-top:5px">
	      <div class="layui-card-header" style="background-color:#97BCD9;">用户管理</div>
	      <div class="layui-card-body">
	          <ul>
	              <li><a href="javascript:;" id="selectUser">查询用户</a></li>
	              <li><a href="javascript:;" id="displayUser">管理用户信息</a></li>
	          </ul>
	      </div>
	      <div class="layui-card-header" style="background-color:#97BCD9;">服务资源管理</div>
	      <div class="layui-card-body">
	          <ul>
	              <li><a href="javascript:;" id="selectBabysitter">查询育婴师</a></li>
	              <li><a href="javascript:;" id="addBabysitter">添加育婴师</a></li>
	              <li><a href="javascript:;" id="updateBabysitter">更新育婴师信息</a></li>
	              <li><a href="javascript:;" id="deleteBabysitter">删除育婴师</a></li>
	          </ul>
	      </div>
	      <div class="layui-card-header" style="background-color:#97BCD9;">合同管理</div>
	      <div class="layui-card-body">
	          <ul>
	              <li><a href="javascript:;" id="selectContract">查询合同</a></li>
	              <li><a href="javascript:;" id="displayContract">管理合同信息</a></li>
	          </ul>
	      </div>
	       <div class="layui-card-header" style="background-color:#97BCD9;">服务过程管理</div>
	      <div class="layui-card-body">
	          <ul>
	              <li><a href="javascript:;" id="displayInterview">管理回访记录</a></li>
	              <li><a href="javascript:;" id="displayApprise">管理用户评价</a></li>
	          </ul>
	      </div>
	    </div>
	  </div>
	  <div class="content layui-col-xs6 layui-col-sm6 layui-col-md9" id="content">    
	       <fieldset class="layui-elem-field layui-field-title" style="margin-top:30px;;margin-bottom:10px;">
			  <legend id="topTitle" style="color:gray"></legend>  <!-- 有面板标头名称 -->
			</fieldset>
           <table class="layui-table" id="layui_table_id" lay-filter="test"></table>
           <div id="laypage"></div>
             <!-- 用户管理、合同管理操作键位 -->
			 <script type="text/html" id="barDemo">
                <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
                <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
                <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
	         </script>
	          <!-- 评价记录、回访记录键位操作键位 -->
	         <script type="text/html" id="barDemo2">
                <a class="layui-btn layui-btn-primary layui-btn-xs"  lay-event="detailInfo">查看</a>
                <a class="layui-btn layui-btn-xs" lay-event="editItem">编辑</a>
                <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="delItem">删除</a>
	         </script>
	         <img src="./img/adminBaby.jpg"/>
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