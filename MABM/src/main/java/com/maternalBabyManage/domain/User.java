package com.maternalBabyManage.domain;

import java.util.List;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component("user")
public class User {
	
	private int userId;
	private String name;
	private String password;
	private String sex;
	private String telphone;
	private String userFrom;
	private String requestInfo;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthday;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date requestDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date childbirthDate;
	
	private List<Babysitter>babysitterlist;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public String getUserFrom() {
		return userFrom;
	}
	public void setUserFrom(String userFrom) {
		this.userFrom = userFrom;
	}
	public String getRequestInfo() {
		return requestInfo;
	}
	public void setRequestInfo(String requestInfo) {
		this.requestInfo = requestInfo;
	}
	public Date getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}
	public Date getChildbirthDate() {
		return childbirthDate;
	}
	public void setChildbirthDate(Date childbirthDate) {
		this.childbirthDate = childbirthDate;
	}
	public List<Babysitter> getBabysitterlist() {
		return babysitterlist;
	}
	public void setBabysitterlist(List<Babysitter> babysitterlist) {
		this.babysitterlist = babysitterlist;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", password=" + password + ", birthday=" + birthday
				+ ", sex=" + sex + ", telphone=" + telphone + ", userFrom=" + userFrom + ", requestInfo=" + requestInfo
				+ ", requestDate=" + requestDate + ", childbirthDate=" + childbirthDate + ", babysitterlist="
				+ babysitterlist + "]";
	}
    
	

}
