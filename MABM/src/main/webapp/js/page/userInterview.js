/**
 * time : 2019.4.29
 * author:huang yue qin
 * function: get time at now for user interview.
 */
$(document).ready(function(){
	
	getDateTime()  //引入当前时间填充到input框
	
	layui.use('form', function(){  //加载layui表单
	  var form = layui.form; //只有执行了这一步，部分表单元素才会自动修饰成功
	  form.render();
	});
	laydate.render({              //加载layui时间
		  elem: '#time' //指定元素
	});	
	
	function getDateTime(){      //时间处理函数
		var time = new Date(); 
		var year = time.getFullYear();
		var month = time.getMonth() +1 ;
		var date = time.getDate() ;
		/*如果日期长度为1则在日期前面补0*/
		month <= 9 ? month = ( "0" + month ): month;
		date <= 9 ? date = ("0" + date ): date;
		$("input[name='interviewDate']").val(year+"-"+month+"-"+date);
		
	}
});
