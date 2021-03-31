package com.b2b.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.b2b.dto.Manufacturer;
import com.b2b.dto.Pharmacy;
import com.b2b.dto.User;

@Repository
public class ManufacturerDaoImple implements ManufacturerDao{

	@Autowired
	private JdbcTemplate jdbctemplate;

	@Autowired
	private Manufacturer manufacturer;

	public void setJdbctemplate(JdbcTemplate jdbctemplate) {
		this.jdbctemplate = jdbctemplate;
	}

	@Override
	public void updateManufacturer(Manufacturer manufacturer) {
		String sql = "update manufacturer set manuPass = ?, manuAddr = ?, manuPhoneNo = ?, manuMailId = ? where manuName = ?";
		jdbctemplate.update(sql, manufacturer.getManuPass(), manufacturer.getManuAddr(), manufacturer.getManuPhoneNo(), manufacturer.getManuMailId(), manufacturer.getManuName());
	}

	@Override
	public long getManuId(User user) {
		String sql = "select manuId from manufacturer where manuName = ?";
		long manuId = (long) jdbctemplate.queryForObject(sql, new Object[]{user.getUserName()}, long.class);
		return manuId;
	}

	@Override
	public Manufacturer getManufacturer(long manuId) {
		Manufacturer manufacturerOne = null;

		String sql = "select manuId,manuName,manuPass,manuAddr,manuPhoneNo,manuMailId from manufacturer where manuId = ?";

		Manufacturer manufacturerTwo = new Manufacturer();

		try 
		{
			manufacturerOne = jdbctemplate.queryForObject(sql, new Object[]{manuId}, new RowMapper<Manufacturer>() 
			{
				@Override
				public Manufacturer mapRow(ResultSet rs, int rowNum) throws SQLException 
				{
					Manufacturer manufacturerTwo = new Manufacturer();
					manufacturerTwo.setManuName(rs.getString(2));
					manufacturerTwo.setManuPass(rs.getString(3));
					manufacturerTwo.setManuAddr(rs.getString(4));
					manufacturerTwo.setManuPhoneNo(rs.getString(5));
					manufacturerTwo.setManuMailId(rs.getString(6));
					return manufacturerTwo;
				}
			});

		}
		catch(Exception e)
		{
			manufacturerTwo = null;
			manufacturerOne = manufacturerTwo;
		}
		return manufacturerOne;
	}

}
