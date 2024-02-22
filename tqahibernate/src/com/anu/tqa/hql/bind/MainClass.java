package com.anu.tqa.hql.bind;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import com.anu.tqa.hql.bind.dto.UserDetail;




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
		//bind example
		// I want those user whose id is > 5 with parameter bind
		/*Query query = session.createQuery("from UserDetail where userId > ?");
		query.setInteger(0, 5);
		List<UserDetail> userDetails = query.list();*/
		
		//two parameter example
		/*Query query = session.createQuery("from UserDetail where userId > ? and userName = ?");
		query.setInteger(0, 5);
		query.setString(1, "Anupam 5");
		List<UserDetail> userDetails = query.list();*/
		
		//Another way , instead of putting position we can use colone (:)
		Query query = session.createQuery("from UserDetail where userId > :userId and userName = :userName");
		query.setInteger("userId", 5);
		query.setString("userName", "Anupam 5");
		List<UserDetail> userDetails = query.list();
		
		session.getTransaction().commit();
		session.close();
		for(UserDetail user : userDetails) {
			System.out.println(user.getUserName());
		}
	}
}
