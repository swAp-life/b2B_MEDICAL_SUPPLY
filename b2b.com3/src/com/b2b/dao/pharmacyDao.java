package com.b2b.dao;

import java.util.List;

import com.b2b.dto.Pharmacy;
import com.b2b.dto.User;

public interface pharmacyDao {
	public void updatePharmacy(Pharmacy pharmacy);
	public long getPharId(User user);
	public Pharmacy getPharmacy(long pharId);
}
