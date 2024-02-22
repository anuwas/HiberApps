package com.anu.tqa.mapping.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.anu.tqa.mapping.manytomany.dto.UserDetail;
import com.anu.tqa.mapping.manytomany.dto.Vehicle;



public class MainClass {
	public static void main(String[] args) {
		UserDetail userDetail = new UserDetail();
		//userDetail.setUserId(1);
		userDetail.setUserName("Anupam");
		
		Vehicle vechicle1 = new Vehicle();
		vechicle1.setVehichlename("car");
		
		Vehicle vechicle2 = new Vehicle();
		vechicle2.setVehichlename("jeep");
		
		userDetail.getVehicle().add(vechicle1);
		userDetail.getVehicle().add(vechicle2);
		
		vechicle1.getUserDetail().add(userDetail);
		vechicle2.getUserDetail().add(userDetail);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(userDetail);
		session.save(vechicle1);
		session.save(vechicle2);
		session.getTransaction().commit();
		session.close();
		
	}
}
