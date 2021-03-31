package com.b2b.dao;

import java.util.List;

import com.b2b.dto.ProductManufacturer;

public interface ProductManufacturerDao {
	public List<ProductManufacturer> getProductsAndManufacturers();
	public List<ProductManufacturer> getProducts(long currentId);
}
