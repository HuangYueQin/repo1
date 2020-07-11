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
			out.println("<script>alert('登录失败！用户名不存在');location.href='login';</script>");
			return;
		}
		String password = tempUser.getPassword();
        if(StringUtil.equals(loginPassword, password) && StringUtil.equals(codeNum, "true")) {
        	session.setMaxInactiveInterval(30*60);
        	/*发送到前台的登录名*/
        	if(loginName.length()<8) {
        		session.setAttribute("LoginName", loginName);
        	}else {
        		session.setAttribute("LoginName", loginName.substring(0, 8)); //截取8个长度的用户名子串
        	}
        	//登录的用户名（通用）
        	session.setAttribute("username", loginName);
        	out.println("<script>alert('登录成功！');location.href='index?isLogin=true';</script>");
        }else {
        	if(!StringUtil.equals(loginPassword, password) ) {
    			out.println("<script>alert('登录失败！密码错误！');</script>");
    	    }else if(!StringUtil.equals(codeNum, "true")) {
        		out.println("<script>alert('登录失败！验证码错误');</script>");
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
			 out.println("<script>alert('退出系统失败！您未登录系统');location.href='index';</script>");
			 return ;
		 }
		 session.removeAttribute("username");
		 session.removeAttribute("adminName");
		 session.removeAttribute("LoginName");
		 session.invalidate();
		 out.println("<script>alert('退出系统成功！');location.href='index?isLogin=false';</script>");
		 
	 }
}
