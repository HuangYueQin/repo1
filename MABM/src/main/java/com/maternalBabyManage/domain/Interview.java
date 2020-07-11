package com.maternalBabyManage.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

@Component
public class Interview {
	
	private int id;
	private String username;
	private String recepteName;
	private String interviewClassify;
	private String interviewAddress;
	private String interviewInfo;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")     //��ʱ�䰴�ձ�׼��ʽ�������ݿ�
	@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")     //���ݿ�ȡ��ʱ�䰴�ձ�׼��ʽ���͵�ǰ��
	private Date interviewDate;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRecepteName() {
		return recepteName;
	}

	public void setRecepteName(String recepteName) {
		this.recepteName = recepteName;
	}

	public String getInterviewClassify() {
		return interviewClassify;
	}

	public void setInterviewClassify(String interviewClassify) {
		this.interviewClassify = interviewClassify;
	}

	public String getInterviewAddress() {
		return interviewAddress;
	}

	public void setInterviewAddress(String interviewAddress) {
		this.interviewAddress = interviewAddress;
	}

	public String getInterviewInfo() {
		return interviewInfo;
	}

	public void setInterviewInfo(String interviewInfo) {
		this.interviewInfo = interviewInfo;
	}

	public Date getInterviewDate() {
		return interviewDate;
	}

	public void setInterviewDate(Date interviewDate) {
		this.interviewDate = interviewDate;
	}

	@Override
	public String toString() {
		return "Interview [id=" + id + ", username=" + username + ", receteName=" + recepteName + ", interviewClassify="
				+ interviewClassify + ", interviewAddress=" + interviewAddress + ", interviewInfo=" + interviewInfo
				+ ", interviewDate=" + interviewDate + "]";
	}
	
	

}
