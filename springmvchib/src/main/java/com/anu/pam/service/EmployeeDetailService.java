package com.anu.pam.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import com.anu.pam.model.Employee;
import com.anu.pam.model.EmployeeDetail;
import com.anu.pam.util.HibernateSessionUtil;

@Service
public class EmployeeDetailService {
	
	public List<EmployeeDetail> getEmployeeDetailWithNamedQueryByName() {
		Session session = HibernateSessionUtil.getHibernateSession();
		session.beginTransaction();
		
		Query query = session.getNamedQuery("EmployeeDetail.byEmployeeName");
		query.setString(0, "Anupam 1");
		List<EmployeeDetail> empDetailList = query.list();
		
		session.getTransaction().commit();
		session.close();
		return empDetailList;
	} 

}
