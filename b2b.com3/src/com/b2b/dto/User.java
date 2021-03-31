package com.b2b.dto;

import org.springframework.stereotype.Component;

@Component
public class User {
	private int userId;
	private String userName;
	private String userType;
	private String userPass;
	private String flag;
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int userId, String userName, String userType, String userPass, String flag) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userType = userType;
		this.userPass = userPass;
		this.flag = flag;
	}
}
