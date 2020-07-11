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
	BabysitterDao babysitterDao;    //育婴师
	
	@Autowired
	BabysitterArrangeDao babysitterArrangeDao; //育婴师安排
	
	@Autowired
	ContractDao contractDao;   //合同
	
	@Autowired
	AppriseDao appriseDao;  //评价记录
	
	@Autowired
	InterviewDao interviewDao;  //回访记录
	
	@Autowired                  //用户
	UserDao userDao;
	
	/*育婴师简历操作*/
	public Babysitter getBabysitterById(int id) {      //通过id查询育婴师
		return babysitterDao.selectBabysitterById(id);
	}
	
	public Babysitter getBabysitterByName(String name) {
		return babysitterDao.selectBabysitterByName(name);
	}
	public List<Babysitter> getBabysitterlist() {            //获取所有育婴师
		return babysitterDao.selectBabysitterResume();
	}
	
	/*育婴师安排操作*/
	public int getBabysitterArrangelistCount() {         //获取育婴师安排表记录总数
		return babysitterArrangeDao.selectBabysitterArrangeCount();
	}
	
	public List<BabysitterArrange> getBabysitterArrangelist(Map<String,String> map)throws Exception{ //获取育婴师安排表所有记录
		
		int pageNo = map.get("pageNo") == null ? 0 : Integer.parseInt(map.get("pageNo")+"")-1;
		int pageSize = map.get("pageSize") == null ? 10 : Integer.parseInt(map.get("pageSize")+"");
		List<BabysitterArrange> babysitterArranges = babysitterArrangeDao.selectBabysitterArrangeList(pageNo*pageSize, pageSize);
		return babysitterArranges;
	}
	
	/*合同操作*/
	
	public int getContractlistCount() {      //获取合同记录总数
		return contractDao.selectContractCount();
	} 
	
	public List<Contract> getContractlist(Map<String, String> map) throws Exception{
		int pageNo = map.get("pageNo") == null ? 0 : Integer.parseInt(map.get("pageNo")+"")-1;
		int pageSize = map.get("pageSize") == null ? 10 : Integer.parseInt(map.get("pageSize")+"");
		List<Contract> contracts = contractDao.selectContractList(pageNo*pageSize, pageSize);
		return contracts;
	}
	
	/*服务过程操作*/
	public void addApprise(Apprise apprise) {  //添加评价记录操作
		appriseDao.addApprise(apprise);
	}
	
	public void addInterview(Interview interview) {  //添加评价记录操作
		interviewDao.addInterview(interview);
	}
	
	public User getUserByName(String username) {  //通过用户名获取用户
		return userDao.selectUserByName(username);
	}
	
	public void addBabysitterArrange(BabysitterArrange bArrange) {  //添加育婴安排
		babysitterArrangeDao.insertBabysitterArrange(bArrange);
	}
	
	public void updateUser(User user,String babysitterNamelist) //更新用户
	{
		userDao.updateUser(user, babysitterNamelist);
	}
	
	public void updateBabysitter(Babysitter babysitter) {     //更新育婴师
		
		babysitterDao.updateBabysitter(babysitter);
		
	}
}
