package com.anu.tqa.mapping.manytomany.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Vehicle {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int vehicleId;
private String vehichlename;
@ManyToMany
private Collection<UserDetail> userDetail = new ArrayList<>();

public Collection<UserDetail> getUserDetail() {
	return userDetail;
}
public void setUserDetail(Collection<UserDetail> userDetail) {
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
