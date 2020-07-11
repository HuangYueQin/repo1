/**
 * time : 2019.5.17
 * author:huang yue qin
 * function: interview and user apprise manage.
 */
$(document).ready(function(){
	
	var limitcount = 10;     //分页变量
    var curnum = 0;         //当前下标
    var total = 0;          //总记录数
    
	function getInterviewListCount(){   
		
		$("#topTitle").html("<i class='layui-icon layui-icon-set'></i>用户回访记录管理-User Interview Record Management "+
		"<i class='layui-icon layui-icon-down' style='font-size:20px;'></i>");//右面板标头
		 $.post({
		    	url:'getInterviewListCount.do',
		    	method:'post',
		    	async:false,                      //异步处理为false，即是同步处理，因为要先获取记录总数，供分页函数使用
		    	success:function(data){
		    		total = data;
		    	}
		    });
	}
	
    function getAppriseListCount(){
		
    	$("#topTitle").html("<i class='layui-icon layui-icon-set'></i>用户评价记录管理-User Apprise Record Management "+
		"<i class='layui-icon layui-icon-down' style='font-size:20px;'></i>");//右面板标头
    	 $.post({
		    	url:'getAppriseListCount.do',
		    	method:'post',
		    	async:false,                      //异步处理为false，即是同步处理，因为要先获取记录总数，供分页函数使用
		    	success:function(data){
		    		total = data;
		    	}
		    });
	}
	/*回访记录*/
	$("#displayInterview").click(function(){
		
		getInterviewListCount();   //获取总记录数
		var pId = '${pGBean.pgId }';
		productInterviewSearch(pId, curnum, limitcount,total);
		
	});
	
	/*用户评价*/
    $("#displayApprise").click(function(){
    	getAppriseListCount();   //获取总记录数
		var pId = '${pGBean.pgId }';
		productAppriseSearch(pId, curnum, limitcount,total);
	}); 
    
    /*采访记录分页函数*/
    function productInterviewSearch(productGroupId,start,limitsize,total){  
    	layui.use(['table','laypage'], function(){
            var table = layui.table,
                laypage = layui.laypage;
            table.render({
                elem: '#layui_table_id'
                , url: 'interviewlist.do'
                , cols: [[
                    {field: 'id', title: 'ID', width:50}
                    , {field: 'username', title: '用户名',width:110}
                    , {field: 'recepteName', title: '接待人员',width:110}
                    , {field: 'interviewClassify', title: '回访方式',width:90}
                    , {field: 'interviewAddress', title: '回访地址', fixed: 'right',width:130}
                    , {field: 'interviewDate', title: '回访时间',width:100}
                    , {field: 'interviewInfo', title: '沟通内容',width:120}
                    ,{fixed: 'right', align:'center', title: '操作',toolbar: '#barDemo2',width:160}
                ]]
                , page: true
                , even: true
                , width: 880
                , height: 480
                ,limits: [5, 10, 15] //显示
                ,limit: 10 //每页默认显示的数量
                ,request: {
                    pageName: 'pageNo', //页码的参数名称，默认：page
                    limitName: 'pageSize' //每页数据量的参数名，默认：limit
                },
                
                parseData:function(res){
                	console.log(res);
                	return{
                		"code": 0,
                		"msg": "",
                		"count": total,
                		 data :res,
                	}
                }
            });
            table.on('tool(test)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
                var data = obj.data //获得当前行数据
                    ,layEvent = obj.event; //获得 lay-event 对应的值
                if(layEvent === 'detailInfo'){
                	layui.use('layer',function(){
                		var layer = layui.layer;
                		layer.open({
                			skin : 'layui-layer-molv' //背景样式
                			,type :1                  //type为1表示嵌入文本，2表示嵌入iframe
                			,closeBtn :1      //是否显示关闭按钮
                			,anim:1          //动画
                			,title:'回访记录信息如下'
                			,btn :['关闭窗口']
                		    ,icon:6         //微笑图标
                		    ,area:["500px","450px"]  
                		    ,content:"<div style='margin-top:15px;margin-left:15px;'>" +
                		            "<h3 style='color:#009F95'>1.基本信息 <i class='layui-icon layui-icon-file-b'></i>:</h3>"+
                		            "<hr style= 'color: #F6F6F6;width:95%'/>"+
                		    		"<p style='font-size:16px;line-height:30px;margin-left: 10px;'>" +
                		    		"<i class='layui-icon layui-icon-username'></i> 用户名："+data.username+"<br/>"+
                		    		"<i class='layui-icon layui-icon-user'></i> 接待人员："+data.recepteName+"</p>" +
                		    		"<hr style= 'color: #F6F6F6;width:95%'/>"+
                		    		"<h3 style='color:#009F95'>2.回访信息 <i class='layui-icon layui-icon-file-b'></i>:</h3>"+
                		    		"<hr style= 'color: #F6F6F6;;width:95%'/>"+
                		    		"<p style='font-size:16px;line-height:30px;margin-left: 10px;'>" +
                		    		"<i class='layui-icon layui-icon-cellphone-fine'></i> 回访方式 ："+data.interviewClassify+"<br/>"+
                		    		"<i class='layui-icon layui-icon-date'></i> 回访日期："+data.interviewDate+"<br/>"+
                		    		"<i class='layui-icon layui-icon-home'></i> 回访地址："+data.interviewAddress+ 
                		    		"<hr style='color: #F6F6F6;;width:95%'/>" +
                		    		"<h3 style='color:#009F95'>3.沟通内容 <i class='layui-icon layui-icon-file-b'></i>:</h3>"+
                		    		"<hr style= 'color: #F6F6F6;;width:95%'/>"+
                		    		"<p style='font-size:16px;line-height:30px;margin-left:10px;'>"+
                		    		"<i class='layui-icon layui-icon-form'></i> "+data.interviewInfo+"</p>"+
                		    	    "</div>" 
                		});
                });
               }else if(layEvent === 'delItem'){
            	   layer.confirm('真的删除吗？',{skin:'layui-layer-molv'},function(index){
                   	$.ajax('deleteInterview.do?interviewId='+data.id);
                   	layer.msg("删除成功！");
                   	layer.close(index);
                   })
               }else{
            	   layui.use('layer',function(){
               		var layer = layui.layer;
               		layer.open({
               			skin : 'layui-layer-molv' //背景样式
               			,type :2                  //type为1表示嵌入文本，2表示嵌入iframe
               			,closeBtn :1      //是否显示关闭按钮
               			,anim:1          //动画
               			,title:'更新回访记录'
               		    ,icon:6         //微笑图标
               		    ,area:["500px","450px"] 
               		    ,content:"toUpdateInterview.do?interviewId="+data.id
               		});
            	  });
               }
            });
      });
    }
    /*评价记录分页函数*/
    function productAppriseSearch(productGroupId,start,limitsize,total){
    	layui.use(['table','laypage'], function(){
            var table = layui.table,
                laypage = layui.laypage;
            table.render({
                elem: '#layui_table_id'
                , url: 'appriselist.do'
                , cols: [[
                    {field: 'id', title: 'ID', width:50}
                    , {field: 'userName', title: '用户名',width:110}
                    , {field: 'babysitterName', title: '育婴师',width:110}
                    , {field: 'appriseInfo', title: '评价内容',width:155}
                    , {field: 'appriseScore', title: '评分', fixed: 'right',width:65}
                    , {field: 'appriseTime', title: '评价时间',width:100}
                    , {field: 'appriseRecommend', title: '评价与建议',width:120}
                    ,{fixed: 'right', align:'center', title: '操作',toolbar: '#barDemo2',width:160}
                ]]
                , page: true
                , even: true
                , width: 880
                , height: 480
                ,limits: [5, 10, 15] //显示
                ,limit: 10 //每页默认显示的数量
                ,request: {
                    pageName: 'pageNo', //页码的参数名称，默认：page
                    limitName: 'pageSize' //每页数据量的参数名，默认：limit
                },
                
                parseData:function(res){
                	console.log(res);
                	return{
                		"code": 0,
                		"msg": "",
                		"count": total,
                		 data :res,
                	}
                }
            });
            table.on('tool(test)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
                var data = obj.data //获得当前行数据
                    ,layEvent = obj.event; //获得 lay-event 对应的值
                if(layEvent === 'detailInfo'){
                	layui.use('layer',function(){
                		var layer = layui.layer;
                		layer.open({
                			skin : 'layui-layer-molv' //背景样式
                			,type :1                  //type为1表示嵌入文本，2表示嵌入iframe
                			,closeBtn :1      //是否显示关闭按钮
                			,anim:1          //动画
                			,title:'评价记录信息如下'
                			,btn :['关闭窗口']
                		    ,icon:6         //微笑图标
                		    ,area:["500px","450px"]  
                		    ,content:"<div style='margin-top:15px;margin-left:15px;'>" +
                		            "<h3 style='color:#009F95'>1.基本信息 <i class='layui-icon layui-icon-file-b'></i>:</h3>"+
                		            "<hr style= 'color: #F6F6F6;width:95%'/>"+
                		    		"<p style='font-size:16px;line-height:30px;margin-left: 10px;'><i class='layui-icon layui-icon-username'></i> 用户名："+data.userName+
                		    		"<br/><i class='layui-icon layui-icon-user'></i> 育婴师："+data.babysitterName+"</p>" +
                		    		"<hr style= 'color: #F6F6F6;width:95%'/>"+
                		    		"<h3 style='color:#009F95'>2.评价信息 <i class='layui-icon layui-icon-file-b'></i>:</h3>"+
                		    		"<hr style= 'color: #F6F6F6;;width:95%'/>"+
                		    		"<p style='font-size:16px;line-height:30px;margin-left: 10px;'>" +
                		    		"<i class='layui-icon layui-icon-praise'></i> 评价内容 ："+data.appriseInfo+"<br/>"+
                		    		"<i class='layui-icon layui-icon-date'></i> 评价时间："+data.appriseTime+"<br/>"+
                		    		"<i class='layui-icon layui-icon-diamond'></i> 评价分数：<span style='color:red'>"+data.appriseScore+"星</span>"+
                		    		"<hr style='color: #F6F6F6;;width:95%'/>" +
                		    		"<h3 style='color:#009F95'>3.评价与建议 <i class='layui-icon layui-icon-file-b'></i>:</h3>"+
                		    		"<hr style= 'color: #F6F6F6;;width:95%'/>"+
                		    		"<p style='font-size:16px;line-height:30px;margin-left:10px;'>"+
                		    		"<i class='layui-icon layui-icon-form'></i> "+data.appriseRecommend+"</p>"+
                		    	    "</div>" 
                		});
                });
               }else if(layEvent === 'delItem'){
            	   layer.confirm('真的删除吗？',{skin:'layui-layer-molv'},function(index){
                   	$.ajax('deleteApprise.do?appriseId='+data.id);
                   	layer.msg("删除成功！");
                   	layer.close(index);
                   })
               }else{
            	   layui.use('layer',function(){
                  		var layer = layui.layer;
                  		layer.open({
                  			skin : 'layui-layer-molv' //背景样式
                  			,type :2                  //type为1表示嵌入文本，2表示嵌入iframe
                  			,closeBtn :1      //是否显示关闭按钮
                  			,anim:1          //动画
                  			,title:'更新评价记录'
                  		    ,icon:6         //微笑图标
                  		    ,area:["500px","450px"] 
                  		    ,content:"toUpdateApprise.do?appriseId="+data.id
                  		});
               	  });
                }
            });
      });
    }
});