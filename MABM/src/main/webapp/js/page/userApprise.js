/**
 * time : 2019.4.29
 * author:huang yue qin
 * function:layui rate for user.
 */
$(document).ready(function(){
	
	layui.use(['rate'], function(){  //加载layui评分插件
	  var rate = layui.rate;
	  rate.render({
	    elem: '#score'
	    ,theme: '#009688'
	    ,value: 3
	    ,text: true
	    ,setText: function(value){ //自定义文本的回调
	      var arrs = {
	        '1': '极差'
	        ,'2': '差'
	        ,'3': '一般'
	        ,'4': '好'
	        ,'5': '极好'
	      };
	      this.span.text(arrs[value] || ( value + "星"));
	      $("input[name='appriseScore']").attr("value",value);    //将评分填写入input hidden框，供提交表单用
	                                                              //注意不是html(),html是添加html的文本，而是attr()的属性
	    }
	  });
	});
	
	getDateTime()  //引入当前时间填充到input框
	
	layui.use('form', function(){  //加载layui表单
	  var form = layui.form; //只有执行了这一步，部分表单元素才会自动修饰成功
	  form.render();
	});
	laydate.render({              //加载layui时间
		  elem: '#time' //指定元素
	});	
	
	function getDateTime(){
		var time = new Date(); 
		var year = time.getFullYear();
		var month = time.getMonth() +1 ;
		var date = time.getDate() ;
		/*如果日期长度为1则在日期前面补0*/
		month <= 9 ? month = "0" + month : month;
		date <= 9 ? date = "0" + date : month;
		$("input[name='appriseTime']").attr("value",year+"-"+month+"-"+date);
		
	}
});
