package com.maternalBabyManage.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.maternalBabyManage.dao.BabysitterDao;
import com.maternalBabyManage.domain.Contract;
import com.maternalBabyManage.service.ContractManageService;
import com.maternalBabyManage.util.DateFormatUtil;
import com.maternalBabyManage.util.StringUtil;

@Controller
public class AdminContractController {

	@Autowired
	ContractManageService contractManageService;
	
	@Autowired
	BabysitterDao BabysitterDao;
	
	@RequestMapping("/contractlist")  //��ҳ 
	public @ResponseBody List<Contract> contractlist(@RequestParam Map<String,String> map){

		return contractManageService.getContractList(map);
	}
	
	@RequestMapping("/getContractListCount") //��������
	public @ResponseBody int getContractListCount() {
		
		return contractManageService.getContractListCount();
	}
	
	@RequestMapping("/deleteContract") //ɾ����ͬ
	public @ResponseBody int deleteContract(String contractId) {
		
		int id = StringUtil.toInt(contractId);
		contractManageService.deleteContract(id);
		return 1;   //ɾ���ɹ����ر�־��1
	}
	
	@RequestMapping("/toUpdateContract")  //��ת�����º�ͬҳ��
	public ModelAndView updateContract(String contractId)throws Exception {
		
		int id = StringUtil.toInt(contractId);
		Contract contract = contractManageService.selectContractById(id);
		
		/*��ȡʱ�䲢ת��Ϊ��׼��ʽ*/
		String contractTime = DateFormatUtil.getFormatDate(contract.getContractTime());
		String childBirthday = DateFormatUtil.getFormatDate(contract.getChildBirthday());
		String serviceTime = DateFormatUtil.getFormatDate(contract.getServiceTime());
		
		/*����timeMap����*/
		Map<String, String> timeMap = new HashMap<String, String>();
		timeMap.put("contractTime", contractTime);
		timeMap.put("childBirthday", childBirthday);
		timeMap.put("serviceTime", serviceTime);
		
		ModelAndView mView = new ModelAndView();
		
	    /*���͵�ǰ��*/
		mView.addObject("timeMap", timeMap);
		mView.addObject("contract", contract);
		mView.setViewName("/adminUpdateContract");
		return mView;
	}
	
	@RequestMapping("/updateContract")          //���º�ͬ��Ϣ
	public String updateContract(Contract contract,Model model) {
		
		contractManageService.updateContract(contract);
		model.addAttribute("msg", "���³ɹ�");
		return "/success";
		
	}
	
	@RequestMapping("/selectContract")
	public @ResponseBody Contract selectContract(@RequestBody String input,Model model){
	
		String tempName = input.trim().replaceAll("\"", "");    //ȥ����β�ո��Լ�����˫����
		String [] templist = tempName.split(",");
		String username = templist[0];
		if(templist.length>1) {        //���û�ֻ��һ��������Ӥʦ�������û������������ѯ�������򷵻�null���ص�ajax error��������
			String babysitter = templist[1].trim();     //���û�������������ѯ����ʱִ�в�ѯ����
			Contract contract = contractManageService.selectContract(username, babysitter);
			if(null == contract) {               //��ѯ���Ϊ��˵����ѯ��ͬ�����ڣ�����null,��error�����б���������
				return null;
			}else {
				return contract;                //��ѯ���ˣ����ص�success����
			}
		}else {
			return null;
		}
	}
}
