package com.b2b.dao;

import java.util.List;

import com.b2b.dto.Orders;
import com.b2b.dto.Product;

public interface OrdersDao {
	public List<Orders> getPharOrderDetails(String pharName);
	public List<Orders> getManuOrderDetails(String manuName);
	public void addOrder(Product product, long pharId);
}
