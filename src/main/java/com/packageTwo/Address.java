package com.packageTwo;

public class Address {
	
	private int addressId;
	private String city;
	private String state;
	private Student student;	

	public Student getS() {
		return student;
	}
	public void setS(Student student) {
		this.student = student;
	}
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
}
