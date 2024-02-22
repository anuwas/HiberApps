package com.anu.tqa.inheritance.singletablestrategy.dto;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("bike")
public class TwoWheeler extends Vehicle{
	private String streeingHandle;
	
	public String getStreeingHandle() {
		return streeingHandle;
	}

	public void setStreeingHandle(String streeingHandle) {
		this.streeingHandle = streeingHandle;
	}


}
