package com.anu.tqa.inheritance.perclassstretegy.dto;


import javax.persistence.Entity;

@Entity
public class TwoWheeler extends Vehicle{
	private String streeingHandle;
	
	public String getStreeingHandle() {
		return streeingHandle;
	}

	public void setStreeingHandle(String streeingHandle) {
		this.streeingHandle = streeingHandle;
	}


}
