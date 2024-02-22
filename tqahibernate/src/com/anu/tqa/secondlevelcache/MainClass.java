package com.anu.tqa.secondlevelcache;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.anu.tqa.secondlevelcache.dto.UserDetail;



public class MainClass {
	public static void main(String[] args) {
		//UserDetail userDetail = new UserDetail();
		//userDetail.setUserName("Anupam ");
		
		
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		UserDetail userDetail1 = (UserDetail) session.get(UserDetail.class, 1);
		
		session.getTransaction().commit();
		session.close();
		
		Session session2 = sessionFactory.openSession();
		session2.beginTransaction();
		
		UserDetail userDetail12 = (UserDetail) session.get(UserDetail.class, 1);
		
		session2.getTransaction().commit();
		session2.close();
	}
}
