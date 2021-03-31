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
import com.b2b.dto.Pharmacy;
import com.b2b.dto.User;

@Repository
public class pharmacyDaoImple implements pharmacyDao{

	@Autowired
	private JdbcTemplate jdbctemplate;

	public void setJdbctemplate(JdbcTemplate jdbctemplate) {
		this.jdbctemplate = jdbctemplate;
	}

	@Override
	public void updatePharmacy(Pharmacy pharmacy) {
		String sql = "update pharmacy set pharPass = ?, pharAddress = ?, pharPhoneNo = ?, pharMailId = ? where pharName = ?";
		//jdbctemplate.update(sql, user.getUserType(), user.getUserName(), user.getPassword(), user.getAddress(), user.getPhoneNumber(), user.getEmailId());
		//jdbctemplate.update(sql, pharmacy.getPharName(), pharmacy.getPharPass(), pharmacy.getPharAddress(), pharmacy.getPharMailId(), pharmacy.getPharId());
		jdbctemplate.update(sql, pharmacy.getPharPass(), pharmacy.getPharAddress(), pharmacy.getPharPhoneNo(), pharmacy.getPharMailId(), pharmacy.getPharName());
	}

	@Override
	public long getPharId(User user) {
		String sql = "select pharId from pharmacy where pharName = ?";
		long pharId = (long) jdbctemplate.queryForObject(sql, new Object[]{user.getUserName()}, long.class);
		return pharId;
	}

	//@Autowired
	//private List<Pharmacy> pharmacy;

	@Override
	public Pharmacy getPharmacy(long pharId) {

		Pharmacy pharmacyOne = null;

		String sql = "select pharId,pharName,pharPass,pharAddress,pharPhoneNo,pharMailId from pharmacy where pharId = ?";

		Pharmacy pharmacyTwo = new Pharmacy();

		try 
		{
			pharmacyOne = jdbctemplate.queryForObject(sql, new Object[]{pharId}, new RowMapper<Pharmacy>() 
			{
				@Override
				public Pharmacy mapRow(ResultSet rs, int rowNum) throws SQLException 
				{
					Pharmacy pharmacyTwo = new Pharmacy();
					pharmacyTwo.setPharName(rs.getString(2));
					pharmacyTwo.setPharPass(rs.getString(3));
					pharmacyTwo.setPharAddress(rs.getString(4));
					pharmacyTwo.setPharPhoneNo(rs.getString(5));
					pharmacyTwo.setPharMailId(rs.getString(6));
					return pharmacyTwo;
				}
			});

		}
		catch(Exception e)
		{
			pharmacyTwo = null;
			pharmacyOne = pharmacyTwo;
		}
		return pharmacyOne;
	}


}