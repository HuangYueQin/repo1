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
	
	@RequestMapping("/getInterviewListCount")         //获取采访记录总数
	public @ResponseBody int getInterviewListCount() {
		return serviceProcessManageService.getInterviewListCount();
	}

	@RequestMapping("/getAppriseListCount")          //获取评价记录总数
	public @ResponseBody int getAppriseListCount() {
		return serviceProcessManageService.getAppriseListCount();
	}
	
	@RequestMapping("/interviewlist")               //获取采访记录list
	public @ResponseBody List<Interview> getInterviewlist(@RequestParam Map<String, String> map) {
		
		return serviceProcessManageService.getInterviewlist(map);
	}
	
	@RequestMapping("/appriselist")                //获取评价记录list
	public @ResponseBody List<Apprise> getAppriselist(@RequestParam Map<String, String> map) {
		
		return serviceProcessManageService.getAppriselist(map);
	}

	@RequestMapping("/deleteInterview")           //通过id删除采访记录
	public @ResponseBody int deleteInterviewById(String interviewId) {
		int id = StringUtil.toInt(interviewId);
		serviceProcessManageService.deleteInterviewById(id);
		return 1;                                 //返回标志位1代表删除成功，js体现为ajax,funciton函数弹出删除成功提示
	}
	@RequestMapping("/deleteApprise")            //通过id删除评价记录
	public @ResponseBody int deleteAppriseById(String appriseId) {
		int id = StringUtil.toInt(appriseId);
		serviceProcessManageService.deleteAppriseById(id);
		return 1;
	}
	@RequestMapping("/toUpdateInterview")  //跳转到更新回访记录界面
	public String toUpdateInterview(String interviewId,Model model) throws Exception{   //get提交方式
		
		int id = StringUtil.toInt(interviewId);
		Interview interview = serviceProcessManageService.getInterviewById(id);
		if(null != interview) {
			Date interviewDate = interview.getInterviewDate();
			model.addAttribute("interviewDate", DateFormatUtil.getFormatDate(interviewDate));
			model.addAttribute("interview", interview);
		}
		return "/adminUpdateInterview";
	}
	
	@RequestMapping("/toUpdateApprise")  //跳转到更新评价记录界面
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
	
	@RequestMapping("/updateInterview")    //更新回访记录
	public String updateInterview(Interview interview,Model model) {
		
		serviceProcessManageService.updateInterview(interview);
		model.addAttribute("msg", "更新成功");
		return "/success";
	}
	
	@RequestMapping("/updateApprise")    //更新评价记录
	public String updateApprise(Apprise apprise,Model model) {
		
		serviceProcessManageService.updateApprise(apprise);
		model.addAttribute("msg", "更新成功");
		return "/success";
	}
	
}
