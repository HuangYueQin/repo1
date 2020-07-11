package com.maternalBabyManage.controller;

import java.io.PrintWriter;
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

import com.maternalBabyManage.domain.Babysitter;
import com.maternalBabyManage.domain.Contract;
import com.maternalBabyManage.domain.User;
import com.maternalBabyManage.service.BabysitterManageService;
import com.maternalBabyManage.service.ContractManageService;
import com.maternalBabyManage.service.UserManageService;


@Controller
@RequestMapping("/index")
public class IndexContractController {
	
	@Autowired
	ContractManageService contractManageService;
	
	@Autowired
	UserManageService UserManageService;
	
	@Autowired
	BabysitterManageService babysitterManageService;

	@RequestMapping("/toSignContract")         //��ҳ��תǩ����ͬҳ��
	public String toSignContract(HttpSession session,Model model) {
		String username = (String) session.getAttribute("username");
		User user = UserManageService.selectUserByName(username);
		if(null == user) {
			model.addAttribute("msg", "3.��δ��¼ϵͳ�����ȵ�¼���ٽ��в�����");
			return "/error";
		}else {
			model.addAttribute("user", user);
			return "/signContract";
		}
	}
	
	@RequestMapping("/signContract")           //ǩ����ͬ
	public void signContract(Contract contract,HttpServletResponse response) throws Exception {
        
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String babysitter = contract.getBabysitterName();
		Babysitter b = babysitterManageService.getBabysitter(babysitter);
		contract.setBabysitterTel(b.getTelphone());
		contractManageService.addContract(contract);
		out.println("<script>alert('��ͬ��ӳɹ���');location.href='../index';</script>");
	}
	
	@RequestMapping("/toViewContract")         //��ҳ��ת�鿴��ͬҳ��
	public String toViewContract() {
		return "/viewContract";
	}
	
	@RequestMapping("/getContractlistCount")
	public @ResponseBody int getContractlistCount(){  //��ȡ��ͬ�б�����
		return contractManageService.getContractListCount();
	}
	
	@RequestMapping("/contractlist")
	public @ResponseBody List<Contract> contractlist( @RequestParam Map<String, String> map){
		return contractManageService.getContractList(map);
	}
}
