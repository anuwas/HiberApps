package com.ems.hib.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EmployeeMaster")
public class EmployeeMaster implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Long emp_id;
	private String emp_name;
	private String emp_phone;
	
	@Id
	@GeneratedValue
	@Column(name="emp_id")
	public Long getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(Long emp_id) {
		this.emp_id = emp_id;
	}
	
	@Column(name="emp_name")
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	
	@Column(name="emp_phone")
	public String getEmp_phone() {
		return emp_phone;
	}
	public void setEmp_phone(String emp_phone) {
		this.emp_phone = emp_phone;
	}
	
	public String toString(){
		return this.getEmp_id()+" "+this.getEmp_name()+" "+this.getEmp_phone();
	}
	

}
