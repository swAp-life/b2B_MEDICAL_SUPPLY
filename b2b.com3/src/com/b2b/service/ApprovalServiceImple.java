package com.b2b.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.b2b.dao.ApprovalDao;
import com.b2b.dto.Approval;

@Controller
public class ApprovalServiceImple implements ApprovalService{

	@Autowired
	private JdbcTemplate jdbctemplate;

	@Autowired
	private ApprovalDao approvalDao;

	@Override
	public List<Approval> userList() {
		List<Approval> applications = approvalDao.userList();
		return applications;
	}

	@Override
	public void insertUser(Approval approval) {
		approvalDao.insertUser(approval);
	}

	@Override
	public boolean isUsername(String username) {
		String sql = "select count(userName) from user where userName=?";
		Integer count = jdbctemplate.queryForObject(sql,new Object[] {username}, Integer.class);
		if(count == 1)
			return true;
		else
			return false;
	}

	@Override
	public void insertIntoRespectiveTable(String tempName, String tempType) {
		approvalDao.insertIntoRespectiveTable(tempName, tempType);
	}

	@Override
	public void rejectAccount(String tempName, String tempType) {
		approvalDao.rejectAccount(tempName, tempType);
	}
}
