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
	
	@RequestMapping("/selectBabysitter") //����Ա������Ӥʦ����
	public String selectBabysitter(String name,Model model)throws Exception {
		
		String tempName = name.trim().replaceAll("\"", ""); //ȥ��ǰ��ո��˫����
		Babysitter babysitter = babysitterManageService.getBabysitter(tempName);
		if(null == babysitter) {
			model.addAttribute("msg", "3.�������Ӥʦ�����ڣ�");
			return "/adminError";
		}
		if(babysitter.getWorkTime()!=null) {
			model.addAttribute("time", DateFormatUtil.getFormatDate(babysitter.getWorkTime()));//ת�����ڸ�ʽ
		}
		model.addAttribute("babysitter", babysitter);
		return "/adminSelectBabysitter";
	}
	@RequestMapping("/toAddBabysitter")  //��ת�����Ӥʦ����
	public String toAddBabysitter() {
		return "/adminAddBabysitter";
	}
	@RequestMapping("/addBabysitter")    //�����Ӥʦ
	public String addBabysitter(Babysitter babysitter,Model model) throws Exception {
		
		/*���ȡͼƬ*/
		String sex = babysitter.getSex();          //��ȡ�Ա�
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
		babysitter.setPhotoSrc(picSrc.toString());
		
		babysitterManageService.addBabysitter(babysitter);
		model.addAttribute("msg", "��ӳɹ���");
		return "/success";
	}
	
	@RequestMapping("/deleteBabysitter")    //ɾ����Ӥʦ
	public String deleteBabysitter(String name,Model model) throws Exception {
		
		
		String tempName = name.trim();//ȥ�����˿ո�
		Babysitter babysitter = babysitterManageService.getBabysitter(name);
		if(null == babysitter) {
			model.addAttribute("msg", "3.�������Ӥʦ�����ڣ�");
			return "/adminError";
		}
		babysitterManageService.deleteBabysitter(tempName);
		model.addAttribute("msg", "ɾ���ɹ���");
		return "/success";
	}
	
	@RequestMapping("/toUpdateBabysitter") //��ת��������Ӥʦ����
	public String toUpdateBabysitter(String name,Model model)throws Exception {
		
		String tempName = name.trim(); //ȥ��ǰ�����ո�
		Babysitter babysitter = babysitterManageService.getBabysitter(tempName);
		if(null == babysitter) {
			model.addAttribute("msg", "3.�������Ӥʦ�����ڣ�");
			return "/adminError";
		}
		if(babysitter.getWorkTime()!=null) {
			model.addAttribute("time", DateFormatUtil.getFormatDate(babysitter.getWorkTime()));//ת�����ڸ�ʽ
		}
		model.addAttribute("babysitter", babysitter);
		return "/adminUpdateBabysitter";
	}

	@RequestMapping("/updateBabysitter") //������Ӥʦ��Ϣ����
	public ModelAndView updateBabysitter(Babysitter babysitter)throws Exception {
		
		babysitterManageService.updateBabysitter(babysitter);
		ModelAndView mView  = new ModelAndView();
		mView.addObject("msg", "���ĳɹ���");
		mView.setViewName("/success");
		return mView;
	}
}
