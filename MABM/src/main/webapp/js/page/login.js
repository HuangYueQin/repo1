/**
 * time : 2019.4.26
 * author:huang yue qin
 * function: layui form check.
 *
 */
$(document).ready(function(){
	layui.use('form', function(){
		  var form = layui.form;
		  //监听提交
		  form.on('submit(formDemo)', function(data){
		    layer.msg(JSON.stringify(data.field));
		    return false;
		  });
		});
		
		var verifyCode = new GVerify("vertification");  //生成校验码
		document.getElementById("loginSubmit").onclick = function(){  //校验码校验
			var res = verifyCode.validate(document.getElementById("code_input").value);
			$("#codeNum").val(res);                                   //发送校验结果
		} 
});

    
     	
     	

		

