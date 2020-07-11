package com.maternalBabyManage.dao;

import java.util.List;

import com.maternalBabyManage.domain.Contract;


public interface ContractDao {
	
	public Contract selectContractById(int contractId);
	public Contract selectContractByCustomerName(String customerName);
	public Contract selectContractByBabysitterName(String babysitterName);
	public Contract selectContract(String username,String babysitter);
	public void addContract(Contract contract);
	public List<Contract> selectContractList(int pageNo,int pageSize);
	public int selectContractCount();
	public void deleteContract(int contractId);
	public void updateContract(Contract contract);

}
