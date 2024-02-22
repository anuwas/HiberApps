package com.ems.hib.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CityMaster")
public class CityMaster implements Serializable{


	private static final long serialVersionUID = 1L;
	private Long city_id;
	private String city_name;
	
	@Id
	@GeneratedValue
	@Column(name = "city_id")
	public Long getCity_id() {
		return city_id;
	}
	public void setCity_id(Long city_id) {
		this.city_id = city_id;
	}
	@Column(name = "city_name", nullable = false, length = 100)
	public String getCity_name() {
		return city_name;
	}
	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}
	
}
