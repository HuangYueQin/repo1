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
	
	@RequestMapping("/toUserApprise")    //��ת���û�����ҳ��
	public String toUserApprise(HttpSession session,Model model) {
		String username = (String) session.getAttribute("username");
		User user = userManageService.selectUserByName(username);
		if(null == user) {
			model.addAttribute("msg", "3.��δ��¼ϵͳ�����ȵ�¼���ٽ��в�����");
			return "/error";
		}else {
			model.addAttribute("user", user);
			return "/userApprise";
		}
		
	}
	
	@RequestMapping("/toUserInterview") //��ת���طü�¼ҳ��
	public String toInterview(HttpSession session,Model model) {
		
		String username = (String) session.getAttribute("username");
		User user = userManageService.selectUserByName(username);
		if(null == user) {
			model.addAttribute("msg", "3.��δ��¼ϵͳ�����ȵ�¼���ٽ��в�����");
			return "/error";
		}else {
			model.addAttribute("user", user);
			return "/userInterview";
		}
		
	}
	
	@RequestMapping("/userApprise")   //�û�����
	public void userApprise(Apprise apprise,HttpServletResponse response) throws Exception{
		
		/*�˴��ض�����return "redirect:url"��ΪҪ�������ۼ�¼��ӳɹ�����,������response.getWriter().println�ض���*/
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		indexOperationService.addApprise(apprise);
		response.getWriter().println("<script>alert('���ۼ�¼��ӳɹ���');location.href='../index';</script>"); //(../index��ʾ����������)
	}
	
	@RequestMapping("/userInterview")
	public void userInterview(Interview interview,HttpServletResponse response) throws Exception{
		
		/*�˴��ض�����return "redirect:url"��ΪҪ�������ۼ�¼��ӳɹ�����,������response.getWriter().println�ض���*/
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		indexOperationService.addInterview(interview);
		response.getWriter().println("<script>alert('�طü�¼�ύ�ɹ���');location.href='../index';</script>"); //(../index��ʾ����������)
		
	}

}
