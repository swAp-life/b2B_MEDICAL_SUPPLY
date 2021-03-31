package com.b2b.service;

import java.util.List;

import com.b2b.dto.Orders;
import com.b2b.dto.Product;

public interface OrderService {
	public List<Orders> getPharOrderDetails(String pharName);
	public List<Orders> getManuOrderDetails(String manuName);
	public void addOrder(Product product, long pharId);
}
