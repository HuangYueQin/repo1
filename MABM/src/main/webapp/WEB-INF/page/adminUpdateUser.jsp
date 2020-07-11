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
<link rel="stylesheet" href="./css/page/updateUser.css" />
<link rel="shortcut icon" type="image/x-icon" href="./img/title.ico" />
</head>
<body>
	<div class="container">
		<div class="content">
		 <form action="updateUser.do" method = "post">
			<div class="content-header">
				<span id="title">用户: ${user.name }</span>
				<input type="hidden" name="name" value="${user.name }"/>
			</div>
			<hr style="color: #E6E6E6" />
			<div class="content-body" style="width: 100%">
				<div id="photo">
					<span id="pic">照片</span>
				</div>
				<div id="info">
					<span>育婴师ID: ${user.userId }</span> <span
						class="second">姓名: ${user.name }</span><br /> <br />
					<span>性别: ${user.sex }</span> <span
						style="margin-left: 185px;">出生年月: ${timeMap.birthday }</span><br /> <br />
					 <span>电话: <input name="telphone" value="${user.telphone }" maxlength="11"
						onkeyup="value=value.replace(/[^0-9]/g,'')"/></span>
					 <span style="margin-left: 64px;">预产期: 
					 <input type = "text" name="childbirthDate" value="${timeMap.childbirthDate }" id="time"/></span>
					<br />
				</div>
				<hr style="color: #E6E6E6" />
				<div class="nextInfo">
					<span>需求信息</span>
				</div>
				<div class="next">
					<span>需求日期:<input name="requestDate" type = "text" value="${timeMap.requestDate}" id="time"/></span>
				    <span style="margin-left:60px;">需求信息:
				       <input name="requestInfo" type = "text" value="${user.requestInfo}" style="width:200px;"/></span><br />
					<br /> <br /> 
					<span>服务的育婴师:
						<c:forEach var="babysitter" items ="${user.babysitterlist }">
							<c:if test="${babysitter != null}">
								<input style="width:200px;" name="babysitterName" type = "text" value="${babysitter.babysitterName}"/>
								<span style="color:#169D8B;">多个育婴师之间用逗号(,)隔开</span>
							</c:if>
						</c:forEach>
						<c:if test="${empty user.babysitterlist}">
								<input style="width:200px;" name="babysitterName" type = "text" value="无"/>
								<span style="color:red;font-size: 15px; margin-left: 10px;">*多个育婴师之间用逗号(,)隔开</span>
						</c:if>
					</span>
					<br />
					<br />
					<br /> <span>地址:<input id="textarea" name = "userFrom" type = "text" value="${user.userFrom}"/></span><br /> <br />
					<br />
				</div>
              <div class="layui-form-item">
			    <div class="layui-input-block" id="formbutton">
			      <button class="layui-btn" lay-submit lay-filter="formDemo">提交更改</button>
			      <button type="reset" class="layui-btn" id="reset">重置</button>
			   </div>
			</div>
		  </div>
		  </form>
		</div>
	</div>
	<script type="text/javascript">
		laydate.render({
			elem : '#time' // 指定元素
		});
	</script>
</body>
</html>