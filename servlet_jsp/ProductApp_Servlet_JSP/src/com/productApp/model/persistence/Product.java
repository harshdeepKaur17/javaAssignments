package com.productApp.model.persistence;

import java.sql.Date;
import java.time.LocalDate;

public class Product {
	int productId;
	String name;
	double price;
	int quantity;
	LocalDate mfDate;
	LocalDate inspDate;
	
	public Product(int productId, String name, double price, int quantity, Date mfDate, Date inspDate) {
		super();
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.mfDate = mfDate.toLocalDate();
		this.inspDate = inspDate.toLocalDate();
	}
	public Product(String name, double price, int quantity, Date mfDate, Date inspDate) {
		super();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.mfDate = mfDate.toLocalDate();
		this.inspDate = inspDate.toLocalDate();
	}
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Date getMfDate() {
		Date date = Date.valueOf(mfDate);
		return date;
	}
	public void setMfDate(LocalDate mfDate) {
		this.mfDate = mfDate;
	}
	public Date getInspDate() {
		Date date = Date.valueOf(inspDate);
		return date;
	}
	public void setInspDate(LocalDate inspDate) {
		this.inspDate = inspDate;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Product [productId=").append(productId).append(", name=").append(name).append(", price=")
				.append(price).append(", quantity=").append(quantity).append(", mfDate=").append(mfDate)
				.append(", inspDate=").append(inspDate).append("]");
		return builder.toString();
	}
	
	
}
