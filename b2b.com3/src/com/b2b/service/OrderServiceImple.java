package com.b2b.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.b2b.dao.OrdersDao;
import com.b2b.dto.Orders;
import com.b2b.dto.Product;

@Service
public class OrderServiceImple implements OrderService{

	@Autowired
	private OrdersDao ordersdao;

	@Override
	public List<Orders> getPharOrderDetails(String pharName) {
		List<Orders> orders = ordersdao.getPharOrderDetails(pharName);
		return orders;
	}

	@Override
	public List<Orders> getManuOrderDetails(String manuName) {
		List<Orders> orders = ordersdao.getManuOrderDetails(manuName);
		return orders;
	}

	@Override
	public void addOrder(Product product, long pharId) {
		ordersdao.addOrder(product, pharId);
	}

}
