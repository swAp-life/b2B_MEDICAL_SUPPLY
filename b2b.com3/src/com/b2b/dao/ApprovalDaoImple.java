package com.b2b.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.b2b.dto.Approval;
import com.b2b.dto.User;

@Repository
public class ApprovalDaoImple implements ApprovalDao{

	@Autowired
	private JdbcTemplate jdbctemplate;

	public void setJdbctemplate(JdbcTemplate jdbctemplate) {
		this.jdbctemplate = jdbctemplate;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List<Approval> userList() {
		String sql = "SELECT tempId,tempType,tempName,tempPass,tempAddr,tempPhoneNo,tempMailId,license,flag FROM approval where flag = 'y'";
		//For list unchecked conversion
		@SuppressWarnings("unchecked")
		List<Approval> applications = jdbctemplate.query(sql, new BeanPropertyRowMapper(Approval.class));
		return applications;
	}

	@Override
	public void approveUser(Approval approval) {

	}

	@Override
	public void insertUser(Approval approval) {
		String sql = " insert into approval(tempType, tempName, tempPass, tempAddr, tempPhoneNo, tempMailId, license, flag) values(?,?,?,?,?,?,?,'y')";
		jdbctemplate.update(sql, approval.getTempType(), approval.getTempName(), approval.getTempPass(), approval.getTempAddr(), approval.getTempPhoneNo(), approval.getTempMailId(), approval.getLicense());

		String sql2 = " insert into user(userName, userPass , userType, flag) values(?,?,?,'n')";
		jdbctemplate.update(sql2, approval.getTempName(), approval.getTempPass(), approval.getTempType());
	}

	@Override
	public void insertIntoRespectiveTable(String tempName, String tempType) {
		if(tempType.equals("pharmacy"))
		{
			Approval approval = null;
			//User usr1 = null;
			String sql = "select tempId,tempType,tempName,tempPass,tempAddr,tempPhoneNo,tempMailId,license,flag from approval where tempName = ?";

			Approval apprTwo = new Approval();
			//User usr = new User();

			try 
			{
				approval = jdbctemplate.queryForObject(sql, new Object[]{tempName}, new RowMapper<Approval>() 
				{
					@Override
					public Approval mapRow(ResultSet rs, int rowNum) throws SQLException 
					{
						Approval apprTwo = new Approval();
						apprTwo.setTempId(rs.getString(1));
						apprTwo.setTempType(rs.getString(2));
						apprTwo.setTempName(rs.getString(3));
						apprTwo.setTempPass(rs.getString(4));
						apprTwo.setTempAddr(rs.getString(5));
						apprTwo.setTempPhoneNo(rs.getString(6));
						apprTwo.setTempMailId(rs.getString(7));
						apprTwo.setLicense(rs.getString(8));
						apprTwo.setFlag(rs.getString(9));
						return apprTwo;
					}
				});

			}
			catch(Exception e)
			{
				apprTwo = null;
				approval = apprTwo;
			}

			String sqlTwo = "insert into pharmacy(pharName, pharPass, pharAddress, pharPhoneNo, pharMailId) values(?,?,?,?,?)";
			jdbctemplate.update(sqlTwo, approval.getTempName(), approval.getTempPass(), approval.getTempAddr(), approval.getTempPhoneNo(), approval.getTempMailId());
			String sqlThree = "update approval set flag = 'n' where tempName = ?";
			jdbctemplate.update(sqlThree, approval.getTempName());
			String sqlFour = "update user set flag = 'y' where userName = ?";
			jdbctemplate.update(sqlFour, approval.getTempName());
		}
		else 
		{
			Approval approval = null;
			//User usr1 = null;
			String sql = "select tempId,tempType,tempName,tempPass,tempAddr,tempPhoneNo,tempMailId,license,flag from approval where tempName = ?";

			Approval apprTwo = new Approval();
			//User usr = new User();

			try 
			{
				approval = jdbctemplate.queryForObject(sql, new Object[]{tempName}, new RowMapper<Approval>() 
				{
					@Override
					public Approval mapRow(ResultSet rs, int rowNum) throws SQLException 
					{
						Approval apprTwo = new Approval();
						apprTwo.setTempId(rs.getString(1));
						apprTwo.setTempType(rs.getString(2));
						apprTwo.setTempName(rs.getString(3));
						apprTwo.setTempPass(rs.getString(4));
						apprTwo.setTempAddr(rs.getString(5));
						apprTwo.setTempPhoneNo(rs.getString(6));
						apprTwo.setTempMailId(rs.getString(7));
						apprTwo.setLicense(rs.getString(8));
						apprTwo.setFlag(rs.getString(9));
						return apprTwo;
					}
				});

			}
			catch(Exception e)
			{
				apprTwo = null;
				approval = apprTwo;
			}
			//return approval;

			String sqlTwo = "insert into manufacturer(manuName, manuPass, manuAddr, manuPhoneNo, manuMailId) values(?,?,?,?,?)";
			jdbctemplate.update(sqlTwo, approval.getTempName(), approval.getTempPass(), approval.getTempAddr(), approval.getTempPhoneNo(), approval.getTempMailId());
			String sqlThree = "update approval set flag = 'n' where tempName = ?";
			jdbctemplate.update(sqlThree, approval.getTempName());
			String sqlFour = "update user set flag = 'y' where userName = ?";
			jdbctemplate.update(sqlFour, approval.getTempName());
		}
	}

	@Override
	public void rejectAccount(String tempName, String tempType) {
		String sqlOne = "delete from approval where tempName = ?";
		jdbctemplate.update(sqlOne, tempName);
		String sqlTwo = "delete from user where userName = ?";
		jdbctemplate.update(sqlTwo, tempName);
	}
}