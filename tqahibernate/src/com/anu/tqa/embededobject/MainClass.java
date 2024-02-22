package com.anu.tqa.embededobject;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.anu.tqa.embededobject.dto.Address;
import com.anu.tqa.embededobject.dto.UserDetail;

public class MainClass {
	public static void main(String[] args) {
		UserDetail userDetail = new UserDetail();
		//userDetail.setUserId(1);
		userDetail.setUserName("Anupam");
		userDetail.setJoinDate(new Date());
		
		Address address = new Address();
		address.setCity("Kolkata");
		address.setPincode("700077");
		address.setState("WestBengal");
		address.setStreet("R.N Tegore");
		userDetail.setAddress(address);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(userDetail);
		session.getTransaction().commit();
		session.close();
		
	}
}
