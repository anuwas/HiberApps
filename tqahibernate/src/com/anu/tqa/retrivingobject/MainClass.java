package com.anu.tqa.retrivingobject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.anu.tqa.savingobject.dto.UserDetail;

public class MainClass {
public static void main(String[] args) {
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	Session session = sessionFactory.openSession();
	session.beginTransaction();
	UserDetail userDetail =  (UserDetail)session.get(UserDetail.class, 1);
	
	session.getTransaction().commit();
	session.close();
	
	System.out.println("user Name is "+userDetail.getUserName());
	
}
}
