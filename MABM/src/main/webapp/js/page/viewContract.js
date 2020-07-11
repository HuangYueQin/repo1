/**
 * time : 2019.5.4
 * author:huang yue qin
 * function: layui Page for sign contract .
 * 
 */
$(document).ready(function(){
	var limitcount = 10;
    var curnum = 0;
    var total = 0;
    $.post({
    	url:'getContractlistCount.do',  //查询育婴师安排情况表中记录的总数
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
                , url: 'contractlist.do' 
                , cols: [[
                    ,{field: 'id', title: 'ID', width:50}
                    , {field: 'customerName', title: '甲方名',width:115}
                    , {field: 'babysitterName', title: '乙方名',width:110} 
                    , {field: 'customerTel', title: '甲方电话',width:110}
                    , {field: 'babysitterTel', title: '乙方电话',width:110}
                    , {field: 'level', title: '保密级别',width:100}
                    , {field: 'contractTime', title: '签订时间',width:120}
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
                if(layEvent === 'viewInfo'){
                	if(data.level === '公开'){
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
                	}else{
                		layer.msg("查看失败！！！<br/>该合同为保密合同。");
                	}
                	
                } 
            });
        });
    }
      var pId = '${pGBean.pgId }';
    productsearch(pId, curnum, limitcount,total)      //调用分页方法
});