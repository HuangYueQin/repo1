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
	
	@RequestMapping("/userlist")  //��ҳ 
	public @ResponseBody List<User> userlist(@RequestParam Map<String,String> map){
		
		return userManageService.getUserList(map);
	}
	
	@RequestMapping("/getUserListCount") //��������
	public @ResponseBody int getUserListCount() {
		
		return userManageService.getUserListCount();
	}
	
	@RequestMapping("/deleteUser") //ɾ��user
	public @ResponseBody int deleteUser(@RequestBody String userId) {
		int id = StringUtil.toInt(userId); 
		userManageService.deleteUserById(id);
		return 1;   //ɾ���ɹ����ر�־��1
	}
	
	@RequestMapping("/selectUserById")  //��ҳ������鿴����,ͨ���û�id��ѯuser
	public String selectUserById(String Id,Model model)throws Exception {
		
		int id = StringUtil.toInt(Id);
		User user = userManageService.selectUserById(id);
		
		/*���ȡͼƬ*/
		String sex = user.getSex();          //��ȡ�Ա�
		StringBuilder picSrc = new StringBuilder();
		int picIndex = 0;                   //ͼƬ�±�
		if(StringUtil.equals(sex, "��")) {  //D�̱�ҵ����ļ���icon��Ӧ��Ϊ22����Ƭ������±�ȡ1~22
			picSrc.append("male");
			picIndex = (int)(1+Math.random()*(22));
		}else {                           //Ů��Ӧ��Ϊ1~10
			picSrc.append("female");
			picIndex = (int)(1+Math.random()*(10)); //Math.random()ȡֵΪ[0,1)
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
	
	@RequestMapping("/selectUserByName") //����Ա�����û�����,ͨ���û������û�
	public String selectUserByName(String name,Model model)throws Exception {
		
		String tempName = name.trim().replaceAll("\"", ""); //ȥ��ǰ��ո��˫����
		User user = userManageService.selectUserByName(tempName);
		if(null == user) {
			model.addAttribute("msg", "3.������û��������ڣ�");
			return "/adminError";
		}
		
		/*���ȡͼƬ*/
		String sex = user.getSex();          //��ȡ�Ա�
		StringBuilder picSrc = new StringBuilder();
		int picIndex = 0;                   //ͼƬ�±�
		if(StringUtil.equals(sex, "��")) {  //D�̱�ҵ����ļ���icon��Ӧ��Ϊ22����Ƭ������±�ȡ1~22
			picSrc.append("male");
			picIndex = (int)(1+Math.random()*(22));
		}else {                           //Ů��Ӧ��Ϊ1~10
			picSrc.append("female");
			picIndex = (int)(1+Math.random()*(10)); //Math.random()ȡֵΪ[0,1)
		}
		picSrc.append(picIndex);
		
		/*�������ݵ�map*/
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
		
		/*�������ݵ�ǰ��*/
		model.addAttribute("user", user);
		model.addAttribute("map",map);
		return "/userInfo";
	}
	@RequestMapping("/toUpdateUser")
	public String toUpdateUser(String Id,Model model) throws Exception{  //��ת������Ӥʦ��Ϣ����,��ҳ��������벻��Ҫ�ж��û��Ƿ����
		
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
				model.addAttribute("msg", "��������ӵ���Ӥʦ������");
				return "/adminError";
			}else {
				babysitter.setUserlist(user.getName());      //��Ӥʦ������û���
				babysitterManageService.updateBabysitter(babysitter);
				
				babysitterlist.add(babysitter);
			}
		}
		StringBuffer babysitterNamelist = new StringBuffer();
		if(!StringUtil.equals(babysitterName.trim(), "��")) { //����Ӥʦ��ӵ��û���
			user.setBabysitterlist(babysitterlist);
			for(int i=0;i<babysitterlist.size();i++) {
				babysitterNamelist.append(babysitterlist.get(i).getBabysitterName()).append(",") ;
			}
		}
		
		userManageService.updateUser(user,babysitterNamelist.toString());
		model.addAttribute("msg", "���ĳɹ���");
		return "/success";
	}
	
}
