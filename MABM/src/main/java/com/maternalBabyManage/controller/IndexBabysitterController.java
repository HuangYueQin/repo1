package com.maternalBabyManage.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.maternalBabyManage.domain.Babysitter;
import com.maternalBabyManage.domain.BabysitterArrange;
import com.maternalBabyManage.domain.User;
import com.maternalBabyManage.service.BabysitterManageService;
import com.maternalBabyManage.service.IndexOperationService;
import com.maternalBabyManage.util.DateFormatUtil;
import com.maternalBabyManage.util.StringUtil;

@Controller
@RequestMapping("/index")
public class IndexBabysitterController {

	@Autowired
	BabysitterManageService babysitterManageService;
	
	@Autowired
	IndexOperationService indexOperationService;

	private int resumeNum = 1;  //育婴师简历界面初始值为第二条简历,当用户点击时候会跳转到第一条（因为76行有resumeNum--操作）
	
	@RequestMapping("/selectBabysitter") //查询育婴师
	public String selectBabysitters(String name,Model model)throws Exception {

		name = name.trim(); //清除输入育婴师后的多余空格
		if(StringUtil.equals(name, "")) {
			model.addAttribute("msg", "3.未输入育婴师姓名!");
			model.addAttribute("isUser","true");
			return "/error";
		}
		Babysitter babysitter = babysitterManageService.getBabysitter(name);
		
		if(null == babysitter) {
			model.addAttribute("msg", "3.输入的育婴师姓名不存在！");
			return "/error";
		}
		model.addAttribute("babysitter", babysitter);
		model.addAttribute("time", DateFormatUtil.getFormatDate(babysitter.getWorkTime()));//转换日期格式
		return "/babysitter";
	}

	@RequestMapping("/chooseBabysitter") //选择育婴师页面跳转
	public String chooseBabysitter(HttpSession session,Model model) {
		
		String username = (String) session.getAttribute("username");
		if(null == username) {
			model.addAttribute("msg", "3.您未登录系统，请先登录后再进行操作！");
			return "/error";
		}else {
			return "/chooseBabysitter";
		}
		
	}
	
	@RequestMapping("/babysitterlist") //育婴师分页
	public @ResponseBody List<Babysitter> getBabysitterlist(@RequestParam Map<String,String> map){
		return babysitterManageService.getBabysitterlist(map);
	}
	
	@RequestMapping("/getBabysitterlistCount") //计算总数
	public @ResponseBody int getUserListCount() {
		return babysitterManageService.getBabysitterCount();
	}
	
	@RequestMapping("/toBabysitterResume") //主页点击查看育婴师简历
	public String toBabysitterResume(String Resume,Model model)throws Exception{
		List<Babysitter> babysitters = indexOperationService.getBabysitterlist();
		int total = babysitters.size(); //获取育婴师总个数
		if(StringUtil.equals(Resume, "1")) {   //上一个简历
			resumeNum --;
			if(resumeNum == -1) {               //临界循环
				resumeNum = total-1;
			}
		}else if(StringUtil.equals(Resume, "2")) { //下一个简历
			resumeNum ++;
			if(resumeNum == total) {          //临界循环
				resumeNum = 0;
			}
		}
		Babysitter babysitter  = babysitters.get(resumeNum);
		model.addAttribute("babysitter", babysitter);
		if(babysitter.getWorkTime()!= null) {
			model.addAttribute("time",DateFormatUtil.getFormatDate(babysitter.getWorkTime()));//转换标准时间并发送
		}
        return "/babysitterResume";
	}
	
	/*@RequestMapping("/toBabysitterResume") //主页点击查看育婴师简历 (bug代码)
	public String  toBabysitterResume(String Resume,Model model)throws Exception{
		
		int total = babysitterManageService.getBabysitterCount(); //获取育婴师总个数
		System.out.println(total);
		Babysitter babysitter = null;
	    
	    	if(StringUtil.equals(Resume, "1")) {   //上一个简历
				resumeNum --;
				if(resumeNum == 0) {               //临界循环
					resumeNum = total;
				}
			}else if(StringUtil.equals(Resume, "2")) { //下一个简历
				resumeNum ++;
				if(resumeNum == total+1) {          //临界循环
					resumeNum = 1;
				}
			}
	    	babysitter  = indexOperationService.getBabysitterById(resumeNum);
	    	
	    
		model.addAttribute("babysitter", babysitter);
		if(babysitter.getWorkTime()!= null) {
			model.addAttribute("time",DateFormatUtil.getFormatDate(babysitter.getWorkTime()));//转换标准时间并发送
		}
        return "/babysitterResume";
	}
	*/
	
	@RequestMapping("/toBabysitterArrange")  //主页跳转到育婴师安排界面
	public String toBabysitterArrange() {
		return "/babysitterArrange";
	}
	
	@RequestMapping("/getBabysitterArrangelistCount") //获取育婴师安排表记录总数
	public @ResponseBody int getBabysitterArrangelistCount() {
		
		return indexOperationService.getBabysitterArrangelistCount();
	}
	
	@RequestMapping("/babysitterArrangelist")  //获取育婴师安排表所有记录
	public @ResponseBody List<BabysitterArrange> babysitterArrangelist(@RequestParam Map<String,String> map)throws Exception{
		
		return indexOperationService.getBabysitterArrangelist(map);
	}
	
	@RequestMapping("/toOrderBabysitter")    //跳转到预约育婴师界面
	public String toOrderBabysitter(String babysitterId,HttpSession session,Model model) {
		
		int id = StringUtil.toInt(babysitterId);
		Babysitter babysitter = indexOperationService.getBabysitterById(id);
		String username = (String) session.getAttribute("username");
		User user = indexOperationService.getUserByName(username);
		if(( user != null ) && ( babysitter != null)) {
			model.addAttribute("user", user);
			model.addAttribute("babysitter", babysitter);
			return "/orderBabysitter";
		}else {
			
			model.addAttribute("msg", "3.系统错误！请返回到主界面。");
			return "/error";
		}
	}
	
	@RequestMapping("/orderBabysitter")   //预约育婴师
	public String orderBabysitter(BabysitterArrange bArrange,String childbirthDate,Model model)throws Exception {
		
		/*获取前台信息*/
		String babysitterName = bArrange.getBabysitterName();
		String username = bArrange.getCustomer();
		String requestInfo = bArrange.getRequestInfo();
		Date requestDate = bArrange.getRequestDate();
		
		/*根据信息获取用户*/
		User user = indexOperationService.getUserByName(username);
		
		/*更新用户信息*/
		user.setRequestDate(requestDate);
		user.setRequestInfo(requestInfo);
		user.setChildbirthDate(DateFormatUtil.toDate(childbirthDate));
		
		/*更新用户中的育婴师信息*/
		StringBuilder babysitterlistListName = new StringBuilder();
		List<Babysitter> babysitterlist = user.getBabysitterlist();
		for(int i=0;i<babysitterlist.size();i++) {
			babysitterlistListName.append(babysitterlist.get(i).getBabysitterName()).append(",") ;
		}
		babysitterlistListName.append(babysitterName).append(",");
		
		indexOperationService.updateUser(user, babysitterlistListName.toString());
		indexOperationService.addBabysitterArrange(bArrange);  //添加到育婴师安排表
		
		model.addAttribute("msg", "预约成功！");
		return "/orderSuccess";
	}
}
