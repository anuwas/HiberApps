package com.anu.pam.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.Table;



@Entity
@NamedQuery(name="EmployeeDetail.byEmpId", query="from EmployeeDetail where empId=?")
@NamedNativeQuery(name="EmployeeDetail.byEmployeeName",query="select * from EMPLOYEE_DETAIL where EMPLOYEE_NAME = ?",resultClass=EmployeeDetail.class)
@Table(name="EMPLOYEE_DETAIL")
public class EmployeeDetail {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int empId;
	
	@Column(name = "EMPLOYEE_NAME", nullable = false)
	private String employeeName;
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	@Override
	public String toString() {
		return "EmployeeDetail [empId=" + empId + ", employeeName=" + employeeName + "]";
	}
	
	
	
	

}
