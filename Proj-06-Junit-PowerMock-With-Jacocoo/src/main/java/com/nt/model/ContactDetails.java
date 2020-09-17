package com.nt.model;

public class ContactDetails {

	private String name;
	private int phone;
	private String addrs;
	
	
	public ContactDetails() {

	}
	
	public ContactDetails(String name, int phone, String addrs) {
		this.name = name;
		this.phone = phone;
		this.addrs = addrs;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getAddrs() {
		return addrs;
	}
	public void setAddrs(String addrs) {
		this.addrs = addrs;
	}
	
	@Override
	public String toString() {
		return "ContactDetails [name=" + name + ", phone=" + phone + ", addrs=" + addrs + "]";
	}
	
}
