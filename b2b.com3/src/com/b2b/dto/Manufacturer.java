package com.b2b.dto;

import org.springframework.stereotype.Component;

@Component
public class Manufacturer {
	private long manuId;
	private String manuName;
	private String manuPass;
	private String manuAddr;
	private String manuPhoneNo;
	private String manuMailId;
	private int manuRating;
	public long getManuId() {
		return manuId;
	}
	public void setManuId(long manuId) {
		this.manuId = manuId;
	}
	public String getManuName() {
		return manuName;
	}
	public void setManuName(String manuName) {
		this.manuName = manuName;
	}
	public String getManuPass() {
		return manuPass;
	}
	public void setManuPass(String manuPass) {
		this.manuPass = manuPass;
	}
	public String getManuAddr() {
		return manuAddr;
	}
	public void setManuAddr(String manuAddr) {
		this.manuAddr = manuAddr;
	}
	public String getManuPhoneNo() {
		return manuPhoneNo;
	}
	public void setManuPhoneNo(String manuPhoneNo) {
		this.manuPhoneNo = manuPhoneNo;
	}
	public String getManuMailId() {
		return manuMailId;
	}
	public void setManuMailId(String manuMailId) {
		this.manuMailId = manuMailId;
	}
	public int getManuRating() {
		return manuRating;
	}
	public void setManuRating(int manuRating) {
		this.manuRating = manuRating;
	}
	public Manufacturer(long manuId, String manuName, String manuPass, String manuAddr, String manuPhoneNo,
			String manuMailId, int manuRating) {
		super();
		this.manuId = manuId;
		this.manuName = manuName;
		this.manuPass = manuPass;
		this.manuAddr = manuAddr;
		this.manuPhoneNo = manuPhoneNo;
		this.manuMailId = manuMailId;
		this.manuRating = manuRating;
	}
	public Manufacturer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
