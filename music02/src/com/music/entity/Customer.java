package com.music.entity;

public class Customer {
	private Integer customer_id;
	private String customer_name;
	private String customer_password;

public Customer(Integer customer_id, String customer_name, String customer_password) {
		super();
		this.customer_id = customer_id;
		this.customer_name = customer_name;
		this.customer_password = customer_password;
	}
	public Customer(String customer_name, String customer_password) {
		super();
		this.customer_name = customer_name;
		this.customer_password = customer_password;
	}
	public Customer() {
		super();
	}
	public Object getCustomer_password() {
		// TODO Auto-generated method stub
		return null;
	}
	public Integer getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(Integer customer_id) {
		this.customer_id = customer_id;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public void setCustomer_password(String customer_password) {
		this.customer_password = customer_password;
	}
	
}