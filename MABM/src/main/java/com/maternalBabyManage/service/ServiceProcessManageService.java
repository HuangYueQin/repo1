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
	
	public int getInterviewListCount() {      //��ȡ�طü�¼����
		return interviewDao.selectInterviewListCount();
	}
	
	public int getAppriseListCount() {        //��ȡ���ۼ�¼����
		return appriseDao.selectAppriseListCount();
	}
	
	public List<Interview> getInterviewlist(Map<String, String> map){     //��ȡ�طü�¼
		
		int pageNo = map.get("pageNo") == null ? 0 : Integer.parseInt(map.get("pageNo")+"")-1; //�ӵ�0����¼��ʼ
		int pageSize = map.get("pageSize") == null ? 10 : Integer.parseInt(map.get("pageSize")+""); //ÿҳ����
		List<Interview> interviewlist = interviewDao.selectInterviewList(pageNo*pageSize,pageSize); //��ҳ
		return interviewlist;
	}
	
    public List<Apprise> getAppriselist(Map<String, String> map){         //��ȡ���ۼ�¼
		
		int pageNo = map.get("pageNo") == null ? 0 : Integer.parseInt(map.get("pageNo")+"")-1; //�ӵ�0����¼��ʼ
		int pageSize = map.get("pageSize") == null ? 10 : Integer.parseInt(map.get("pageSize")+""); //ÿҳ����
		List<Apprise> appriselist = appriseDao.selectAppriseList(pageNo*pageSize,pageSize); //��ҳ
		return appriselist;
	}
    
    public void deleteInterviewById(int id) {              //ͨ���ط�idɾ���طü�¼
    	interviewDao.deleteInterviewById(id);
    }
    public void deleteAppriseById(int id) {               //ͨ������id��ɾ���ۼ�¼
    	appriseDao.deleteApriseById(id);
    }
    
    public Interview getInterviewById(int id) {          //ͨ���ط�id��ȡ�طü�¼
    	return interviewDao.selectInterviewById(id);
    }
    
    public Apprise getAppriseById(int id) {              //ͨ������id��ȡ���ۼ�¼
    	return appriseDao.selectAppriseById(id);
    }
    
    public void updateInterview(Interview interview) {   //���»طü�¼
    	interviewDao.updateInterview(interview);
    }
    
    public void updateApprise(Apprise apprise) {   //�������ۼ�¼
    	appriseDao.updateApprise(apprise);
    }
    
}
