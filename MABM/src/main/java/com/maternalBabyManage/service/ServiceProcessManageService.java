package com.maternalBabyManage.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maternalBabyManage.dao.AppriseDao;
import com.maternalBabyManage.dao.InterviewDao;
import com.maternalBabyManage.domain.Apprise;
import com.maternalBabyManage.domain.Interview;
import com.maternalBabyManage.domain.User;

@Service
public class ServiceProcessManageService {

	@Autowired 
	InterviewDao interviewDao;
	
	@Autowired
	AppriseDao appriseDao;
	
	public int getInterviewListCount() {      //获取回访记录总数
		return interviewDao.selectInterviewListCount();
	}
	
	public int getAppriseListCount() {        //获取评价记录总数
		return appriseDao.selectAppriseListCount();
	}
	
	public List<Interview> getInterviewlist(Map<String, String> map){     //获取回访记录
		
		int pageNo = map.get("pageNo") == null ? 0 : Integer.parseInt(map.get("pageNo")+"")-1; //从第0条记录开始
		int pageSize = map.get("pageSize") == null ? 10 : Integer.parseInt(map.get("pageSize")+""); //每页个数
		List<Interview> interviewlist = interviewDao.selectInterviewList(pageNo*pageSize,pageSize); //分页
		return interviewlist;
	}
	
    public List<Apprise> getAppriselist(Map<String, String> map){         //获取评价记录
		
		int pageNo = map.get("pageNo") == null ? 0 : Integer.parseInt(map.get("pageNo")+"")-1; //从第0条记录开始
		int pageSize = map.get("pageSize") == null ? 10 : Integer.parseInt(map.get("pageSize")+""); //每页个数
		List<Apprise> appriselist = appriseDao.selectAppriseList(pageNo*pageSize,pageSize); //分页
		return appriselist;
	}
    
    public void deleteInterviewById(int id) {              //通过回访id删除回访记录
    	interviewDao.deleteInterviewById(id);
    }
    public void deleteAppriseById(int id) {               //通过评价id获删除价记录
    	appriseDao.deleteApriseById(id);
    }
    
    public Interview getInterviewById(int id) {          //通过回访id获取回访记录
    	return interviewDao.selectInterviewById(id);
    }
    
    public Apprise getAppriseById(int id) {              //通过评价id获取评价记录
    	return appriseDao.selectAppriseById(id);
    }
    
    public void updateInterview(Interview interview) {   //更新回访记录
    	interviewDao.updateInterview(interview);
    }
    
    public void updateApprise(Apprise apprise) {   //更新评价记录
    	appriseDao.updateApprise(apprise);
    }
    
}
