package com.b2b.dao;

import java.util.List;

import com.b2b.dto.Product;

public interface ProductDao {
	public List<Product> getProductsManu(long manuId);
	public List<Product> getProductsPhar(long pharId);
	public void addProduct(Product product);
	public Product getProductByProdId(long prodId);
	public void updateProduct(Product product);
	public void deleteProduct(long prodId);
}
