package com.b2b.dto;

public class ProductManufacturer {
	private long prodId;
	private String prodName;
	private String prodCost;
	private int prodQuantity;
	private String manuName;
	private long manuId;
	
	
	public long getManuId() {
		return manuId;
	}
	public void setManuId(long manuId) {
		this.manuId = manuId;
	}
	public long getProdId() {
		return prodId;
	}
	public void setProdId(long prodId) {
		this.prodId = prodId;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public String getProdCost() {
		return prodCost;
	}
	public void setProdCost(String prodCost) {
		this.prodCost = prodCost;
	}
	public int getProdQuantity() {
		return prodQuantity;
	}
	public void setProdQuantity(int prodQuantity) {
		this.prodQuantity = prodQuantity;
	}
	public String getManuName() {
		return manuName;
	}
	public void setManuName(String manuName) {
		this.manuName = manuName;
	}
	public ProductManufacturer(long prodId, String prodName, String prodCost, int prodQuantity, String manuName,
			long manuId) {
		super();
		this.prodId = prodId;
		this.prodName = prodName;
		this.prodCost = prodCost;
		this.prodQuantity = prodQuantity;
		this.manuName = manuName;
		this.manuId = manuId;
	}
	public ProductManufacturer() {
		super();
		// TODO Auto-generated constructor stub
	}
}
