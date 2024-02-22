package com.anu.tqa.notfoundannotation.dto;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
public class Vehicle {
	

@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int vehicleId;
private String vehichlename;
@ManyToOne
@NotFound(action=NotFoundAction.IGNORE)
private UserDetail userDetail;

public UserDetail getUserDetail() {
	return userDetail;
}
public void setUserDetail(UserDetail userDetail) {
	this.userDetail = userDetail;
}

public int getVehicleId() {
	return vehicleId;
}
public void setVehicleId(int vehicleId) {
	this.vehicleId = vehicleId;
}
public String getVehichlename() {
	return vehichlename;
}
public void setVehichlename(String vehichlename) {
	this.vehichlename = vehichlename;
}

}
