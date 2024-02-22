package com.anu.tqa.embeddedobject.attribute.dto;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {

	@Column(name="STATE_NAME")
	private String state;
	@Column(name="CITY_NAME")
	private String city;
	@Column(name="STREET_NAME")
	private String street;
	@Column(name="PINCODE_NAME")
	private String pincode;
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
}
