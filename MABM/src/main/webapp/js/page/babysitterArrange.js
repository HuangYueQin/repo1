/**
 * time : 2019.4.28
 * author:huang yue qin
 * function: babysitterArrange manage.
 *
 */
$(document).ready(function(){
	var limitcount = 10;
    var curnum = 0;
    var total = 0;
    $.post({
    	url:'getBabysitterArrangelistCount.do',  //查询育婴师安排情况表中记录的总数
    	method:'post',
    	async:false,
    	success:function(data){
    		total = data;
    	}
    });
    //育婴师安排表列表查询方法
    function productsearch(productGroupId,start,limitsize,total) {
        layui.use(['table','laypage'], function(){
            var table = layui.table,
                laydate=layui.laydate,
                laypage = layui.laypage;
            table.render({
                elem: '#layui_table_id'
                , url: 'babysitterArrangelist.do' 
                , cols: [[
                    ,{field: 'id', title: 'ID', width:50}
                    , {field: 'babysitterName', title: '姓名',width:110} 
                    , {field: 'customer', title: '客户名',width:115}
                    , {field: 'customerTel', title: '客户电话',width:110}
                    , {field: 'requestDate', title: '需求日期',width:100}
                    , {field: 'requestInfo', title: '需求内容',width:120}
                    , {field: 'address', title: '详细地址',width:190}
                    ,{fixed: 'right', align:'center', title: '操作',toolbar: '#barDemo',width:115}
                ]]
                , page: true
                , even: true
                , width: 850
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
                if(layEvent === 'choose'){
                	layui.use('layer',function(){
                		var layer = layui.layer;
                		layer.open({
                			skin : 'layui-layer-molv' //背景样式
                			,type :1                  //type为1表示嵌入文本，2表示嵌入iframe
                			,closeBtn :1      //是否显示关闭按钮
                			,anim:1          //动画
                			,title:'育婴师安排情况清单'
                			,btn :['确定']
                		    ,icon:6         //微笑图标
                		    ,area:["400px","380px"]    
                		    ,content:"<div style='margin-top:15px;margin-left:15px;'>" +
        		            "<h3 style='color:#009F95'>1.基本信息 <i class='layui-icon layui-icon-file-b'></i>:</h3>"+
        		            "<hr style= 'color: #F6F6F6;width:95%'/>"+
        		    		"<p style='font-size:16px;line-height:30px;margin-left: 10px;'>" +
        		    		"<i class='layui-icon layui-icon-username'></i> 育婴师："+data.babysitterName+"<br/>"+
        		    		"<i class='layui-icon layui-icon-user'></i> 用户："+data.customer+"</p>" +
        		    		"<hr style= 'color: #F6F6F6;width:95%'/>"+
        		    		"<h3 style='color:#009F95'>2.服务信息 <i class='layui-icon layui-icon-file-b'></i>:</h3>"+
        		    		"<hr style= 'color: #F6F6F6;;width:95%'/>"+
        		    		"<p style='font-size:16px;line-height:30px;margin-left: 10px;'>" +
        		    		"<i class='layui-icon layui-icon-form'></i> 服务内容 ："+data.requestInfo+"<br/>"+
        		    		"<i class='layui-icon layui-icon-date'></i> 服务日期："+data.requestDate+"<br/>"+
        		    		"<i class='layui-icon layui-icon-home'></i> 服务地址："+data.address+ "</p>"+
        		            "</div>" 
                		});
                	});	 
                } 
            });
        });
    }
      var pId = '${pGBean.pgId }';
    productsearch(pId, curnum, limitcount,total)      //调用分页方法
});