package com.b2b.dto;

import org.springframework.stereotype.Component;

@Component
public class Pharmacy {
	private int pharId;
	private String pharName;
	private String pharPass;
	private String pharAddress;
	private String pharPhoneNo;
	private String pharMailId;
	
	public Pharmacy() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Pharmacy(int pharId, String pharName, String pharPass, String pharAddress, String pharPhoneNo,
			String pharMailId) {
		super();
		this.pharId = pharId;
		this.pharName = pharName;
		this.pharPass = pharPass;
		this.pharAddress = pharAddress;
		this.pharPhoneNo = pharPhoneNo;
		this.pharMailId = pharMailId;
	}
	public String getPharPhoneNo() {
		return pharPhoneNo;
	}
	public void setPharPhoneNo(String pharPhoneNo) {
		this.pharPhoneNo = pharPhoneNo;
	}
	public int getPharId() {
		return pharId;
	}
	public void setPharId(int pharId) {
		this.pharId = pharId;
	}
	
	public String getPharName() {
		return pharName;
	}
	public void setPharName(String pharName) {
		this.pharName = pharName;
	}
	
	public String getPharPass() {
		return pharPass;
	}
	public void setPharPass(String pharPass) {
		this.pharPass = pharPass;
	}
	public String getPharAddress() {
		return pharAddress;
	}
	public void setPharAddress(String pharAddress) {
		this.pharAddress = pharAddress;
	}
	public String getPharMailId() {
		return pharMailId;
	}
	public void setPharMailId(String pharMailId) {
		this.pharMailId = pharMailId;
	}
}
