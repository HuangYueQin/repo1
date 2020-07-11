package com.maternalBabyManage.dao;

import java.util.List;

import com.maternalBabyManage.domain.Babysitter;
import com.maternalBabyManage.domain.User;

public interface BabysitterDao {

	public Babysitter selectBabysitterByName(String babysitterName);
	public Babysitter selectBabysitterById(int id);
	public Babysitter selectBabysitterByUsername(String username);
	public void addBabysitter(Babysitter babysitter);
	public void updateBabysitter(Babysitter babysitter);
	public void deleteBabysitterByName(String babysitterName);
	public void deleteBabysitterById(int id);
	public List<Babysitter> selectBabysitterlist(int pageNo,int pageSize);//∑÷“≥≤È—Ø
	public int getBabysitterCount();
	public List<Babysitter> selectBabysitterResume();
}
