package com.maternalBabyManage.dao;

import java.util.List;

import com.maternalBabyManage.domain.Apprise;

public interface AppriseDao {
	
	public void addApprise(Apprise apprise);
	public int selectAppriseListCount();
	public List<Apprise> selectAppriseList(int pageNo,int pageSize);
	public void deleteApriseById(int id);
	public Apprise selectAppriseById(int id);
	public void updateApprise(Apprise apprise);

}
