package com.maternalBabyManage.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.maternalBabyManage.domain.Babysitter;
import com.maternalBabyManage.domain.User;
import com.maternalBabyManage.service.BabysitterManageService;
import com.maternalBabyManage.service.UserManageService;
import com.maternalBabyManage.util.DateFormatUtil;
import com.maternalBabyManage.util.StringUtil;
@Controller
public class AdminUserController {
	
	@Autowired
	UserManageService userManageService;
	
	@Autowired
	BabysitterManageService babysitterManageService;
	
	@RequestMapping("/userlist")  //分页 
	public @ResponseBody List<User> userlist(@RequestParam Map<String,String> map){
		
		return userManageService.getUserList(map);
	}
	
	@RequestMapping("/getUserListCount") //计算总数
	public @ResponseBody int getUserListCount() {
		
		return userManageService.getUserListCount();
	}
	
	@RequestMapping("/deleteUser") //删除user
	public @ResponseBody int deleteUser(@RequestBody String userId) {
		int id = StringUtil.toInt(userId); 
		userManageService.deleteUserById(id);
		return 1;   //删除成功返回标志数1
	}
	
	@RequestMapping("/selectUserById")  //分页表格点击查看操作,通过用户id查询user
	public String selectUserById(String Id,Model model)throws Exception {
		
		int id = StringUtil.toInt(Id);
		User user = userManageService.selectUserById(id);
		
		/*随机取图片*/
		String sex = user.getSex();          //获取性别
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
		
		Map<String,String> map = new HashMap<String, String>();
		if(user.getBabysitterlist()!= null) {
			map.put("birthday", DateFormatUtil.getFormatDate(user.getBirthday()));
		}
		if(user.getChildbirthDate()!=null) {
			map.put("childbirthDate", DateFormatUtil.getFormatDate(user.getChildbirthDate()));
		}
		if(user.getRequestDate()!=null) {
			map.put("requestDate", DateFormatUtil.getFormatDate(user.getRequestDate()));
		}
		map.put("picSrc", picSrc.toString());
		
		model.addAttribute("user", user);
		model.addAttribute("map",map);
		return "/userInfo";
	}
	
	@RequestMapping("/selectUserByName") //管理员搜素用户界面,通过用户名查用户
	public String selectUserByName(String name,Model model)throws Exception {
		
		String tempName = name.trim().replaceAll("\"", ""); //去除前后空格和双引号
		User user = userManageService.selectUserByName(tempName);
		if(null == user) {
			model.addAttribute("msg", "3.输入的用户名不存在！");
			return "/adminError";
		}
		
		/*随机取图片*/
		String sex = user.getSex();          //获取性别
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
		
		/*存入数据到map*/
		Map<String,String> map = new HashMap<String, String>();
		if(user.getBabysitterlist()!= null) {
			map.put("birthday", DateFormatUtil.getFormatDate(user.getBirthday()));
		}
		if(user.getChildbirthDate()!=null) {
			map.put("childbirthDate", DateFormatUtil.getFormatDate(user.getChildbirthDate()));
		}
		if(user.getRequestDate()!=null) {
			map.put("requestDate", DateFormatUtil.getFormatDate(user.getRequestDate()));
		}
		map.put("picSrc", picSrc.toString());
		
		/*发送数据到前端*/
		model.addAttribute("user", user);
		model.addAttribute("map",map);
		return "/userInfo";
	}
	@RequestMapping("/toUpdateUser")
	public String toUpdateUser(String Id,Model model) throws Exception{  //跳转更改育婴师信息界面,分页表格点击进入不需要判断用户是否存在
		
		int id = StringUtil.toInt(Id);
		User user = userManageService.selectUserById(id);
		Map<String,String> map = new HashMap<String, String>();
		if(user.getBabysitterlist()!= null) {
			map.put("birthday", DateFormatUtil.getFormatDate(user.getBirthday()));
		}
		if(user.getChildbirthDate()!=null) {
			map.put("childbirthDate", DateFormatUtil.getFormatDate(user.getChildbirthDate()));
		}
		if(user.getRequestDate()!=null) {
			map.put("requestDate", DateFormatUtil.getFormatDate(user.getRequestDate()));
		}
		model.addAttribute("user", user);
		model.addAttribute("timeMap",map);
		
		return "/adminUpdateUser";
	}
	
	@RequestMapping("/updateUser")
	public String updateUser(User user,String babysitterName,Model model) {
		
		String [] namelist = babysitterName.split(",");
		List<Babysitter> babysitterlist = new ArrayList<Babysitter>();
		for(int i= 0; i<namelist.length;i++) {          
			String tempName = namelist[i].trim();
			Babysitter babysitter = babysitterManageService.getBabysitter(tempName);
			if(null == babysitter) {
				model.addAttribute("msg", "您输入添加的育婴师名有误！");
				return "/adminError";
			}else {
				babysitter.setUserlist(user.getName());      //育婴师表添加用户名
				babysitterManageService.updateBabysitter(babysitter);
				
				babysitterlist.add(babysitter);
			}
		}
		StringBuffer babysitterNamelist = new StringBuffer();
		if(!StringUtil.equals(babysitterName.trim(), "无")) { //将育婴师添加到用户中
			user.setBabysitterlist(babysitterlist);
			for(int i=0;i<babysitterlist.size();i++) {
				babysitterNamelist.append(babysitterlist.get(i).getBabysitterName()).append(",") ;
			}
		}
		
		userManageService.updateUser(user,babysitterNamelist.toString());
		model.addAttribute("msg", "更改成功！");
		return "/success";
	}
	
}
