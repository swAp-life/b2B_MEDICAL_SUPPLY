package com.b2b.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.b2b.dao.ManufacturerDao;
import com.b2b.dao.pharmacyDao;
import com.b2b.dto.Manufacturer;
import com.b2b.dto.Pharmacy;

@Service
public class UpdateDetailsImple implements UpdateDetails{

	@Autowired
	private pharmacyDao pharmacydao;

	@Autowired
	private ManufacturerDao manufacturerdao;

	@Autowired
	private Pharmacy pharmacy;

	@Autowired
	private Manufacturer manufacturer;

	@Override
	public Pharmacy getPharmacy(long pharId) {
		Pharmacy pharmacy = pharmacydao.getPharmacy(pharId);
		return pharmacy;
	}

	@Override
	public Manufacturer getManufacturer(long manuId) {
		manufacturer = manufacturerdao.getManufacturer(manuId);
		return manufacturer;
	}

	@Override
	public void updatePharmacy(Pharmacy pharmacy) {
		pharmacydao.updatePharmacy(pharmacy);
	}

	@Override
	public void updateManufacturer(Manufacturer manufacturer) {
		manufacturerdao.updateManufacturer(manufacturer);
	}

}
