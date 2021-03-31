package com.b2b.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.b2b.dto.Manufacturer;
import com.b2b.dto.Product;

@Repository
public class ProductDaoImple implements ProductDao{

	@Autowired
	private JdbcTemplate jdbctemplate;

	@Override
	public List<Product> getProductsManu(long manuId) {
		String sql = "select prodId,prodName,prodCost,prodQuantity,manuId,prodFlag from product where manuId = ?";
		jdbctemplate.queryForList(sql);
		return null;
	}

	@Override
	public List<Product> getProductsPhar(long pharId) {

		return null;
	}

	@Override
	public void addProduct(Product product) {
		String sql = "insert into product(prodName, prodCost, prodQuantity, manuId, prodFlag) values(?,?,?,?, 'y')";
		jdbctemplate.update(sql, product.getProdName(), product.getProdCost(), product.getProdQuantity(), product.getManuId());
	}

	@Override
	public Product getProductByProdId(long prodId) {


		Product productOne = null;

		String sql = "select prodId,prodName,prodCost,prodQuantity,manuId,prodFlag from product where prodId = ?";

		Product productTwo = new Product();

		try 
		{
			productOne = jdbctemplate.queryForObject(sql, new Object[]{prodId}, new RowMapper<Product>() 
			{
				@Override
				public Product mapRow(ResultSet rs, int rowNum) throws SQLException 
				{
					Product productTwo = new Product();
					productTwo.setProdId(rs.getInt(1));
					productTwo.setProdName(rs.getString(2));
					productTwo.setProdCost(rs.getString(3));
					productTwo.setProdQuantity(rs.getInt(4));
					productTwo.setManuId(rs.getLong(5));
					return productTwo;
				}
			});

		}
		catch(Exception e)
		{
			productTwo = null;
			productOne = productTwo;
		}
		return productOne;
	}

	@Override
	public void updateProduct(Product product) {
		String sql = "update product SET prodName = ?, prodCost = ?, prodQuantity = ? where prodId = ?";
		jdbctemplate.update(sql, product.getProdName(), product.getProdCost(), product.getProdQuantity(), product.getProdId());
	}

	@Override
	public void deleteProduct(long prodId) {
		String sql = "update product SET prodFlag = 'n' where prodId = ?";
		jdbctemplate.update(sql, prodId);
	}

}
