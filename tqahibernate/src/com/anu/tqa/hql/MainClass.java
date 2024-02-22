package com.anu.tqa.hql;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import com.anu.tqa.hql.dto.UserDetail;



public class MainClass {
	public static void main(String[] args) {
		//UserDetail userDetail = new UserDetail();
		//userDetail.setUserName("Anupam ");
		
		
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		/*
		Query query = session.createQuery("from UserDetail");
		List<UserDetail> userDetails = query.list();
		System.out.println(userDetails.size());
		*/
		//where clause
		// I want those user whose id is > 5
		Query query = session.createQuery("from UserDetail where userId > 5");
		List<UserDetail> userDetails = query.list();
		System.out.println(userDetails.size());
		
		
		session.getTransaction().commit();
		session.close();
		
	}
}
