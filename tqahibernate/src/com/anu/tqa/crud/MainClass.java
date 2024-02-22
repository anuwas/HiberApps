package com.anu.tqa.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.anu.tqa.crud.dto.UserDetail;

public class MainClass {
	public static void main(String[] args) {
		
		//Create
		/*
		for(int i=1;i<=10;i++) {
			UserDetail userDetail = new UserDetail();
			userDetail.setUserName("Anupam "+i);
			session.save(userDetail);
		}
		*/	
		//select
		/*
		UserDetail userDetail = (UserDetail)session.get(UserDetail.class, 3);
		System.out.println(userDetail.getUserName());
		*/
		
		//delete
		/*
		UserDetail userDetail = (UserDetail)session.get(UserDetail.class, 3);
		session.delete(userDetail);
		*/
		
		//update
		/*
		 UserDetail userDetail = (UserDetail)session.get(UserDetail.class, 4);
		userDetail.setUserName("Biswas");
		session.save(userDetail);
		 */
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		for(int i=1;i<=10;i++) {
			UserDetail userDetail = new UserDetail();
			userDetail.setUserName("Anupam "+i);
			session.save(userDetail);
		}

		session.getTransaction().commit();
		session.close();
		
	}
}
