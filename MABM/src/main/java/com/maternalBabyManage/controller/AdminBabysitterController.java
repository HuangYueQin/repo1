package com.maternalBabyManage.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.maternalBabyManage.domain.Babysitter;
import com.maternalBabyManage.service.BabysitterManageService;
import com.maternalBabyManage.util.DateFormatUtil;
import com.maternalBabyManage.util.StringUtil;
@Controller
public class AdminBabysitterController {
	
	@Autowired
	BabysitterManageService babysitterManageService;
	
	@RequestMapping("/selectBabysitter") //管理员搜素育婴师界面
	public String selectBabysitter(String name,Model model)throws Exception {
		
		String tempName = name.trim().replaceAll("\"", ""); //去除前后空格和双引号
		Babysitter babysitter = babysitterManageService.getBabysitter(tempName);
		if(null == babysitter) {
			model.addAttribute("msg", "3.输入的育婴师不存在！");
			return "/adminError";
		}
		if(babysitter.getWorkTime()!=null) {
			model.addAttribute("time", DateFormatUtil.getFormatDate(babysitter.getWorkTime()));//转换日期格式
		}
		model.addAttribute("babysitter", babysitter);
		return "/adminSelectBabysitter";
	}
	@RequestMapping("/toAddBabysitter")  //跳转添加育婴师界面
	public String toAddBabysitter() {
		return "/adminAddBabysitter";
	}
	@RequestMapping("/addBabysitter")    //添加育婴师
	public String addBabysitter(Babysitter babysitter,Model model) throws Exception {
		
		/*随机取图片*/
		String sex = babysitter.getSex();          //获取性别
		StringBuilder picSrc = new StringBuilder();
		int picIndex = 0;                   //图片下标
		if(StringUtil.equals(sex, "男")) {  //D盘毕业设计文件中icon对应男为22张照片，随机下标取1~22
			picSrc.append("male");
			picIndex = (int)(1+Math.random()*(22));
		}else {                           //女对应的为1~10
			picSrc.append("female");
			picIndex = (int)(1+Math.random()*(10)); //Math.random()取值为[0,1)
		}
		picSrc.append(picIndex);
		babysitter.setPhotoSrc(picSrc.toString());
		
		babysitterManageService.addBabysitter(babysitter);
		model.addAttribute("msg", "添加成功！");
		return "/success";
	}
	
	@RequestMapping("/deleteBabysitter")    //删除育婴师
	public String deleteBabysitter(String name,Model model) throws Exception {
		
		
		String tempName = name.trim();//去除两端空格
		Babysitter babysitter = babysitterManageService.getBabysitter(name);
		if(null == babysitter) {
			model.addAttribute("msg", "3.输入的育婴师不存在！");
			return "/adminError";
		}
		babysitterManageService.deleteBabysitter(tempName);
		model.addAttribute("msg", "删除成功！");
		return "/success";
	}
	
	@RequestMapping("/toUpdateBabysitter") //跳转到更改育婴师界面
	public String toUpdateBabysitter(String name,Model model)throws Exception {
		
		String tempName = name.trim(); //去除前后多余空格
		Babysitter babysitter = babysitterManageService.getBabysitter(tempName);
		if(null == babysitter) {
			model.addAttribute("msg", "3.输入的育婴师不存在！");
			return "/adminError";
		}
		if(babysitter.getWorkTime()!=null) {
			model.addAttribute("time", DateFormatUtil.getFormatDate(babysitter.getWorkTime()));//转换日期格式
		}
		model.addAttribute("babysitter", babysitter);
		return "/adminUpdateBabysitter";
	}

	@RequestMapping("/updateBabysitter") //更改育婴师信息操作
	public ModelAndView updateBabysitter(Babysitter babysitter)throws Exception {
		
		babysitterManageService.updateBabysitter(babysitter);
		ModelAndView mView  = new ModelAndView();
		mView.addObject("msg", "更改成功！");
		mView.setViewName("/success");
		return mView;
	}
}
