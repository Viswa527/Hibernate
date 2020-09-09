package com.packageThree;

import java.util.Set;

public class Merchant {

	private int merchantId;
	private String merchantName;
	private Set<Customer> set;
	
	public Merchant() {	}
	public Merchant(int merchantId,String merchantName) {
		this.merchantId = merchantId;
		this.merchantName = merchantName;
	}
	public int getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(int merchantId) {
		this.merchantId = merchantId;
	}
	public String getMerchantName() {
		return merchantName;
	}
	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}
	public Set<Customer> getChildren() {
		return set;
	}
	public void setChildren(Set<Customer> set) {
		this.set = set;
	}
	
}
