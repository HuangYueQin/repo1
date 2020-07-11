package com.maternalBabyManage.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component("babysitter")
public class Babysitter {
	
	private int babysitterId;
	private String babysitterName;
	private String password;
	private String telphone;
	private String sex;
	private String babysitterFrom;
	private String isMarital;
	private String education;
	private String workInfo;
	private int age;
	private String recomend;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date workTime;
	private String photoSrc;
	private String constellation;
	private int level;
	private String certificate;
	private String userlist;
	public int getBabysitterId() {
		return babysitterId;
	}
	public void setBabysitterId(int babysitterId) {
		this.babysitterId = babysitterId;
	}
	public String getBabysitterName() {
		return babysitterName;
	}
	public void setBabysitterName(String babysitterName) {
		this.babysitterName = babysitterName;
	}
	public String getPassword() {
		return password;
	}
	
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public String getBabysitterFrom() {
		return babysitterFrom;
	}
	public void setBabysitterFrom(String babysitterFrom) {
		this.babysitterFrom = babysitterFrom;
	}
	public String getIsMarital() {
		return isMarital;
	}
	public void setIsMarital(String isMarital) {
		this.isMarital = isMarital;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getWorkInfo() {
		return workInfo;
	}
	public void setWorkInfo(String workInfo) {
		this.workInfo = workInfo;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getRecomend() {
		return recomend;
	}
	public void setRecomend(String recomend) {
		this.recomend = recomend;
	}
	public Date getWorkTime() {
		return workTime;
	}
	public void setWorkTime(Date workTime) {
		this.workTime = workTime;
	}
	public String getPhotoSrc() {
		return photoSrc;
	}
	public void setPhotoSrc(String photoSrc) {
		this.photoSrc = photoSrc;
	}
	public String getConstellation() {
		return constellation;
	}
	public void setConstellation(String constellation) {
		this.constellation = constellation;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getCertificate() {
		return certificate;
	}
	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}
	
	public String getUserlist() {
		return userlist;
	}
	public void setUserlist(String userlist) {
		this.userlist = userlist;
	}
	@Override
	public String toString() {
		return "Babysitter [babysitterId=" + babysitterId + ", babysitterName=" + babysitterName + ", password="
				+ password + ", telphone=" + telphone + ", babysitterFrom=" + babysitterFrom + ", isMarital="
				+ isMarital + ", education=" + education + ", workInfo=" + workInfo + ", age=" + age + ", recomend="
				+ recomend + ", workTime=" + workTime + ", photoSrc=" + photoSrc + ", constellation=" + constellation
				+ ", level=" + level + ", certificate=" + certificate + ", userlist=" + userlist + "]";
	}
	
}
