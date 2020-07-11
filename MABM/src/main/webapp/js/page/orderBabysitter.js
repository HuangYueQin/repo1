/**
 * 
 *time:2019-05-21
 *author:huang yue qin
 *function: loading laydate and get current time.
 * 
 */
$(document).ready(function(){
	
	getDateTime()  //引入当前时间填充到input框
	
	laydate.render({              //加载layui时间
		  elem: '#time' //指定元素
	});	
	
	function getDateTime(){      //时间处理函数
		var time = new Date(); 
		var year = time.getFullYear();
		var month = time.getMonth() +1 ;
		var date = time.getDate() ;
		/*如果日期长度为1则在日期前面补0*/
		month <= 9 ? month = ( "0" + month ) : month;
		date <= 9 ? date = ( "0" + date ) : date;
		$("input[name='requestDate']").val(year+"-"+month+"-"+date);
		
	}

	layui.use('form', function(){        //加载layui表单
	  var form = layui.form; 
	  form.render();
	});
});