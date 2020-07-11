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
	public List<Babysitter> getBabysitterlist(Map<String,String> map){  //��ҳ��ѯ
		int pageNo = map.get("pageNo") == null ? 0 : Integer.parseInt(map.get("pageNo")+"")-1;
		int pageSize = map.get("pageSize") == null ? 10 : Integer.parseInt(map.get("pageSize")+"");
		return babysitterDao.selectBabysitterlist(pageNo*pageSize, pageSize);
	}
	public int getBabysitterCount() {//��ѯ����
		return babysitterDao.getBabysitterCount();
	}
	
	public void addBabysitter(Babysitter babysitter) {  //�����Ӥʦ
		 babysitterDao.addBabysitter(babysitter);
	}
	public void deleteBabysitter(String babysitterName) {  //ɾ����Ӥʦ
		 babysitterDao.deleteBabysitterByName(babysitterName);
	}
	public void updateBabysitter(Babysitter babysitter) {  //������Ӥʦ��Ϣ
		babysitterDao.updateBabysitter(babysitter);
	}
}
