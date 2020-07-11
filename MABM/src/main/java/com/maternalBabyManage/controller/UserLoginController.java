package com.maternalBabyManage.controller;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.maternalBabyManage.dao.UserDao;
import com.maternalBabyManage.domain.User;
import com.maternalBabyManage.util.StringUtil;

@Controller
public class UserLoginController {
	
	@RequestMapping(value="/login")
	public String login() {
		return "/login";
	}
	
	@RequestMapping(value="/toLogin",method=RequestMethod.POST)
	public void  toLogin(User user ,HttpSession session,HttpServletResponse response,String codeNum,HttpServletRequest request) throws Exception{
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		ApplicationContext aContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		UserDao userDao = (UserDao) aContext.getBean(UserDao.class);
		String loginName = user.getName();
		String loginPassword = user.getPassword();
		User tempUser = userDao.selectUserByName(loginName);
		if(null == tempUser) {
			out.println("<script>alert('��¼ʧ�ܣ��û���������');location.href='login';</script>");
			return;
		}
		String password = tempUser.getPassword();
        if(StringUtil.equals(loginPassword, password) && StringUtil.equals(codeNum, "true")) {
        	session.setMaxInactiveInterval(30*60);
        	/*���͵�ǰ̨�ĵ�¼��*/
        	if(loginName.length()<8) {
        		session.setAttribute("LoginName", loginName);
        	}else {
        		session.setAttribute("LoginName", loginName.substring(0, 8)); //��ȡ8�����ȵ��û����Ӵ�
        	}
        	//��¼���û�����ͨ�ã�
        	session.setAttribute("username", loginName);
        	out.println("<script>alert('��¼�ɹ���');location.href='index?isLogin=true';</script>");
        }else {
        	if(!StringUtil.equals(loginPassword, password) ) {
    			out.println("<script>alert('��¼ʧ�ܣ��������');</script>");
    	    }else if(!StringUtil.equals(codeNum, "true")) {
        		out.println("<script>alert('��¼ʧ�ܣ���֤�����');</script>");
        	}
        	out.println("<script>location.href='login'</script>");
        }
	  }
	
	 @RequestMapping(value ="/exit")
	 public void exit(HttpSession session,HttpServletResponse response) throws Exception{
		 
	     response.setCharacterEncoding("utf-8");
		 response.setContentType("text/html;charset=utf-8");
		 PrintWriter out = response.getWriter(); 
		 if(null == session.getAttribute("username") && null == session.getAttribute("adminName")) {
			 out.println("<script>alert('�˳�ϵͳʧ�ܣ���δ��¼ϵͳ');location.href='index';</script>");
			 return ;
		 }
		 session.removeAttribute("username");
		 session.removeAttribute("adminName");
		 session.removeAttribute("LoginName");
		 session.invalidate();
		 out.println("<script>alert('�˳�ϵͳ�ɹ���');location.href='index?isLogin=false';</script>");
		 
	 }
}
