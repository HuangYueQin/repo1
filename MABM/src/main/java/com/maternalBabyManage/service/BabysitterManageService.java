package com.maternalBabyManage.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maternalBabyManage.dao.BabysitterDao;
import com.maternalBabyManage.domain.Babysitter;

@Service
public class BabysitterManageService {

	@Autowired
	BabysitterDao babysitterDao;
	
	public Babysitter getBabysitter(String name) {
		
		return babysitterDao.selectBabysitterByName(name);
	}
	public List<Babysitter> getBabysitterlist(Map<String,String> map){  //分页查询
		int pageNo = map.get("pageNo") == null ? 0 : Integer.parseInt(map.get("pageNo")+"")-1;
		int pageSize = map.get("pageSize") == null ? 10 : Integer.parseInt(map.get("pageSize")+"");
		return babysitterDao.selectBabysitterlist(pageNo*pageSize, pageSize);
	}
	public int getBabysitterCount() {//查询总数
		return babysitterDao.getBabysitterCount();
	}
	
	public void addBabysitter(Babysitter babysitter) {  //添加育婴师
		 babysitterDao.addBabysitter(babysitter);
	}
	public void deleteBabysitter(String babysitterName) {  //删除育婴师
		 babysitterDao.deleteBabysitterByName(babysitterName);
	}
	public void updateBabysitter(Babysitter babysitter) {  //更改育婴师信息
		babysitterDao.updateBabysitter(babysitter);
	}
}
