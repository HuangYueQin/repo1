package com.maternalBabyManage.controller;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.maternalBabyManage.dao.UserDao;
import com.maternalBabyManage.domain.User;


@Controller
public class UserRegisterController {
	
	@RequestMapping("/register")
    public String register() {
		return "/register";
	}
	
	@RequestMapping(value="/toRegister",method=RequestMethod.POST)
	public void toRegister(User user,HttpServletResponse response) throws Exception {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		ApplicationContext aContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		UserDao userDao = (UserDao) aContext.getBean(UserDao.class);
		userDao.addUser(user);
		out.println("<script>alert('×¢²á³É¹¦£¡');location.href='index';</script>");
	}
}
