package com.anu.pam.controller;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.anu.pam.model.Employee;
import com.anu.pam.model.EmployeeDetail;
import com.anu.pam.service.EmployeeDetailService;
import com.anu.pam.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	EmployeeDetailService employeeDetailService;
	
	
	@RequestMapping(value = "/allemployee", method = RequestMethod.GET)
	public List<Employee> getAllEmployee() {
		
		return employeeService.getAllEmployee();
	}
	
	@RequestMapping(value = "/getemployeebyid/{id}", method = RequestMethod.GET)
	public Employee getEmployeeById(@PathVariable int id) {

		return employeeService.getEmployeeById(id);
	}
	
	@RequestMapping(value = "/updateemployee/{id}", method = RequestMethod.PUT,consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public Employee getEmployeeById(@PathVariable int id,@RequestBody Employee employee) {

		return employeeService.updateEmployee(id, employee);
	}
	
	@RequestMapping(value = "/deleteemployee/{id}", method = RequestMethod.DELETE)
	public String getleteEmployeeById(@PathVariable int id) {

		return employeeService.deleteEmployeeById(id);
	}
	
	@RequestMapping(value = "/add-employee", method = RequestMethod.POST,consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> saveEmployee(@RequestBody Employee employee) {
		employeeService.createNewEmployee(employee);
		return ResponseEntity.ok("Created");
	}
	
	@RequestMapping(value = "/allemployee-with-criteria", method = RequestMethod.GET)
	public List<Employee> getAllEmployeeByCriteria() {
		
		return employeeService.getEmployeeByCriteria();	
	}
	
	@RequestMapping(value = "/getemployeedetail-with-namedquery-name", method = RequestMethod.GET)
	public List<EmployeeDetail> getEmpDetailByNamdedQueryByName() {
		
		return employeeDetailService.getEmployeeDetailWithNamedQueryByName();
	}
	
	@RequestMapping(value = "/getEmp-with-hql-condition", method = RequestMethod.GET)
	public List<Employee> getEmpWithHqlCondition() {
		
		return employeeService.getEmpWithHqlCondition();	
	}
	
	@RequestMapping(value = "/getEmp-with-hql-bind-condition", method = RequestMethod.GET)
	public List<Employee> getEmpWithHqlBindCondition() {
		
		return employeeService.getEmpWithHqlBindCondition();	
	}
	
	/*
	@PostMapping("/add-employee")
	public ResponseEntity<Object> createStudent(@RequestBody Employee employee) {
		System.out.println(employee);

		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		int id = (Integer) session.save(employee);
		
		session.getTransaction().commit();
		session.close();
		
		return ResponseEntity.ok(null);
		
		//{
			//"firstName":"Anupam 1",
			//"lastName":"Biswas",
			//"department":"ADM"
			//}
	}
*/


	
	/*
	@RequestMapping("/hello/{player}")
	public Message message(@PathVariable String player) {//REST Endpoint.

		Message msg = new Message(player, "Hello " + player);
		return msg;
	}*/
	


}
