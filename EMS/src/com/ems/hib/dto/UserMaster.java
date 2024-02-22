package com.ems.hib.dto;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "UserMaster")
public class UserMaster implements Serializable{

	private static final long serialVersionUID = 1L;
	private Long user_id;
	private String first_name;
	private String last_name;
	private String username;
	private String email;
	private String password;
	private String address;
	private String phone_number;
	
	private CountryMaster countryMaster;
	
	private CityMaster cityMaster;
	
	@Id
	@GeneratedValue
	@Column(name = "user_id")
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	@Column(name = "first_name", length = 100)
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	@Column(name = "last_name",  length = 100)
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	@Column(name = "username", length = 100)
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Column(name = "email",  length = 100)
	public String getEmail(){
		return email;
	}
	public void setEmail(String email){
		this.email=email;
	}
	
	@Column(name = "password",  length = 100)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column(name = "address",  length = 100)
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Column(name = "phone_number", length = 100)
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="country_id")
	public CountryMaster getCountryMaster() {
		return countryMaster;
	}
	public void setCountryMaster(CountryMaster countryMaster) {
		this.countryMaster = countryMaster;
	}
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="city_id")
	public CityMaster getCityMaster() {
		return cityMaster;
	}
	public void setCityMaster(CityMaster cityMaster) {
		this.cityMaster = cityMaster;
	}
	
	
	/*
	public CountryMaster getCountry_id() {
		return country_id;
	}
	public void setCountry_id(CountryMaster country_id) {
		this.country_id = country_id;
	}
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="city_id")
	public CityMaster getCity_id() {
		return city_id;
	}
	public void setCity_id(CityMaster city_id) {
		this.city_id = city_id;
	}
	*/
	

	
	
	
	

}
