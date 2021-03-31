package com.b2b.dao;

import java.util.List;

import com.b2b.dto.Approval;

public interface ApprovalDao {
	public List<Approval> userList();
	public void approveUser(Approval approval);
	public void insertUser(Approval approval);
	public void insertIntoRespectiveTable(String tempName, String tempType);
	public void rejectAccount(String tempName, String tempType);
}
