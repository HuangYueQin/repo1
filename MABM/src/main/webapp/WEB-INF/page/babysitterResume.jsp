<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
<title>艾琪母婴-育婴师简历</title>
<script type="text/javascript" src="../js/jquery/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="../js/laydate/laydate.js"></script>
<script type="text/javascript" src="../js/layui/layui.all.js"></script>
<script type="text/javascript" src="../js/page/babysitterResume.js"></script>
<link rel="stylesheet" href="../css/layui/css/layui.css" />
<link rel="stylesheet" href="../css/page/common.css" />
<link rel="stylesheet" href="../css/page/babysitterResume.css" />
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
	    <div class="content layui-col-xs6 layui-col-sm6 layui-col-md12">
		      <div class="left" style="float:left">
		        <img src="../img/selectBabysitter.jpg" style="margin-top:16px;"/>
		        <div class="left-bottom layui-card"> 
		              <div class="layui-card-header">育婴师</div>
			          <div class="layui-card-body">
			           <p style="text-indent:2em;">育婴师是用现代教育观念和科学方法对0-3岁婴儿进行生活照料、护理和教育的专业人员。主要从事0-3岁婴儿照料、护理和教育工作。</p>
			           </div>
		        </div> 
		      </div>
	     <div class="right">
          <table border="1px" cellpadding="0" cellspacing="0"> 
			<tr>
				<td colspan="8" class="title" style="font-style:italic;">育婴师简历</td>
			</tr>
			<tr class="left">
				<td colspan="8" style="text-indent:2em;">基本信息: ${babysitter.babysitterName} 简历</td>
			</tr>
			<tr>
				<td>姓&nbsp;名</td>
				<td>${babysitter.babysitterName}</td>
				<td>电&nbsp;话</td>
				<td>${babysitter.telphone}</td>
				<td>年&nbsp;龄</td>
				<td>${babysitter.age}</td>
				<td colspan="2" rowspan="3">
				  <span id="pic">
					  <!-- iconUrl在Server的host路径配置 -->
					  <img alt="照片" src="/iconUrl/${babysitter.photoSrc }.jpg" width="110px" height="130px"> 
					</span>
				</td>
			</tr>
			<tr>
			    <td>育婴师Id</td>
			    <td>${babysitter.babysitterId}</td>
				<td>学&nbsp;历</td>
				<td>${babysitter.education}</td>
				<td>婚姻状况</td>
				<c:if test="${babysitter.isMarital == 'no'}">
				   <td>未婚</td>
				</c:if> 
				<c:if test="${babysitter.isMarital == 'yes'}">
				   <td>已婚</td>
				</c:if>
			</tr>
			<tr>
			    <td>性&nbsp;别</td>
			    <td>${babysitter.sex}</td>
				<td>工作时间</td>
				<td>${time}</td>
				<td>星&nbsp;座</td>
				<td>${babysitter.constellation}</td>
			</tr>
			<tr>
				<td>推荐理由</td>
				<td colspan="4">${babysitter.recomend}</td>
				<td>等&nbsp;级</td>
				<td>${babysitter.level}</td>	
			</tr>
			<tr>
			    <td>证&nbsp;书</td>
				<c:if test="${babysitter.certificate != 'null'}">
				  <td td colspan="6">${babysitter.certificate}</td>
				</c:if>
				<c:if test="${babysitter.certificate == 'null'}">
				  <td td colspan="6">无</td>
			   </c:if>
			</tr>
			<tr>
			    <td>工作内容</td>
				<td td colspan="6">${babysitter.workInfo}</td>
			</tr>
			<tr>
			  <td>客&nbsp;户</td>
			  <td td colspan="6">${babysitter.userlist}</td>
			</tr>
			<tr>
				<td>住&nbsp;址</td>
				<td colspan="6">${babysitter.babysitterFrom}</td>
			</tr>
		</table>
	   </div>
	  </div>
	  <div class="content-right-button">
	      <form action="toBabysitterResume.do" method="post">
		    <button class="layui-btn" type="submit" name="Resume" value="1">上一个</button>
	        <button class="layui-btn" type="submit" name="Resume" value="2">下一个</button>
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