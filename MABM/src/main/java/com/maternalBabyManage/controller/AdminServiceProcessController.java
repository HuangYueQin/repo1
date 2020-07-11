package com.maternalBabyManage.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.maternalBabyManage.domain.Apprise;
import com.maternalBabyManage.domain.Interview;
import com.maternalBabyManage.service.ServiceProcessManageService;
import com.maternalBabyManage.util.DateFormatUtil;
import com.maternalBabyManage.util.StringUtil;

@Controller
public class AdminServiceProcessController {
	
	@Autowired
	ServiceProcessManageService serviceProcessManageService;
	
	@RequestMapping("/getInterviewListCount")         //��ȡ�ɷü�¼����
	public @ResponseBody int getInterviewListCount() {
		return serviceProcessManageService.getInterviewListCount();
	}

	@RequestMapping("/getAppriseListCount")          //��ȡ���ۼ�¼����
	public @ResponseBody int getAppriseListCount() {
		return serviceProcessManageService.getAppriseListCount();
	}
	
	@RequestMapping("/interviewlist")               //��ȡ�ɷü�¼list
	public @ResponseBody List<Interview> getInterviewlist(@RequestParam Map<String, String> map) {
		
		return serviceProcessManageService.getInterviewlist(map);
	}
	
	@RequestMapping("/appriselist")                //��ȡ���ۼ�¼list
	public @ResponseBody List<Apprise> getAppriselist(@RequestParam Map<String, String> map) {
		
		return serviceProcessManageService.getAppriselist(map);
	}

	@RequestMapping("/deleteInterview")           //ͨ��idɾ���ɷü�¼
	public @ResponseBody int deleteInterviewById(String interviewId) {
		int id = StringUtil.toInt(interviewId);
		serviceProcessManageService.deleteInterviewById(id);
		return 1;                                 //���ر�־λ1����ɾ���ɹ���js����Ϊajax,funciton��������ɾ���ɹ���ʾ
	}
	@RequestMapping("/deleteApprise")            //ͨ��idɾ�����ۼ�¼
	public @ResponseBody int deleteAppriseById(String appriseId) {
		int id = StringUtil.toInt(appriseId);
		serviceProcessManageService.deleteAppriseById(id);
		return 1;
	}
	@RequestMapping("/toUpdateInterview")  //��ת�����»طü�¼����
	public String toUpdateInterview(String interviewId,Model model) throws Exception{   //get�ύ��ʽ
		
		int id = StringUtil.toInt(interviewId);
		Interview interview = serviceProcessManageService.getInterviewById(id);
		if(null != interview) {
			Date interviewDate = interview.getInterviewDate();
			model.addAttribute("interviewDate", DateFormatUtil.getFormatDate(interviewDate));
			model.addAttribute("interview", interview);
		}
		return "/adminUpdateInterview";
	}
	
	@RequestMapping("/toUpdateApprise")  //��ת���������ۼ�¼����
	public String toUpdateApprise(String appriseId,Model model) throws Exception{
		
		int id = StringUtil.toInt(appriseId);
		Apprise apprise = serviceProcessManageService.getAppriseById(id);
		if(null != apprise) {
			Date appriseTime = apprise.getAppriseTime();
			model.addAttribute("appriseTime", DateFormatUtil.getFormatDate(appriseTime));
			model.addAttribute("apprise", apprise);
		}
		return "/adminUpdateApprise";
	}
	
	@RequestMapping("/updateInterview")    //���»طü�¼
	public String updateInterview(Interview interview,Model model) {
		
		serviceProcessManageService.updateInterview(interview);
		model.addAttribute("msg", "���³ɹ�");
		return "/success";
	}
	
	@RequestMapping("/updateApprise")    //�������ۼ�¼
	public String updateApprise(Apprise apprise,Model model) {
		
		serviceProcessManageService.updateApprise(apprise);
		model.addAttribute("msg", "���³ɹ�");
		return "/success";
	}
	
}
