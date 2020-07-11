/**
 * time : 2019.4.26
 * author:huang yue qin
 * function:loading layui form.
 *
 */
$(document).ready(function(){
	layui.use('form', function(){
		  var form = layui.form;
		  form.render();
	});
	
	$("#mould").click(function(){                        //导入育婴合同模板
		var username = $("input[name='customerName']").val();
		var babysitter = $("#babysitter").val();
		var amount = $("input[name='amount']").val();    // "\r"换行符，"\n"回车，"\t" tab键
		$("#contractInfo").html("甲方："+username+"<br/>\r" +
				"乙方："+babysitter+"<br/>\r" +
				"为维护甲乙双方合法权益，本着共同发展、平等协商、互利互惠的原则，经双方协商，特订立如下条款<br/>\r第一条合同内容 <br/>\r" +
				"1.合同名称：&nbsp;&nbsp;&nbsp;&nbsp;<br/>\r" +
				"2.合同金额：甲乙双方同意，育婴费用一共"+amount+"元<br/> \r"+
				"3.服务时间：&nbsp;&nbsp;&nbsp;&nbsp;<br/>\r"+
				"第二条服务方式 <br/>\r乙方需要到甲方住宅处进行育婴服务<br/>\r甲方需要采用电子汇款打入乙方账户<br/>\r第三条违约责任<br/>\r"+
				"如若乙方未能按时到甲方住宅处进行服务，那么乙方需要承担育婴总费用的&nbsp;%作为补偿。<br/>\r");
	});
});

