package com.anu.tqa.configuringcollectionandkeys;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.anu.tqa.configuringcollectionandkeys.dto.Address;
import com.anu.tqa.configuringcollectionandkeys.dto.UserDetail;



public class MainClass {
	public static void main(String[] args) {
		UserDetail userDetail = new UserDetail();
		userDetail.setUserId(1);
		userDetail.setUserName("Anupam");
		
		Address address = new Address();
		address.setCity("Kolkata");
		address.setPincode("700077");
		address.setState("WestBengal");
		address.setStreet("R.N Tegore");
		
		Address address2 = new Address();
		address2.setCity("Kolkata");
		address2.setPincode("700077");
		address2.setState("WestBengal");
		address2.setStreet("R.N Tegore");
		
		userDetail.getListOfAddress().add(address);
		userDetail.getListOfAddress().add(address2);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(userDetail);
		session.getTransaction().commit();
		session.close();
		
	}
}
