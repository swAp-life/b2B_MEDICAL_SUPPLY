package com.b2b.dao;

import com.b2b.dto.Manufacturer;
import com.b2b.dto.User;

public interface ManufacturerDao {
	public void updateManufacturer(Manufacturer manufacturer);
	public long getManuId(User user);
	public Manufacturer getManufacturer(long manuId);
}
