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

	private int resumeNum = 1;  //��Ӥʦ���������ʼֵΪ�ڶ�������,���û����ʱ�����ת����һ������Ϊ76����resumeNum--������
	
	@RequestMapping("/selectBabysitter") //��ѯ��Ӥʦ
	public String selectBabysitters(String name,Model model)throws Exception {

		name = name.trim(); //���������Ӥʦ��Ķ���ո�
		if(StringUtil.equals(name, "")) {
			model.addAttribute("msg", "3.δ������Ӥʦ����!");
			model.addAttribute("isUser","true");
			return "/error";
		}
		Babysitter babysitter = babysitterManageService.getBabysitter(name);
		
		if(null == babysitter) {
			model.addAttribute("msg", "3.�������Ӥʦ���������ڣ�");
			return "/error";
		}
		model.addAttribute("babysitter", babysitter);
		model.addAttribute("time", DateFormatUtil.getFormatDate(babysitter.getWorkTime()));//ת�����ڸ�ʽ
		return "/babysitter";
	}

	@RequestMapping("/chooseBabysitter") //ѡ����Ӥʦҳ����ת
	public String chooseBabysitter(HttpSession session,Model model) {
		
		String username = (String) session.getAttribute("username");
		if(null == username) {
			model.addAttribute("msg", "3.��δ��¼ϵͳ�����ȵ�¼���ٽ��в�����");
			return "/error";
		}else {
			return "/chooseBabysitter";
		}
		
	}
	
	@RequestMapping("/babysitterlist") //��Ӥʦ��ҳ
	public @ResponseBody List<Babysitter> getBabysitterlist(@RequestParam Map<String,String> map){
		return babysitterManageService.getBabysitterlist(map);
	}
	
	@RequestMapping("/getBabysitterlistCount") //��������
	public @ResponseBody int getUserListCount() {
		return babysitterManageService.getBabysitterCount();
	}
	
	@RequestMapping("/toBabysitterResume") //��ҳ����鿴��Ӥʦ����
	public String toBabysitterResume(String Resume,Model model)throws Exception{
		List<Babysitter> babysitters = indexOperationService.getBabysitterlist();
		int total = babysitters.size(); //��ȡ��Ӥʦ�ܸ���
		if(StringUtil.equals(Resume, "1")) {   //��һ������
			resumeNum --;
			if(resumeNum == -1) {               //�ٽ�ѭ��
				resumeNum = total-1;
			}
		}else if(StringUtil.equals(Resume, "2")) { //��һ������
			resumeNum ++;
			if(resumeNum == total) {          //�ٽ�ѭ��
				resumeNum = 0;
			}
		}
		Babysitter babysitter  = babysitters.get(resumeNum);
		model.addAttribute("babysitter", babysitter);
		if(babysitter.getWorkTime()!= null) {
			model.addAttribute("time",DateFormatUtil.getFormatDate(babysitter.getWorkTime()));//ת����׼ʱ�䲢����
		}
        return "/babysitterResume";
	}
	
	/*@RequestMapping("/toBabysitterResume") //��ҳ����鿴��Ӥʦ���� (bug����)
	public String  toBabysitterResume(String Resume,Model model)throws Exception{
		
		int total = babysitterManageService.getBabysitterCount(); //��ȡ��Ӥʦ�ܸ���
		System.out.println(total);
		Babysitter babysitter = null;
	    
	    	if(StringUtil.equals(Resume, "1")) {   //��һ������
				resumeNum --;
				if(resumeNum == 0) {               //�ٽ�ѭ��
					resumeNum = total;
				}
			}else if(StringUtil.equals(Resume, "2")) { //��һ������
				resumeNum ++;
				if(resumeNum == total+1) {          //�ٽ�ѭ��
					resumeNum = 1;
				}
			}
	    	babysitter  = indexOperationService.getBabysitterById(resumeNum);
	    	
	    
		model.addAttribute("babysitter", babysitter);
		if(babysitter.getWorkTime()!= null) {
			model.addAttribute("time",DateFormatUtil.getFormatDate(babysitter.getWorkTime()));//ת����׼ʱ�䲢����
		}
        return "/babysitterResume";
	}
	*/
	
	@RequestMapping("/toBabysitterArrange")  //��ҳ��ת����Ӥʦ���Ž���
	public String toBabysitterArrange() {
		return "/babysitterArrange";
	}
	
	@RequestMapping("/getBabysitterArrangelistCount") //��ȡ��Ӥʦ���ű��¼����
	public @ResponseBody int getBabysitterArrangelistCount() {
		
		return indexOperationService.getBabysitterArrangelistCount();
	}
	
	@RequestMapping("/babysitterArrangelist")  //��ȡ��Ӥʦ���ű����м�¼
	public @ResponseBody List<BabysitterArrange> babysitterArrangelist(@RequestParam Map<String,String> map)throws Exception{
		
		return indexOperationService.getBabysitterArrangelist(map);
	}
	
	@RequestMapping("/toOrderBabysitter")    //��ת��ԤԼ��Ӥʦ����
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
			
			model.addAttribute("msg", "3.ϵͳ�����뷵�ص������档");
			return "/error";
		}
	}
	
	@RequestMapping("/orderBabysitter")   //ԤԼ��Ӥʦ
	public String orderBabysitter(BabysitterArrange bArrange,String childbirthDate,Model model)throws Exception {
		
		/*��ȡǰ̨��Ϣ*/
		String babysitterName = bArrange.getBabysitterName();
		String username = bArrange.getCustomer();
		String requestInfo = bArrange.getRequestInfo();
		Date requestDate = bArrange.getRequestDate();
		
		/*������Ϣ��ȡ�û�*/
		User user = indexOperationService.getUserByName(username);
		
		/*�����û���Ϣ*/
		user.setRequestDate(requestDate);
		user.setRequestInfo(requestInfo);
		user.setChildbirthDate(DateFormatUtil.toDate(childbirthDate));
		
		/*�����û��е���Ӥʦ��Ϣ*/
		StringBuilder babysitterlistListName = new StringBuilder();
		List<Babysitter> babysitterlist = user.getBabysitterlist();
		for(int i=0;i<babysitterlist.size();i++) {
			babysitterlistListName.append(babysitterlist.get(i).getBabysitterName()).append(",") ;
		}
		babysitterlistListName.append(babysitterName).append(",");
		
		indexOperationService.updateUser(user, babysitterlistListName.toString());
		indexOperationService.addBabysitterArrange(bArrange);  //��ӵ���Ӥʦ���ű�
		
		model.addAttribute("msg", "ԤԼ�ɹ���");
		return "/orderSuccess";
	}
}
