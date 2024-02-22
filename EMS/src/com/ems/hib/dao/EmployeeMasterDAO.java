package com.ems.hib.dao;

import java.util.List;

import com.ems.hib.dto.EmployeeMaster;

public interface EmployeeMasterDAO {
	
	public List<EmployeeMaster> employeeList();
	public void addEmployee(EmployeeMaster emp);
	public void updateEmployee(EmployeeMaster emp);
	public EmployeeMaster getEmployee(Long id);
	public void deleteEmployee(Long id);
	
}
