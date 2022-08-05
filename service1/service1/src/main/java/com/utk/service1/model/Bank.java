package com.utk.service1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Bank_Data")
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int accountNo;
    @Column(name="Customer_Name")
    private String name;
    private String city;
    
	public Bank() {
		super();
	}
	public Bank(String name, String city) {
		super();
		this.name = name;
		this.city = city;
	}
	public int getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Bank [accountNo=" + accountNo + ", name=" + name + ", city=" + city + "]";
	}
    
}
