package com.packageFour;
public class Customer {

	private int customerId;
	private String customerName;
	private Merchant parentObjects;
	
	public Customer() {}
	public Customer(int customerId,String customerName) {
		this.customerId=customerId;
		this.customerName=customerName;
	}
	public Merchant getParentObjects() {
		return parentObjects;
	}
	public void setParentObjects(Merchant parentObjects) {
		this.parentObjects = parentObjects;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}	
	
}
