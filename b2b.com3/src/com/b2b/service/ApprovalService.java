package com.b2b.service;

import java.util.List;

import com.b2b.dto.Approval;

public interface ApprovalService {
	public List<Approval> userList();
	public void insertUser(Approval approval);
	public boolean isUsername(String username);
	public void insertIntoRespectiveTable(String tempName, String tempType);
	public void rejectAccount(String tempName, String tempType);
}