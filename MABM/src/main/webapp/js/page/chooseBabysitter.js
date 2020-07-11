/**
 * time : 2019.4.28
 * author:huang yue qin
 * function: chooseBabysitter manage.
 * 
 */
$(document).ready(function(){
	var limitcount = 10;
    var curnum = 0;
    var total = 0;
    $.post({
    	url:'getBabysitterlistCount.do',
    	method:'post',
    	async:false,
    	success:function(data){
    		total = data;
    	}
    });
    //列表查询方法
    function productsearch(productGroupId,start,limitsize,total) {
        layui.use(['table','laypage'], function(){
            var table = layui.table,
                laydate=layui.laydate,
                laypage = layui.laypage;
            table.render({
                elem: '#layui_table_id'
                , url: 'babysitterlist.do' 
                , cols: [[
                     {field: 'babysitterId', title: 'ID', width:50}
                    , {field: 'babysitterName', title: '姓名',width:110} 
                    , {field: 'sex', title: '性别',width:65}
                    , {field:'age',title:'年龄',width:65}
                    , {field:'constellation',title:'星座',width:75}
                    , {field:'education',title:'学历',width:65}
                    , {field: 'workInfo', title: '工作内容',width:170}
                    , {field: 'recomend', title: '推荐理由',width:170}
                    ,{fixed: 'right', align:'center', title: '操作',toolbar: '#barDemo',width:80}
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
                			,type :2                  //type为1表示嵌入文本，2表示嵌入iframe
                			,closeBtn :1      //是否显示关闭按钮
                			,anim:1          //动画
                			,title:'预约信息如下'
                		    ,icon:6         //微笑图标
                		    ,area:["500px","450px"]  
                		    ,content:"toOrderBabysitter.do?babysitterId="+data.babysitterId
                		});
                   });
                } 
            });
        });
    }
      var pId = '${pGBean.pgId }';
    productsearch(pId, curnum, limitcount,total)      //调用分页方法
});