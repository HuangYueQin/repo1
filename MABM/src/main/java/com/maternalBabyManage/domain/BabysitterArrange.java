package com.maternalBabyManage.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

@Component
public class BabysitterArrange {

	private int id;
	private String babysitterName;
	private String customer;
	private String requestInfo;
	private String address;
	private String customerTel;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
	private Date requestDate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBabysitterName() {
		return babysitterName;
	}
	public void setBabysitterName(String babysitterName) {
		this.babysitterName = babysitterName;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public Date getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}
	public String getRequestInfo() {
		return requestInfo;
	}
	public void setRequestInfo(String requestInfo) {
		this.requestInfo = requestInfo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCustomerTel() {
		return customerTel;
	}
	public void setCustomerTel(String customerTel) {
		this.customerTel = customerTel;
	}
	@Override
	public String toString() {
		return "BabysitterArrange [id=" + id + ", babysitterName=" + babysitterName + ", customer=" + customer
				+ ", requestInfo=" + requestInfo + ", address=" + address + ", customerTel=" + customerTel
				+ ", requestDate=" + requestDate + "]";
	}
	
}
