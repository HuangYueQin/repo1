package com.maternalBabyManage.service;


import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maternalBabyManage.dao.AppriseDao;
import com.maternalBabyManage.dao.BabysitterArrangeDao;
import com.maternalBabyManage.dao.BabysitterDao;
import com.maternalBabyManage.dao.ContractDao;
import com.maternalBabyManage.dao.InterviewDao;
import com.maternalBabyManage.dao.UserDao;
import com.maternalBabyManage.domain.Apprise;
import com.maternalBabyManage.domain.Babysitter;
import com.maternalBabyManage.domain.BabysitterArrange;
import com.maternalBabyManage.domain.Contract;
import com.maternalBabyManage.domain.Interview;
import com.maternalBabyManage.domain.User;

@Service
public class IndexOperationService {

	@Autowired
	BabysitterDao babysitterDao;    //��Ӥʦ
	
	@Autowired
	BabysitterArrangeDao babysitterArrangeDao; //��Ӥʦ����
	
	@Autowired
	ContractDao contractDao;   //��ͬ
	
	@Autowired
	AppriseDao appriseDao;  //���ۼ�¼
	
	@Autowired
	InterviewDao interviewDao;  //�طü�¼
	
	@Autowired                  //�û�
	UserDao userDao;
	
	/*��Ӥʦ��������*/
	public Babysitter getBabysitterById(int id) {      //ͨ��id��ѯ��Ӥʦ
		return babysitterDao.selectBabysitterById(id);
	}
	
	public Babysitter getBabysitterByName(String name) {
		return babysitterDao.selectBabysitterByName(name);
	}
	public List<Babysitter> getBabysitterlist() {            //��ȡ������Ӥʦ
		return babysitterDao.selectBabysitterResume();
	}
	
	/*��Ӥʦ���Ų���*/
	public int getBabysitterArrangelistCount() {         //��ȡ��Ӥʦ���ű��¼����
		return babysitterArrangeDao.selectBabysitterArrangeCount();
	}
	
	public List<BabysitterArrange> getBabysitterArrangelist(Map<String,String> map)throws Exception{ //��ȡ��Ӥʦ���ű����м�¼
		
		int pageNo = map.get("pageNo") == null ? 0 : Integer.parseInt(map.get("pageNo")+"")-1;
		int pageSize = map.get("pageSize") == null ? 10 : Integer.parseInt(map.get("pageSize")+"");
		List<BabysitterArrange> babysitterArranges = babysitterArrangeDao.selectBabysitterArrangeList(pageNo*pageSize, pageSize);
		return babysitterArranges;
	}
	
	/*��ͬ����*/
	
	public int getContractlistCount() {      //��ȡ��ͬ��¼����
		return contractDao.selectContractCount();
	} 
	
	public List<Contract> getContractlist(Map<String, String> map) throws Exception{
		int pageNo = map.get("pageNo") == null ? 0 : Integer.parseInt(map.get("pageNo")+"")-1;
		int pageSize = map.get("pageSize") == null ? 10 : Integer.parseInt(map.get("pageSize")+"");
		List<Contract> contracts = contractDao.selectContractList(pageNo*pageSize, pageSize);
		return contracts;
	}
	
	/*������̲���*/
	public void addApprise(Apprise apprise) {  //������ۼ�¼����
		appriseDao.addApprise(apprise);
	}
	
	public void addInterview(Interview interview) {  //������ۼ�¼����
		interviewDao.addInterview(interview);
	}
	
	public User getUserByName(String username) {  //ͨ���û�����ȡ�û�
		return userDao.selectUserByName(username);
	}
	
	public void addBabysitterArrange(BabysitterArrange bArrange) {  //�����Ӥ����
		babysitterArrangeDao.insertBabysitterArrange(bArrange);
	}
	
	public void updateUser(User user,String babysitterNamelist) //�����û�
	{
		userDao.updateUser(user, babysitterNamelist);
	}
	
	public void updateBabysitter(Babysitter babysitter) {     //������Ӥʦ
		
		babysitterDao.updateBabysitter(babysitter);
		
	}
}
