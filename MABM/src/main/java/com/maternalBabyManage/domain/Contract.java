package com.maternalBabyManage.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

@Component
public class Contract {
	
	private int id;
	private String customerName;
	private String babysitterName;
	private String customerTel;
	private String babysitterTel;
	private String info;
	private String level;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")              //前端传后台(输入格式)
	@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")   //后台转前台(限定输出格式)
	private Date contractTime;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
	private Date childBirthday;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
	private Date serviceTime;
	
	private float amount;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getBabysitterName() {
		return babysitterName;
	}
	public void setBabysitterName(String babysitterName) {
		this.babysitterName = babysitterName;
	}
	public String getCustomerTel() {
		return customerTel;
	}
	public void setCustomerTel(String customerTel) {
		this.customerTel = customerTel;
	}
	public String getBabysitterTel() {
		return babysitterTel;
	}
	public void setBabysitterTel(String babysitterTel) {
		this.babysitterTel = babysitterTel;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public Date getContractTime() {
		return contractTime;
	}
	public void setContractTime(Date contractTime) {
		this.contractTime = contractTime;
	}
	public Date getChildBirthday() {
		return childBirthday;
	}
	public void setChildBirthday(Date childBirthday) {
		this.childBirthday = childBirthday;
	}
	public Date getServiceTime() {
		return serviceTime;
	}
	public void setServiceTime(Date serviceTime) {
		this.serviceTime = serviceTime;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Contract [id=" + id + ", customerName=" + customerName + ", babysitterName=" + babysitterName
				+ ", customerTel=" + customerTel + ", babysitterTel=" + babysitterTel + ", info=" + info + ", level="
				+ level + ", contractTime=" + contractTime + ", childBirthday=" + childBirthday + ", serviceTime="
				+ serviceTime + ", amount=" + amount + "]";
	}
	

}
