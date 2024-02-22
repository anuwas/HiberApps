package com.anu.tqa.mapping.onetomany.sametable.dto;



import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="USER_DETAILS")
public class UserDetail {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	private String userName;
	@OneToMany(mappedBy="userDetail")
	private Collection<Vehicle> Vehicle = new ArrayList<>();
	
	public Collection<Vehicle> getVehicle() {
		return Vehicle;
	}
	public void setVehicle(Collection<Vehicle> vehicle) {
		Vehicle = vehicle;
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
