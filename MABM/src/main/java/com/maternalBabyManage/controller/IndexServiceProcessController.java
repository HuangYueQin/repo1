package com.maternalBabyManage.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.maternalBabyManage.domain.Apprise;
import com.maternalBabyManage.domain.Interview;
import com.maternalBabyManage.domain.User;
import com.maternalBabyManage.service.IndexOperationService;
import com.maternalBabyManage.service.UserManageService;
import com.sun.org.apache.xpath.internal.operations.Mod;

@Controller
@RequestMapping("/index")
public class IndexServiceProcessController {
	
	@Autowired
	IndexOperationService indexOperationService;
	
	@Autowired
	UserManageService userManageService;
	
	@RequestMapping("/toUserApprise")    //跳转到用户评价页面
	public String toUserApprise(HttpSession session,Model model) {
		String username = (String) session.getAttribute("username");
		User user = userManageService.selectUserByName(username);
		if(null == user) {
			model.addAttribute("msg", "3.您未登录系统，请先登录后再进行操作！");
			return "/error";
		}else {
			model.addAttribute("user", user);
			return "/userApprise";
		}
		
	}
	
	@RequestMapping("/toUserInterview") //跳转到回访记录页面
	public String toInterview(HttpSession session,Model model) {
		
		String username = (String) session.getAttribute("username");
		User user = userManageService.selectUserByName(username);
		if(null == user) {
			model.addAttribute("msg", "3.您未登录系统，请先登录后再进行操作！");
			return "/error";
		}else {
			model.addAttribute("user", user);
			return "/userInterview";
		}
		
	}
	
	@RequestMapping("/userApprise")   //用户评价
	public void userApprise(Apprise apprise,HttpServletResponse response) throws Exception{
		
		/*此处重定向不用return "redirect:url"因为要返回评价记录添加成功弹框,所以用response.getWriter().println重定向*/
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		indexOperationService.addApprise(apprise);
		response.getWriter().println("<script>alert('评价记录添加成功！');location.href='../index';</script>"); //(../index表示返回主界面)
	}
	
	@RequestMapping("/userInterview")
	public void userInterview(Interview interview,HttpServletResponse response) throws Exception{
		
		/*此处重定向不用return "redirect:url"因为要返回评价记录添加成功弹框,所以用response.getWriter().println重定向*/
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		indexOperationService.addInterview(interview);
		response.getWriter().println("<script>alert('回访记录提交成功！');location.href='../index';</script>"); //(../index表示返回主界面)
		
	}

}
