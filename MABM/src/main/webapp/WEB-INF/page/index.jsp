<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
<title>艾琪母婴-母婴服务类的数据管理平台</title> 
<script type="text/javascript" src="./js/jquery/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="./js/laydate/laydate.js"></script>
<script type="text/javascript" src="./js/layui/layui.all.js"></script>
<script type="text/javascript" src="./js/echarts/echarts.min.js"></script>
<script type="text/javascript" src="./js/page/indexs.js"></script>
<link rel="stylesheet" href="./css/layui/css/layui.css" />
<link rel="stylesheet" href="./css/page/common.css" />
<link rel="stylesheet" href="./css/page/index.css" />
<link rel="shortcut icon" type="image/x-icon" href="./img/title.ico"/>
<%! boolean isLogin= false;%>
</head>
<body>
	<div class="container layui-row">
		<div class="header">
			<div class="header-logo">
				<a href="javascript:;"><img alt="logo图" src="./img/logo.png"></a>
			</div>
			<div class="header-title">
				<span class="header-title-text">艾琪母婴服务管理系统</span> <span
					class="header-title-english">AiQi Maternal and child manager</span>
			</div>
			<div class="header-user"> 
				<ul class="layui-nav layui-bg">
				  <%
		            if(request.getParameter("isLogin")!=null){
		            	isLogin = Boolean.parseBoolean(request.getParameter("isLogin"));
		            }
		            if(!isLogin){
		             out.print("<li class='layui-nav-item'><a href='login'><i class='layui-icon layui-icon-username'></i> Login in</a></li>");
		            }else{
		            	out.print("<li class='layui-nav-item'><a href='javascript:;'><i class='layui-icon layui-icon-username'></i> "+session.getAttribute("LoginName")+"</a></li>");
		            }
		         %>
					<li class="layui-nav-item"><a href="register"><i class="layui-icon layui-icon-form"></i> Register</a></li>
					<li class="layui-nav-item"><a href="toAdmin"><i class="layui-icon layui-icon-set"></i> To admin</a></li>
					<li class="layui-nav-item"><a href="exit.do"><i class="layui-icon layui-icon-delete" style="font-size:15px"></i> Exit</a></li> 
				</ul>
			</div> 
		</div> 
		<div class="nav layui-col-xs3 layui-col-sm3 layui-col-md3">
			<div>
				<form id="form-user-search" id="searchForm" method="post" action="index/selectBabysitter.do">
					<input type="text" placeholder="搜索育婴师" name="name" value="" class="layui-input" style="width: 86%; float: left;" /> 
					 <button type = "submit" class="layui-btn layui-btn-primary" style="padding:0;"> 
					   <i class="layui-icon layui-icon-search" style="float: left; font-size: 30px; margin-left: 2px;"></i>
					 </button>
				</form>
			</div>
			<ul class="layui-nav layui-nav-tree layui-bg layui-inline" lay-filter="demo" style="width: 98%; margin-top: 3px;">
				<li class="layui-nav-item layui-nav-itemed">
				  <a href="javascript:;">服务资源</a>
				  <dl class="layui-nav-child">
						<dd>
							<a href="index/chooseBabysitter.do">预约育婴师</a>
						</dd>
						<dd>
							<a href="index/toBabysitterArrange.do">育婴师安排情况</a>
						</dd>
						<dd>
							<a href="index/toBabysitterResume.do?Resume=1">育婴师简历</a>
						</dd>
				  </dl>
				</li>
				<li class="layui-nav-item layui-nav-itemed">
				  <a href="javascript:;">服务过程</a> 
					<dl class="layui-nav-child">
						<dd>
							<a href="index/toUserInterview.do">回访记录</a>
						</dd>
						<dd>
							<a href="index/toUserApprise.do">用户评价</a>
						</dd>
					</dl>
				</li>
				<li class="layui-nav-item layui-nav-itemed">
				   <a href="javascript:;">服务合同</a> 
				   <dl class="layui-nav-child">
						<dd>
							<a href="index/toSignContract.do">签订合同</a>
						</dd>
						<dd>
							<a href="index/toViewContract.do">查看合同</a>
						</dd>
					</dl>
				</li>
			</ul> 
			<div id="timeSheets" style="float:left;width:98%;height:295px;margin-top:3px;border:1px solid #F0F0F0;">
			   <input type="text" id="time" class="layui-input" placeholder="点击查看并选择当前时间" style="width: 85%; float: left;"/>
			   <a href="javascript:;"> 
			    <i class="layui-icon layui-icon-date" style="float: left; font-size: 35px; margin-left: 2px;"></i>
			   </a><br/><br/>
			   <hr class="layui-bg" style="color:#486483;">
			   <div class="project-introduce">
			     <p style="text-indent:2em;">
			                      继二胎政策的全面开放，越来越多的80、90后成为新一代母婴行业的消费主力军，“母婴家庭”规模进一步扩大，“人口红利”作为一大机遇，推动母婴行业进入高速发展期。<br/>
                   &nbsp;&nbsp;成都艾琪母婴服务管理系统作为母婴服务平台的管理平台，通过这个平台可以高效率、人性化、多元化地为客户解决母婴服务过程中产生的相关问题。同时注重线上+线下互动和提供按需服务，做到整合体系，并最终实现一个母婴服务类的数据管理平台。
			     </p>
			   </div>
			</div> 
		</div>
		<div class="content layui-col-xs9 layui-col-sm9 layui-col-md9">
			<div class="content-center" style="height:300px;width:70%;float:left;">
				<div class="layui-carousel" id="carouse"> 
					<div carousel-item>
						<img alt="" src="./img/baby1.jpg"> 
						<img alt="" src="./img/baby3.jpg"> 
						<img alt="" src="./img/baby5.jpg">
						<img alt="" src="./img/baby4.jpg"> 
						<img alt="" src="./img/baby2.jpg">
					</div>
				</div>
				<div class="content-bottom" id="report-chart" ></div> 
			 </div>
				<div class="content-right layui-card">
					<div class="layui-card-header">母婴服务行业"红利"</div> 
					<div class="layui-card-body">
						<ul class="layui-timeline">
						   <li class="layui-timeline-item">
							    <i class="layui-icon layui-timeline-axis">&#xe63f;</i>
								<div class="layui-timeline-content layui-text">
									<h3 class="layui-timeline-title">2015年10月</h3>
									<p style="text-indent:2em;">
										中国共产党第十八届中央委员会第五次全体会议公报指出：坚持计划生育基本国策，积极开展应对人口老龄化行动，实施全面二孩政策。
									</p>
									<ul>
										<li>《人口与计划生育法》</li>
										<li>《中华人民共和国宪法》</li>
									</ul>
								</div></li>
							<li class="layui-timeline-item">
							    <i class="layui-icon layui-timeline-axis">&#xe63f;</i>
								<div class="layui-timeline-content layui-text">
									<h3 class="layui-timeline-title">2016年7月</h3>
									<p style="text-indent:2em;">
									            开启 O2O新零售销售模式,母婴电商产业在资本市场颇为活跃，育儿网、妈妈网分别在香港和新三板挂牌上市。
									    <br>&nbsp;&nbsp;这一阶段，母婴电商产业市场格局基本确定，商业模式趋于成熟。
									    <i class="layui-icon layui-icon-face-smile smile"></i> 
									</p>
								</div>
							 </li>
							
							<li class="layui-timeline-item"><i
								class="layui-icon layui-timeline-axis">&#xe63f;</i>
								<div class="layui-timeline-content layui-text">
									<h3 class="layui-timeline-title">2017年7月</h3>
									<p style="text-indent:2em;">
										中国网购消费能力最强的群体正在从“她经济”升级到“妈妈经济”，人口红利、消费升级的需求势不可当。
										<br>&nbsp;&nbsp;“妈妈经济”将为移动购物的爆发带来新契机，势必成为电商争夺的新战场。<br>
									</p>
								</div>
							</li>
							<li class="layui-timeline-item">
							<i class="layui-icon layui-timeline-axis">&#xe63f;</i>
								<div class="layui-timeline-content layui-text">
									<div class="layui-timeline-title">将来</div> 
								</div></li>
						</ul>
					</div>
				</div>
			</div>
			<script type="text/javascript">
		        // 基于准备好的dom，初始化echarts实例
		     $(function() {  
		         var myChart = echarts.init(document.getElementById('report-chart'));
		        // 指定图表的配置项和数据
		        var option = {
		            title: {
		                text: '我国新出生人口数量与出生率'
		            },
		            tooltip: {},
		            legend: {
		                data:[{name:'数量'},{name:'出生率',}],
		            },
		            xAxis: {
		                data: [2010,2011,2012,2013,2014,2015,2016,2017,2018]
		            },
		            yAxis: [{
		            	    min:1500,
		            	    max:1900,
			            	type:'value',
			            	data: [1500,1550,1600,1650,1700,1750,1800,1850]
			            },
			            {
			            	min:11.2,
			            	max:13.2,
			            	type:'value', 
			            	splitNumber:11,//右边y轴切割11段
			            	data: [11.2,11.4,11.6,11.8,12.0,12.2,12.4,12.6,12.8,13.0,13.2]
			            }
		            ],
		            color:['#486483'], //图形颜色
		            series: [{
		                name: '数量',
		                type: 'bar',//柱状图
		                data: [1596,1604,1635,1640,1687,1655,1786,1723,1825],
		            },
		            {
		            	name :'出生率',
		            	type:'line',//折线图
		            	yAxisIndex:1,
		            	color:['#486483'],
		            	data: [11.9,12.0,12.1,12.0,12.4,12.0,13.0,12.5,13.1],
		            }
		           ]
		        };
		        // 使用刚指定的配置项和数据显示图表。
		        myChart.setOption(option);
		     });
		    </script>
		   <div class="footer layui-col-xs6 layui-col-sm6 layui-col-md12">
			<p>
				© 2019 <a href="javascript:;"> MABM.com</a> MIT license
			</p>
			<p>Copyright & 2019.4.11,HuangYueQin, All Rights Reserved</p>
		  </div>
    </div>
	<script type="text/javascript" src="./js/layui/layui.all.js"></script>
	<script>
		layui.use('element', function() {
			var element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块
		});
		layui.use('carousel', function() {
			var carousel = layui.carousel;
			//建造实例
			carousel.render({
				elem : '#carouse',
				width : '98%' //设置容器宽度
				,height : '350px',
				arrow : 'always' //始终显示箭头
			//,anim: 'updown' //切换动画方式
			});
		});
		laydate.render({
			  elem: '#time' //指定元素
		});
	</script>
</body>
</html>