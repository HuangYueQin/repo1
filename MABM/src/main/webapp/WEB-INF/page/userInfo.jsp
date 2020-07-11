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
<script type="text/javascript" src="./js/jquery/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="./js/laydate/laydate.js"></script>
<script type="text/javascript" src="./js/layui/layui.all.js"></script>
<script type="text/javascript" src="./js/echarts/echarts.min.js"></script>
<link rel="stylesheet" href="./css/layui/css/layui.css" />
<link rel="stylesheet" href="./css/page/common.css" />
<link rel="stylesheet" href="./css/page/userInfo.css" />
<link rel="shortcut icon" type="image/x-icon" href="./img/title.ico" />
</head>
<body>
	<div class="container">
		<div class="content">
			<div class="content-header">
				<span id="title">用户: ${user.name }</span>
			</div>
			<hr style="color: #E6E6E6" />
			<div class="content-body" style="width: 100%">
				<div id="photo">
					<span id="pic">
					  <!-- iconUrl在Server的host路径配置 -->
					  <img alt="照片" src="/iconUrl/${map.picSrc }.jpg" width="108px" height="132px"> 
					</span>
				</div>
				<div id="info">
					<span>育婴师ID: ${user.userId }</span> <span
						class="second">姓名: ${user.name }</span><br /> <br />
					<span>性别: ${user.sex }</span> <span
						style="margin-left: 123px;">出生年月: ${map.birthday }</span><br /> <br />
					 <span>电话: ${user.telphone }</span>
					 <span style="margin-left: 64px;">预产期: ${map.childbirthDate }</span>
					<br />
				</div>
				<hr style="color: #E6E6E6" />
				<div class="nextInfo">
					<span>需求信息</span>
				</div>
				<div class="next">
					<span>需求日期:${map.requestDate}</span>
				    <span style="margin-left:60px;">需求信息:${user.requestInfo}</span><br />
					<br /> <br /> 
					<span>服务的育婴师:
						<c:forEach var="babysitter" items ="${user.babysitterlist }">
							<c:if test="${babysitter != null}">
								${babysitter.babysitterName},
							</c:if>
						</c:forEach>
						<c:if test="${empty user.babysitterlist}">
								无
						</c:if>
					</span>
					<br />
					<br />
					<br /> <span>地址:${user.userFrom}</span><br /> <br />
					<br />
				</div>

			</div>
		</div>
	</div>
</body>
</html>