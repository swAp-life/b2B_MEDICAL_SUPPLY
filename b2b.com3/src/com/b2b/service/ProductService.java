package com.b2b.service;

import java.util.List;

import com.b2b.dto.Product;
import com.b2b.dto.ProductManufacturer;

public interface ProductService {
	public List<ProductManufacturer> getProductsAndManufacturers(); 
	public List<ProductManufacturer> getProducts(long currentId);
	public void addProduct(Product product);
	public Product getProductByProdId(long prodId);
	public void updateProduct(Product product);
	public void deleteProduct(long prodId);
}
