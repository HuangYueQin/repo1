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
	public String toAdmin(HttpSession session) {    //�жϹ���Ա�Ƿ��Ѿ���¼
		
		if(null != session.getAttribute("adminName") && session.getAttribute("adminName")!= "") {
			return "/admin";
		}
	    return "/adminLogin";	           //����Աδ��¼��ת����¼����
	}
	@RequestMapping("/adminPage")          //��¼�ɹ�����ת����Ա����
	public String AdminPage(){
		return "/admin";
	}
	@RequestMapping("/admin")              //����post��
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
			out.println("<script>alert('��¼ʧ�ܣ��û���������');location.href='toAdmin';</script>"); //��ת����Ա��¼����
			
		}else {
			
			if(!StringUtil.equals(password, adminTemp.getName())) {
				out.println("<script>alert('��¼ʧ�ܣ��������');location.href='toAdmin';</script>"); //��ת����Ա��¼����
				
			}else {
				session.setMaxInactiveInterval(30*60);
				session.setAttribute("adminName", adminName);
				out.println("<script>alert('��¼�ɹ���');location.href='adminPage';</script>"); //��ת����Ա����
			}
		}

		
	}
}
	
