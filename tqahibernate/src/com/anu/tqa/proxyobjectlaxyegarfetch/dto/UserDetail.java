package com.anu.tqa.proxyobjectlaxyegarfetch.dto;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

@Entity
public class UserDetail {

	@Id
	private int userId;
	private String userName;
	@ElementCollection(fetch=FetchType.EAGER)
	@JoinTable(name="user_address",
	joinColumns=@JoinColumn(name = "user_id")
	)
	private Set<Address> listOfAddress = new HashSet<>();
	

	public Set<Address> getListOfAddress() {
		return listOfAddress;
	}
	public void setListOfAddress(Set<Address> listOfAddress) {
		this.listOfAddress = listOfAddress;
	}

	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}
