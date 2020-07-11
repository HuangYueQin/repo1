package com.maternalBabyManage.dao;

import java.util.List;
import com.maternalBabyManage.domain.Interview;

public interface InterviewDao {
	
	public void addInterview(Interview interview);
	public int selectInterviewListCount();
	public List<Interview> selectInterviewList(int pageNo,int pageSize);
	public void deleteInterviewById(int id);
	public Interview selectInterviewById(int id);
	public void updateInterview(Interview interview);

}
