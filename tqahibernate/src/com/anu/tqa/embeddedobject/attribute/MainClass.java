package com.anu.tqa.embeddedobject.attribute;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.anu.tqa.embeddedobject.attribute.dto.Address;
import com.anu.tqa.embeddedobject.attribute.dto.UserDetail;



public class MainClass {
	public static void main(String[] args) {
		UserDetail userDetail = new UserDetail();
		userDetail.setUserId(2);
		userDetail.setUserName("Anupam");
		userDetail.setJoinDate(new Date());
		
		Address homeAddress = new Address();
		Address officeAddress = new Address();
		homeAddress.setCity("Kolkata");
		homeAddress.setPincode("700077");
		homeAddress.setState("WestBengal");
		homeAddress.setStreet("R.N Tegore");
		
		officeAddress.setCity("Nadia");
		officeAddress.setPincode("741318");
		officeAddress.setState("WestBengal");
		officeAddress.setStreet("R.N Tegore");
		
		userDetail.setHomeAddress(homeAddress);
		userDetail.setOfficeAddress(officeAddress);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(userDetail);
		session.getTransaction().commit();
		session.close();
		
	}
}
