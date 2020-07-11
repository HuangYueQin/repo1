package com.maternalBabyManage.controller;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitterReturnValueHandler;

import com.maternalBabyManage.dao.AdminDao;
import com.maternalBabyManage.domain.Admin;
import com.maternalBabyManage.util.StringUtil;
@Controller
public class AdminLoginController {
	
	@RequestMapping("/toAdmin")
	public String toAdmin(HttpSession session) {    //判断管理员是否已经登录
		
		if(null != session.getAttribute("adminName") && session.getAttribute("adminName")!= "") {
			return "/admin";
		}
	    return "/adminLogin";	           //管理员未登录跳转到登录界面
	}
	@RequestMapping("/adminPage")          //登录成功，跳转管理员界面
	public String AdminPage(){
		return "/admin";
	}
	@RequestMapping("/admin")              //接收post表单
	public void Admin(Admin admin,HttpSession session,HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		ApplicationContext aContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		AdminDao adminDao = (AdminDao) aContext.getBean(AdminDao.class);
		String adminName = admin.getName();
		String password = admin.getPassword();
		Admin adminTemp = adminDao.selectAdminByName(adminName);
		if(null == adminTemp) {
			out.println("<script>alert('登录失败！用户名不存在');location.href='toAdmin';</script>"); //跳转管理员登录界面
			
		}else {
			
			if(!StringUtil.equals(password, adminTemp.getName())) {
				out.println("<script>alert('登录失败！密码错误');location.href='toAdmin';</script>"); //跳转管理员登录界面
				
			}else {
				session.setMaxInactiveInterval(30*60);
				session.setAttribute("adminName", adminName);
				out.println("<script>alert('登录成功！');location.href='adminPage';</script>"); //跳转管理员界面
			}
		}

		
	}
}
	
