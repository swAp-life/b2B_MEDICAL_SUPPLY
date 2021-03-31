package com.b2b.service;

import java.util.List;

import com.b2b.dto.Manufacturer;
import com.b2b.dto.Pharmacy;

public interface UpdateDetails {
	public Pharmacy getPharmacy(long pharId);
	public Manufacturer getManufacturer(long manuId);
	public void updatePharmacy(Pharmacy pharmacy);
	public void updateManufacturer(Manufacturer manufacturer);
}