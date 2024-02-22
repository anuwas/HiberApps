package com.anu.tqa.mapping.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.anu.tqa.mapping.onetoone.dto.UserDetail;
import com.anu.tqa.mapping.onetoone.dto.Vehicle;


public class MainClass {
	public static void main(String[] args) {
		UserDetail userDetail = new UserDetail();
		//userDetail.setUserId(1);
		userDetail.setUserName("Anupam");
		
		Vehicle vechicle = new Vehicle();
		vechicle.setVehichlename("car");
		
		userDetail.setVehicle(vechicle);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(userDetail);
		session.save(vechicle);
		session.getTransaction().commit();
		session.close();
		
	}
}
