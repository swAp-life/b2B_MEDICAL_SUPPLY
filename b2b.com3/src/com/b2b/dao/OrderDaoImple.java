package com.b2b.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.b2b.dto.Orders;
import com.b2b.dto.Product;
import com.b2b.dto.ProductManufacturer;

@Repository
public class OrderDaoImple implements OrdersDao{

	
	private JdbcTemplate jdbctemplate = new JdbcTemplate();

	@Override
	public List<Orders> getPharOrderDetails(String pharName) {
		String sql = "select orderCost, orderQuant, prodName, manuName, pharName from orders o inner join product p on p.prodId = o.prodId inner join manufacturer m on m.manuId = o.manuId inner join pharmacy ph on ph.pharId = o.pharId where ph.pharName = ?";
		//For list unchecked conversion
		@SuppressWarnings("unchecked")
		List<Orders> orders = jdbctemplate.query(sql, new Object[] {pharName}, new BeanPropertyRowMapper(Orders.class));
		return orders;
	}

	@Override
	public List<Orders> getManuOrderDetails(String manuName) {
		String sql = "select orderCost, orderQuant, prodName, manuName, pharName from orders o inner join product p on p.prodId = o.prodId inner join manufacturer m on m.manuId = o.manuId inner join pharmacy ph on ph.pharId = o.pharId where m.manuName = ?";
		//For list unchecked conversion
		@SuppressWarnings("unchecked")
		List<Orders> orders = jdbctemplate.query(sql, new Object[] {manuName}, new BeanPropertyRowMapper(Orders.class));
		return orders;
	}

	@Override
	public void addOrder(Product product, long pharId) {
		String sql = "insert into orders(orderCost, orderQuant, prodId, pharId, manuId) values(?,?,?,?,?)";
		jdbctemplate.update(sql, product.getProdCost(), product.getProdQuantity(), product.getProdId(), pharId, product.getManuId());
	}

}
