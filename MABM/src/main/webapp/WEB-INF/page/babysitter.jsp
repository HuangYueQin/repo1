<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
<title>艾琪母婴-育婴师信息</title>
<script type="text/javascript" src="../js/jquery/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="../js/laydate/laydate.js"></script>
<script type="text/javascript" src="../js/layui/layui.all.js"></script>
<script type="text/javascript" src="../js/echarts/echarts.min.js"></script>
<link rel="stylesheet" href="../css/layui/css/layui.css" />
<link rel="stylesheet" href="../css/page/common.css" />
<link rel="stylesheet" href="../css/page/babysitter.css" />
<link rel="shortcut icon" type="image/x-icon" href="../img/title.ico" />
</head>
<body>
	<div class="container">
		<div class="content">
			<div class="content-header">
				<span id="title">育婴师: ${babysitter.babysitterName }</span>
			</div>
			<div class="home">
				<a href="../index">返回主页</a>
			</div>
			<hr style="color: #E6E6E6" />
			<div class="content-body" style="width: 100%">
				<div id="photo">
					<span id="pic">
					  <!-- iconUrl在Server的host路径配置 -->
					  <img alt="照片" src="/iconUrl/${babysitter.photoSrc }.jpg" width="108px" height="132px"> 
					</span>
				</div>
				<div id="info">
					<span>育婴师ID: ${babysitter.babysitterId }</span> <span
						class="second">姓名: ${babysitter.babysitterName }</span><br /> <br />
					<span>性别: ${babysitter.sex }</span> <span
						style="margin-left: 123px;">年龄: ${babysitter.age }</span><br /> <br />
					<span>学历: ${babysitter.education }</span> <span
						style="margin-left: 106px;">电话: ${babysitter.telphone }</span><br />
					<br />
					<c:if test="${babysitter.isMarital == 'no'}">
						<span>婚姻状况: 未婚</span>
					</c:if>
					<c:if test="${babysitter.isMarital == 'yes'}">
						<span>婚姻状况: 已婚</span>
					</c:if>
					<c:if test="${babysitter.certificate != 'null'}">
						<span style="margin-left: 72px;">证书:${babysitter.certificate }</span>
						<br />
						<br />
						<br />
					</c:if>
					<c:if test="${babysitter.certificate == 'null'}">
						<span style="margin-left: 72px;">证书:无</span>
						<br />
						<br />
						<br />
					</c:if>


				</div>
				<hr style="color: #E6E6E6" />
				<div class="nextInfo">
					<span>其他信息</span>
				</div>
				<div class="next">
					<span>育婴师等级:${babysitter.level }</span> <span
						style="margin-left: 240px">工作内容:${babysitter.workInfo }</span><br />
					<br /> <br /> <span>工作时间:${time}</span> <span
						style="margin-left: 185px">推荐理由:${babysitter.recomend }</span><br />
					<br /> <br /> <span>星座: ${babysitter.constellation }</span>
					<c:if test="${babysitter.userlist != null}">
						<span style="margin-left: 242px;">服务客户:${babysitter.userlist}</span>
					</c:if>
					<c:if test="${babysitter.userlist == null}">
						<span style="margin-left: 242px;">服务客户:无</span>
					</c:if>
					<br />
					<br />
					<br /> <span>地址:${babysitter.babysitterFrom}</span><br /> <br />
					<br />
				</div>

			</div>
		</div>
	</div>
</body>
</html>