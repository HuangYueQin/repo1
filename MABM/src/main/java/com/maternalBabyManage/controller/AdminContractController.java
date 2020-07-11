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
	
	@RequestMapping("/contractlist")  //分页 
	public @ResponseBody List<Contract> contractlist(@RequestParam Map<String,String> map){

		return contractManageService.getContractList(map);
	}
	
	@RequestMapping("/getContractListCount") //计算总数
	public @ResponseBody int getContractListCount() {
		
		return contractManageService.getContractListCount();
	}
	
	@RequestMapping("/deleteContract") //删除合同
	public @ResponseBody int deleteContract(String contractId) {
		
		int id = StringUtil.toInt(contractId);
		contractManageService.deleteContract(id);
		return 1;   //删除成功返回标志数1
	}
	
	@RequestMapping("/toUpdateContract")  //跳转到更新合同页面
	public ModelAndView updateContract(String contractId)throws Exception {
		
		int id = StringUtil.toInt(contractId);
		Contract contract = contractManageService.selectContractById(id);
		
		/*获取时间并转换为标准格式*/
		String contractTime = DateFormatUtil.getFormatDate(contract.getContractTime());
		String childBirthday = DateFormatUtil.getFormatDate(contract.getChildBirthday());
		String serviceTime = DateFormatUtil.getFormatDate(contract.getServiceTime());
		
		/*存入timeMap对象*/
		Map<String, String> timeMap = new HashMap<String, String>();
		timeMap.put("contractTime", contractTime);
		timeMap.put("childBirthday", childBirthday);
		timeMap.put("serviceTime", serviceTime);
		
		ModelAndView mView = new ModelAndView();
		
	    /*发送到前端*/
		mView.addObject("timeMap", timeMap);
		mView.addObject("contract", contract);
		mView.setViewName("/adminUpdateContract");
		return mView;
	}
	
	@RequestMapping("/updateContract")          //更新合同信息
	public String updateContract(Contract contract,Model model) {
		
		contractManageService.updateContract(contract);
		model.addAttribute("msg", "更新成功");
		return "/success";
		
	}
	
	@RequestMapping("/selectContract")
	public @ResponseBody Contract selectContract(@RequestBody String input,Model model){
	
		String tempName = input.trim().replaceAll("\"", "");    //去除首尾空格以及两边双引号
		String [] templist = tempName.split(",");
		String username = templist[0];
		if(templist.length>1) {        //当用户只单一输入了育婴师名或者用户名，不满足查询条件，则返回null，回到ajax error函数报错
			String babysitter = templist[1].trim();     //当用户输入了两个查询条件时执行查询函数
			Contract contract = contractManageService.selectContract(username, babysitter);
			if(null == contract) {               //查询结果为空说明查询合同不存在，返回null,在error函数中报出不存在
				return null;
			}else {
				return contract;                //查询到了，返回到success函数
			}
		}else {
			return null;
		}
	}
}
