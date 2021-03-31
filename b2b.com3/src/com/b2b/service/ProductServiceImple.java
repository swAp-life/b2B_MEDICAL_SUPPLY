package com.b2b.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.b2b.dao.ProductDao;
import com.b2b.dao.ProductManufacturerDao;
import com.b2b.dto.Product;
import com.b2b.dto.ProductManufacturer;

@Service
public class ProductServiceImple implements ProductService{

	@Autowired
	private ProductManufacturerDao productmanufacturerdao;

	@Autowired
	private ProductDao productdao;

	@Override
	public List<ProductManufacturer> getProductsAndManufacturers() {
		List<ProductManufacturer> ProductsAndManufacturers = productmanufacturerdao.getProductsAndManufacturers();
		return ProductsAndManufacturers;
	}

	@Override
	public List<ProductManufacturer> getProducts(long currentId) {
		List<ProductManufacturer> products = productmanufacturerdao.getProducts(currentId);
		return products;
	}

	@Override
	public void addProduct(Product product) {
		productdao.addProduct(product);
	}

	@Override
	public Product getProductByProdId(long prodId) {
		Product product = productdao.getProductByProdId(prodId);
		return product;
	}

	@Override
	public void updateProduct(Product product) {
		productdao.updateProduct(product);
	}

	@Override
	public void deleteProduct(long prodId) {
		productdao.deleteProduct(prodId);
	}

}
