package com.b2b.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.b2b.dto.Approval;
import com.b2b.dto.Manufacturer;
import com.b2b.dto.ProductManufacturer;

@Repository
public class ProductManufacturerDaoImple implements ProductManufacturerDao{

	@Autowired
	private JdbcTemplate jdbctemplate;

	@Override
	public List<ProductManufacturer> getProductsAndManufacturers() {

		String sql = "select product.prodId,product.prodName,product.prodCost,product.prodQuantity,manufacturer.manuName, manufacturer.manuId from product,manufacturer where product.manuId=manufacturer.manuId";
		//For list unchecked conversion
		@SuppressWarnings("unchecked")
		List<ProductManufacturer> ProductsAndManufacturers = jdbctemplate.query(sql, new BeanPropertyRowMapper(ProductManufacturer.class));
		return ProductsAndManufacturers;
	}

	@Override
	public List<ProductManufacturer> getProducts(long currentId) {
		String sql = "select prodId,prodName,prodCost,prodQuantity,manuId,prodFlag from product where manuId = "+currentId+" and prodFlag = 'y'";
		//For list unchecked conversion
		@SuppressWarnings("unchecked")
		List<ProductManufacturer> products = jdbctemplate.query(sql, new BeanPropertyRowMapper(ProductManufacturer.class));
		return products;
	}

}
