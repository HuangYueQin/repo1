/**
 * time : 2019.5.12
 * author:huang yue qin
 * function: user,babysitter and contract manage.
 */
$(document).ready(function(){
	
	var limitcount = 10;     //分页变量
    var curnum = 0;
    var total = 0; 
    
    getUserCount();      
	 var pId = '${pGBean.pgId }';//调用计算用户总数方法
     productUserSearch(pId, curnum, limitcount,total);      //调用用户分页方法

	function getUserCount(){                                //计算用户总数
		$("#topTitle").html("<i class='layui-icon layui-icon-set'></i> 用户管理-User Management "+
				"<i class='layui-icon layui-icon-down' style='font-size:20px;'></i>");//右面板标头
	    $.post({
	    	url:'getUserListCount.do',
	    	method:'post',
	    	async:false,
	    	success:function(data){
	    		total = data;
	    	}
	    });
	}
	
	function getContractCount(){                         //计算合同总数
		$("#topTitle").html("<i class='layui-icon layui-icon-set'></i> 合同管理-Contract Management "+
		"<i class='layui-icon layui-icon-down' style='font-size:20px;'></i>");//右面板标头
		$.post({
        	url:'getContractListCount.do',
        	method:'post',
        	async:false,
        	success:function(data){
        		total = data;
        	}
        });
	}
	
    //用户列表分页显示方法
    function productUserSearch(productGroupId,start,limitsize,total) {
        layui.use(['table','laypage'], function(){
            var table = layui.table,
                laydate=layui.laydate,
                laypage = layui.laypage;
            table.render({
                elem: '#layui_table_id'
                , url: 'userlist.do'
                , cols: [[
                    {field: 'userId', title: 'ID', width:50}
                    , {field: 'name', title: '姓名',width:120}
                    , {field: 'telphone', title: '电话',width:120}
                    , {field: 'sex', title: '性别',width:70}
                    , {field: 'userFrom', title: '地址', fixed: 'right',width:160}
                    , {field: 'requestInfo', title: '需求信息',width:150}
                    ,{fixed: 'right', align:'center', title: '操作',toolbar: '#barDemo',width:200}
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
            //监听工具条
            table.on('tool(test)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
                var data = obj.data //获得当前行数据
                    ,layEvent = obj.event //获得 lay-event 对应的值
                    ,Id = data.userId;
                if(layEvent === 'detail'){
                	layui.use('layer',function(){
                		var layer = layui.layer;
                		layer.open({
                			skin : 'layui-layer-molv' //背景样式
                			,type :2
                			,closeBtn :1      //是否显示关闭按钮
                			,anim:1          //动画
                			,title:'用户信息如下'
                			,btn :['确定','取消']
                		    ,icon:6         //微笑图标
                		    ,area:["800px","500px"] 
                		    ,content:"selectUserById.do?Id="+Id, 
                		});
                	});	
                } else if(layEvent === 'del'){
                	layer.confirm('真的删除吗？',function(index){
                		$.post({
                			url:'deleteUser.do',
                			data : JSON.stringify(Id),
                			contentType : "application/json",
                			dataType :"json",
                			success:function(){
                				layer.msg("删除成功！");
                			},
                			error:function(){
                				layer.msg("删除失败！");
                			}
                		});
                	});
                } else if(layEvent === 'edit'){
                	layui.use('layer',function(){
                		var layer = layui.layer;
                		layer.open({
                			skin : 'layui-layer-molv' //背景样式
                			,type :2
                			,closeBtn :1      //是否显示关闭按钮
                			,anim:1          //动画
                			,title:'用户信息如下'
                			,btn :['关闭窗口']
                		    ,icon:6         //微笑图标
                		    ,area:["800px","500px"] 
                		    ,content:"toUpdateUser.do?Id="+Id, 
                		});
                	});	
                }
            });
        });
    }
    //合同分页显示方法
    function productContractSearch(productGroupId,start,limitsize,total) {  
        layui.use(['table','laypage'], function(){
            var table = layui.table,
                laydate=layui.laydate,
                laypage = layui.laypage;
            table.render({
                elem: '#layui_table_id'
                , url: 'contractlist.do'
                , cols: [[
                    {field: 'id', title: 'ID', width:50}
                    , {field: 'customerName', title: '甲方',width:110}
                    , {field: 'babysitterName', title: '乙方',width:110}
                    , {field: 'customerTel', title: '客户电话',width:110}
                    , {field: 'babysitterTel', title: '育婴师电话', fixed: 'right',width:110}
                    , {field: 'level', title: '保密级别',width:100}
                    , {field: 'contractTime', title: '签订时间',width:120}
                    ,{fixed: 'right', align:'center', title: '操作',toolbar: '#barDemo',width:160}
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
            //监听工具条
            table.on('tool(test)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
                var data = obj.data //获得当前行数据
                    ,layEvent = obj.event; //获得 lay-event 对应的值
                if(layEvent === 'detail'){
                	if(data.level === '公开'){
                		viewContract(data);
                	}else{
                		 layer.confirm('该合同为保密合同，确定要查看吗？', {
                	            btn : [ '确定', '取消' ]    //按钮
                		        ,skin : 'layui-layer-molv' //背景样式
                	        }, function(index) {         //点击确认后查看操作 
                	        	viewContract(data);
                	        	layer.close(index);
                	        }),function(index){         //点击取消后直接关闭窗口
                			 layer.close(index);
                		 }; 
                	}
                   
                } else if(layEvent === 'del'){
                    layer.confirm('真的删除吗？',{skin:'layui-layer-molv'},function(index){
                    	$.ajax('deleteContract.do?contractId='+data.id);
                    	layer.msg("删除成功！");
                    	layer.close(index);
                    })
                   
                } else if(layEvent === 'edit'){
                	layui.use('layer',function(){
                		var layer = layui.layer;
                		layer.open({
                			skin : 'layui-layer-molv' //背景样式
                			,type :2
                			,closeBtn :1      //是否显示关闭按钮
                			,anim:1          //动画
                			,title:'合同信息如下'
                			,btn :['关闭窗口']
                		    ,icon:6         //微笑图标
                		    ,area:["800px","500px"] 
                		    ,content:"toUpdateContract.do?contractId="+data.id, 
                		});
                	});
                }
            });
        });
    }
     function viewContract(data){                //查看合同方法
    	 layui.use('layer',function(){
     		var layer = layui.layer;
     		layer.open({
     			skin : 'layui-layer-molv' //背景样式
     			,type :1                  //type为1表示嵌入文本，2表示嵌入iframe
     			,closeBtn :1      //是否显示关闭按钮
     			,anim:1          //动画
     			,title:'合同条约如下'
     			,btn :['确定']
     		    ,icon:6         //微笑图标
     		    ,area:["700px","450px"] 
     		    ,content:"<div>" +"<h3>合同信息:</h3>"+
     		            "<hr style= 'color: #F6F6F6;'/>"+
     		    		"<p style='font-size:15px;line-height:22px;'>"+data.info+"</p>" +
     		    		"<hr style= 'color: #F6F6F6;'/>"+
     		    		"<h3>日期信息:</h3>"+
     		    		"<hr style= 'color: #F6F6F6;'/>"+
     		    		"<p style='font-size:15px;'>合同签订时间："+data.contractTime+"   "+
     		    		"预产期："+data.childBirthday+"    "+"服务日期："+data.serviceTime+"</p>" +
     		    		"<hr style= 'color: #F6F6F6;'/>"+
     		    		"<h3>共需资金:</h3>"+
     		    		"<hr style= 'color: #F6F6F6;'/>"+
     		    		"<p style='font-size:15px;color:red;'>金额：￥"+data.amount+"</p>"+
     		    	    "</div>" 
     		});
     	});	
     }
 $("#selectBabysitter").click(function(){        //查询育婴师
	layer.prompt({title: '请输入需要查询的育婴师姓名', formType: 0},
    	function(value, index){
    		layer.close(index);
    		layui.use('layer',function(){
        		var layer = layui.layer;
        		layer.open({
        			skin : 'layui-layer-molv' //背景样式
        			,type :2
        			,closeBtn :1      //是否显示关闭按钮
        			,anim:1          //动画
        			,title:'查询育婴师信息如下'
        			,btn :['确定','取消']
        		    ,icon:6         //微笑图标
        		    ,area:["800px","500px"] 
        		    ,content:"selectBabysitter.do?name="+value, 
        		});
        	});	
        });
    });
 
 $("#selectUser").click(function(){        //查询用户
		layer.prompt({title: '请输入需要查询的用户姓名', formType: 0},
	    	function(value, index){
	    		layer.close(index);
	    		layui.use('layer',function(){
	        		var layer = layui.layer;
	        		layer.open({
	        			skin : 'layui-layer-molv' //背景样式
	        			,type :2
	        			,closeBtn :1      //是否显示关闭按钮
	        			,anim:1          //动画
	        			,title:'查询用户信息如下'
	        			,btn :['确定','取消']
	        		    ,icon:6         //微笑图标
	        		    ,area:["800px","500px"] 
	        		    ,content:"selectUserByName.do?name="+value, 
	        		});
	        	});	
	        });
	    });
    $("#selectContract").click(function(){      //查询合同
    	layer.prompt({title: '输入格式为"用户名,育婴师姓名"', formType: 0},
    	    	function(value, index){
    	    		layer.close(index);
    	    		$.post({
    	    			url:'selectContract.do',
    	    			contentType :'application/json',
    	    			data:JSON.stringify(value),
    	    			dataType :'json',
    	    			success:function(data){     //查询结果不为空，则调用查看合同信息函数，弹出信息框。
    	    				viewContract(data);
    	    			},
    	    			error:function(){          //查询结果为null，则说明查询失败，则提示失败可能的原因
    	    				layer.msg("查询失败，查询的合同不存在或者输入格式错误！")
    	    			}
    	    		});
    	        });
    });
    $("#addBabysitter").click(function(){   //添加育婴师
    	layui.use('layer',function(){
    		var layer = layui.layer;
    		layer.open({
    			skin : 'layui-layer-molv' //背景样式
    			,type :2
    			,closeBtn :1      //是否显示关闭按钮
    			,anim:1          //动画
    			,title:'添加婴师信息'
    			,btn :['关闭窗口']
    		    ,icon:6         //微笑图标
    		    ,area:["800px","500px"] 
    		    ,content:"toAddBabysitter.do", 
    		});
    	});	
    });
    $("#updateBabysitter").click(function(){   //更改育婴师信息
    	
    	layer.prompt({title: '请输入需要更改的育婴师姓名', formType: 0},
    	    	function(value, index){
    	    		layer.close(index);
    	    		layui.use('layer',function(){
    	        		var layer = layui.layer;
    	        		layer.open({
    	        			skin : 'layui-layer-molv' //背景样式
    	        			,type :2
    	        			,closeBtn :1      //是否显示关闭按钮
    	        			,anim:1          //动画
    	        			,btn :['关闭窗口']
    	        			,title:'育婴师信息如下'
    	        		    ,icon:6         //微笑图标
    	        		    ,area:["850px","500px"] 
    	        		    ,content:"toUpdateBabysitter.do?name="+value, 
    	        		});
    	        	});	
    	        });
         });
    $("#deleteBabysitter").click(function(){   //删除育婴师
    	layer.prompt({title: '请输入需要删除的育婴师姓名', formType: 0},
    	    	function(value, index){
    	    		layer.close(index);
    	    		layui.use('layer',function(){
    	        		var layer = layui.layer;
    	        		layer.open({
    	        			skin : 'layui-layer-molv' //背景样式
    	        			,type :2
    	        			,closeBtn :1      //是否显示关闭按钮
    	        			,anim:1          //动画
    	        			,title:'删除育婴师'
    	        			,btn :['确定','取消']
    	        		    ,icon:6         //微笑图标
    	        		    ,area:["800px","500px"] 
    	        		    ,content:"deleteBabysitter.do?name="+value, 
    	        		});
    	        	});	
    	        });
        });
    
    $("#displayContract").click(function(){ //分页显示合同操作
    	getContractCount()
        var pId = '${pGBean.pgId }';
        productContractSearch(pId, curnum, limitcount,total);
    });
    $("#displayUser").click(function(){ //点击用户管理分页显示对用户的操作
    	
    	getUserCount();
        var pId = '${pGBean.pgId }';
        productUserSearch(pId, curnum, limitcount,total);
    });
});
