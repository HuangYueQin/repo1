package com.maternalBabyManage.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

@Component
public class Apprise {
	private int id;
	private String userName;
	private String babysitterName;
	private String appriseScore;
	private String appriseInfo;
	private String appriseRecommend;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")              //将时间按照标准格式存入数据库
	@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")   //数据库取出时间按照标准格式发送到前端
	private Date appriseTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getBabysitterName() {
		return babysitterName;
	}

	public void setBabysitterName(String babysitterName) {
		this.babysitterName = babysitterName;
	}

	public String getAppriseScore() {
		return appriseScore;
	}

	public void setAppriseScore(String appriseScore) {
		this.appriseScore = appriseScore;
	}

	public String getAppriseInfo() {
		return appriseInfo;
	}

	public void setAppriseInfo(String appriseInfo) {
		this.appriseInfo = appriseInfo;
	}

	public String getAppriseRecommend() {
		return appriseRecommend;
	}

	public void setAppriseRecommend(String appriseRecommend) {
		this.appriseRecommend = appriseRecommend;
	}

	public Date getAppriseTime() {
		return appriseTime;
	}

	public void setAppriseTime(Date appriseTime) {
		this.appriseTime = appriseTime;
	}

	@Override
	public String toString() {
		return "Apprise [id=" + id + ", userName=" + userName + ", babysitterName=" + babysitterName + ", appriseScore="
				+ appriseScore + ", appriseInfo=" + appriseInfo + ", appriseRecommend=" + appriseRecommend
				+ ", appriseTime=" + appriseTime + "]";
	}
	
}
