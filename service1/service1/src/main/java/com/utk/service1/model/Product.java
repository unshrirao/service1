package com.utk.service1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Product_Data")
public class Product {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int productID;
	private String productName;
	private int price;
	private String category;
	
	public Product() {
		super();
	}

	public Product(String productName, int price, String category) {
		super();
		this.productName = productName;
		this.price = price;
		this.category = category;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [productID=" + productID + ", productName=" + productName + ", price=" + price + ", category="
				+ category + "]";
	}

}
