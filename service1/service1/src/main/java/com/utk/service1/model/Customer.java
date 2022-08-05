package com.utk.service1.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Customer_Data")
public class Customer {
	private String customerName;
	@Id
	private int customerMobile;
	private String customerAddress;
	private String city;
	private String password;
	
	public Customer() {
		super();
	}

	public Customer(String customerName, int customerMobile, String customerAddress, String city, String password) {
		super();
		this.customerName = customerName;
		this.customerMobile = customerMobile;
		this.customerAddress = customerAddress;
		this.city = city;
		this.password = password;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getCustomerMobile() {
		return customerMobile;
	}

	public void setCustomerMobile(int customerMobile) {
		this.customerMobile = customerMobile;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Customer [customerName=" + customerName + ", customerMobile=" + customerMobile + ", customerAddress="
				+ customerAddress + ", city=" + city + ", password=" + password + "]";
	}
	
}
