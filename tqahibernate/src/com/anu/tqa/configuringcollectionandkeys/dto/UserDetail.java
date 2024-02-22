package com.anu.tqa.configuringcollectionandkeys.dto;


import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;


@Entity
public class UserDetail {

	@Id
	private int userId;
	private String userName;
	@ElementCollection
	@JoinTable(name="user_address",
	joinColumns=@JoinColumn(name = "user_id")
	)
	@GenericGenerator(name = "native", strategy = "native")
	@CollectionId(columns = { @Column(name="ADDRESS_ID") }, generator = "native", type = @Type(type = "integer"))
	private Collection<Address> listOfAddress = new ArrayList<Address>();
	
	
	public Collection<Address> getListOfAddress() {
		return listOfAddress;
	}
	public void setListOfAddress(Collection<Address> listOfAddress) {
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
