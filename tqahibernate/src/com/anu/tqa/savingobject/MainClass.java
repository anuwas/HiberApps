package com.anu.tqa.savingobject;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.anu.tqa.savingobject.dto.UserDetail;

public class MainClass {
	public static void main(String[] args) {
		UserDetail userDetail = new UserDetail();
		//userDetail.setUserId(1);
		userDetail.setUserName("Anupam");
		userDetail.setAddress("Dumdum");
		userDetail.setJoinDate(new Date());
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(userDetail);
		session.getTransaction().commit();
		session.close();
		
	}
}
