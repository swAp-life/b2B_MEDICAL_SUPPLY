package com.b2b.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.b2b.dao.AdminDao;
import com.b2b.dao.ManufacturerDao;
import com.b2b.dao.UserDao;
import com.b2b.dao.pharmacyDao;
import com.b2b.dto.User;

@Service
public class LoginServiceImple implements LoginService{

	@Autowired
	private UserDao userdao;

	@Override
	public User getUserType(User user) {
		System.out.println("Entering getUserType");
		User user1 = userdao.getUserType(user);
		System.out.println("Leaving getUserType");
		return user1;
	}

	@Autowired
	private pharmacyDao pharmacydao;

	@Override
	public long getPharId(User user) {
		long pharId = pharmacydao.getPharId(user);
		return pharId;
	}

	@Autowired
	private ManufacturerDao manufacturerdao;

	@Override
	public long getManuId(User user) {
		long manuId = manufacturerdao.getManuId(user);
		return manuId;
	}

	@Autowired
	private AdminDao admindao;

	@Override
	public long getAdminId(User user) {
		long adminId = admindao.getAdminId(user);
		return adminId;
	}



}