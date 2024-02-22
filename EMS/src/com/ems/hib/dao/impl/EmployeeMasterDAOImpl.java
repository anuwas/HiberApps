package com.ems.hib.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
import com.ems.hib.dao.EmployeeMasterDAO;
import com.ems.hib.dto.EmployeeMaster;

@Transactional
public class EmployeeMasterDAOImpl implements EmployeeMasterDAO{

	private SessionFactory sessionFactory;
	
	 public EmployeeMasterDAOImpl(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	    }
	 
	@SuppressWarnings("unchecked")
	public List<EmployeeMaster> employeeList() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<EmployeeMaster> items = null;
		try {
			System.out.println("IN LIST");
			items = (List<EmployeeMaster>)session.createQuery("from EmployeeMaster").list();
			
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return items;
	}

	public void addEmployee(EmployeeMaster emp) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			session.save(emp);
		  } catch (HibernateException e) {
			  e.printStackTrace();
			  session.getTransaction().rollback();
		}
			session.getTransaction().commit();
	}

	public void updateEmployee(EmployeeMaster emp) {
		Session session = sessionFactory.getCurrentSession();
		try {
			System.out.println("IN Update");
			session.beginTransaction();
			session.saveOrUpdate(emp);
			} catch (HibernateException e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			}
		session.getTransaction().commit();
		
	}

	public EmployeeMaster getEmployee(Long id) {
		Session session = sessionFactory.getCurrentSession();
		EmployeeMaster emp=null;
		try {
			
			session.beginTransaction();
			emp = (EmployeeMaster) session.get(EmployeeMaster.class, id);
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return emp;
	}

	public void deleteEmployee(Long id) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		EmployeeMaster item = (EmployeeMaster) session.get(EmployeeMaster.class, id);
		if(null != item) {
			session.delete(item);
		}
		session.getTransaction().commit();
	}

}
