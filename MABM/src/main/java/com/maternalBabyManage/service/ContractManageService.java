package com.maternalBabyManage.service;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.maternalBabyManage.dao.ContractDao;
import com.maternalBabyManage.domain.Contract;


@Service
public class ContractManageService {

	@Autowired
	ContractDao contractDao;
	
   public List<Contract> getContractList(Map<String,String> map){
		
		int pageNo = map.get("pageNo") == null ? 0 : Integer.parseInt(map.get("pageNo")+"")-1;
		int pageSize = map.get("pageSize") == null ? 10 : Integer.parseInt(map.get("pageSize")+"");
		List<Contract> contractlist = contractDao.selectContractList(pageNo*pageSize, pageSize);
		return contractlist;
	}
	
	public int getContractListCount () {
		
		return contractDao.selectContractCount();
	}
	
	public void deleteContract(int contractId) {
		contractDao.deleteContract(contractId);
	}
	
	public Contract selectContractById(int contractId) {
		
		return contractDao.selectContractById(contractId);
	}
	public Contract selectContract(String username,String babysitter) {
		return contractDao.selectContract(username, babysitter);
	}
	public void updateContract(Contract contract) {
		contractDao.updateContract(contract);
	}
	
	public void addContract(Contract contract) {
		contractDao.addContract(contract);
	}
}
