package com.anu.pam.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import com.anu.pam.model.City;
import com.anu.pam.model.Employee;
import com.anu.pam.model.EmployeeDetail;
import com.anu.pam.model.Project;
import com.anu.pam.util.HibernateSessionUtil;

@Service
public class EmployeeService {
	
	public List<Employee> getAllEmployee(){
		Session session = HibernateSessionUtil.getHibernateSession();
		session.beginTransaction();
		List<Employee> employees = session.createQuery("FROM Employee ").list();
		session.getTransaction().commit();
		session.close();
		return employees;
	}
	
	public Employee getEmployeeById(int id) {
		Session session = HibernateSessionUtil.getHibernateSession();
		Employee employee = (Employee) session.get(Employee.class, id);
		return employee;
	}
	
	public Employee updateEmployee(int id, Employee employee) {
		Session session = HibernateSessionUtil.getHibernateSession();
		session.beginTransaction();
		Employee dbemployee = (Employee) session.get(Employee.class, id);
		dbemployee.setFirstName(employee.getFirstName());
		session.saveOrUpdate(dbemployee);
		session.getTransaction().commit();
		session.close();
		return dbemployee;
	}
	
	public String deleteEmployeeById(int id) {
		Session session = HibernateSessionUtil.getHibernateSession();
		session.beginTransaction();

		Employee employee = (Employee) session.get(Employee.class, id);
		session.delete(employee);
		session.getTransaction().commit();
		session.close();
		return "deleted";
	}
	
	public int createNewEmployee(Employee employee) {
		Session session = HibernateSessionUtil.getHibernateSession();
		session.beginTransaction();
		City city = new City();
		city.setCityName("Kolkata");
		employee.setCity(city);
		
			
		
		int id = (Integer) session.save(employee);
		session.save(city);
		
			
		session.getTransaction().commit();
		session.close();
		return id;
	}
	
	public List<Employee> getEmployeeByCriteria() {
		Session session = HibernateSessionUtil.getHibernateSession();
		session.beginTransaction();
		
		//using criteria
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.add(Restrictions.eq("firstName", "Anupam 1"));
		List<Employee> empList = criteria.list();
		System.out.println(empList.size());
		
		session.getTransaction().commit();
		session.close();
		return empList;
	}
	
	public List<Employee> getEmpWithHqlCondition() {
		Session session = HibernateSessionUtil.getHibernateSession();
		session.beginTransaction();
		
		Query query = session.createQuery("from Employee where id > 1");
		List<Employee> empList = query.list();
		
		session.getTransaction().commit();
		session.close();
		return empList;
	}
	
	public List<Employee> getEmpWithHqlBindCondition() {
		Session session = HibernateSessionUtil.getHibernateSession();
		session.beginTransaction();
		
		Query query = session.createQuery("from Employee where id > :empId and firstName = :empfirstName");
		query.setInteger("empId", 1);
		query.setString("empfirstName", "Anupam 3");
		List<Employee> empList = query.list();
		
		session.getTransaction().commit();
		session.close();
		return empList;
	}
	


}
