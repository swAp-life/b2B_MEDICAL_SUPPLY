package com.b2b.dto;

import org.springframework.stereotype.Component;

@Component
public class Orders {
	private long orderId;
	private long orderCost;
	private long orderQuant;
	private long prodId;
	private long pharId;
	private long manuId;
	private String manuName;
	private String prodName;
	private String pharName;
	
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public long getOrderCost() {
		return orderCost;
	}
	public void setOrderCost(long orderCost) {
		this.orderCost = orderCost;
	}
	public long getOrderQuant() {
		return orderQuant;
	}
	public void setOrderQuant(long orderQuant) {
		this.orderQuant = orderQuant;
	}
	public void setProdId(long prodId) {
		this.prodId = prodId;
	}
	public long getPharId() {
		return pharId;
	}
	public void setPharId(long pharId) {
		this.pharId = pharId;
	}
	public long getManuId() {
		return manuId;
	}
	public void setManuId(long manuId) {
		this.manuId = manuId;
	}
	public String getManuName() {
		return manuName;
	}
	public void setManuName(String manuName) {
		this.manuName = manuName;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public long getProdId() {
		return prodId;
	}
	public String getPharName() {
		return pharName;
	}
	public void setPharName(String pharName) {
		this.pharName = pharName;
	}
}
