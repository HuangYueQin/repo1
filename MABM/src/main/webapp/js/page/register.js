/**
 * time : 2019.4.26
 * author:huang yue qin
 * function:layui form check.
 *
 */
$(document).ready(
		function() {

			layui.use('form', function() {
				var form = layui.form;
				form.render();
			});
			var verifyCode = new GVerify("vertification"); //生成验证码
			laydate.render({
				elem : '#time' // 指定元素
			});
			layui.use([ 'form' ], function() {
				$ = layui.$;
				var form = layui.form;
				form.verify({                             //自定义密码校验
					repassword : function(value, item) {
						if (value != $("input[name='password']").val()) {
							return "两次密码不一致";
						}
					},
					code : function(value, item) {        //自定义验证码 
						var res = verifyCode.validate(document
								.getElementById("code_input").value);
						if (!res) {
							return "验证码错误";
						}
					}
				});
			});

		});
