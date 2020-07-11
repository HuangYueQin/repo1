package com.maternalBabyManage.dao;

import java.util.List;

import com.maternalBabyManage.domain.BabysitterArrange;

public interface BabysitterArrangeDao {
	
	public BabysitterArrange selectBabysitterArrangeById(int id);
	public BabysitterArrange selectBabysitterArrangeByName(String babysitterName);
	public List<BabysitterArrange> selectBabysitterArrangeList(int pageNo,int pageSize);
	public int selectBabysitterArrangeCount();
	public void insertBabysitterArrange(BabysitterArrange bArrange);

}
