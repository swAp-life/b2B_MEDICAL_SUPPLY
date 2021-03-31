package com.b2b.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.b2b.dto.User;

@Repository
public class UserDaoImple implements UserDao {

	@Autowired
	private JdbcTemplate jdbctemplate;

	@Override
	public User getUserType(User user) {
		User usr1 = null;
		System.out.println("VALIDATE (LOGIN) USER--->USER DAO IMPLE");
		String sql = "select userId,userName,userPass,userType,flag from user where userName=? AND userPass = ? AND flag = 'y'";

		User usr = new User();

		try 
		{
			usr1 = jdbctemplate.queryForObject(sql, new Object[]{user.getUserName(),user.getUserPass()}, new RowMapper<User>() 
			{
				@Override
				public User mapRow(ResultSet rs, int rowNum) throws SQLException 
				{
					User usr = new User();
					usr.setUserName(rs.getString(2));
					usr.setUserPass(rs.getString(3));
					usr.setUserType(rs.getString(4));
					System.out.println("returning usr");
					return usr;
				}
			});

		}
		catch(Exception e)
		{
			usr = null;
			usr1 = usr;
		}
		System.out.println("returning usr1");
		return usr1;
	}

}
