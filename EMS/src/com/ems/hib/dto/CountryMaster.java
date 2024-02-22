package com.ems.hib.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CountryMaster")
public class CountryMaster implements Serializable{


	private static final long serialVersionUID = 1L;
	
	private Long country_id;
	private String country_name;
	
	@Id
	@GeneratedValue
	@Column(name = "country_id")
	public Long getCountry_id() {
		return country_id;
	}
	public void setCountry_id(Long country_id) {
		this.country_id = country_id;
	}
	@Column(name = "country_name", length = 100)
	public String getCountry_name() {
		return country_name;
	}
	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}
	
	
}
