package com.b2b.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.b2b.dto.User;

@Repository
public class AdminDaoImple implements AdminDao{

	@Autowired
	private JdbcTemplate jdbctemplate;

	public void setJdbctemplate(JdbcTemplate jdbctemplate) {
		this.jdbctemplate = jdbctemplate;
	}

	@Override
	public long getAdminId(User user) {
		String sql = "select adminId from admin where adminName = ?";
		long adminId = (long) jdbctemplate.queryForObject(sql, new Object[]{user.getUserName()}, long.class);
		return adminId;
	}

}
