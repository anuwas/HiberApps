package com.anu.tqa.hql.pagination;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import com.anu.tqa.hql.pagination.dto.UserDetail;




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
		Query query = session.createQuery("from UserDetail");
		query.setFirstResult(5);
		query.setMaxResults(10);
		List<UserDetail> userDetails = query.list();
		
		
		
		session.getTransaction().commit();
		session.close();
		
		for(UserDetail user : userDetails) {
			System.out.print(user.getUserName());
		}
		
		// For single value 
		//Query query = session.createQuery("select userName from  UserDetail");
		//List<String> userDetailString = query.list();
		
		//for multiple value - MAP
		//Query query = session.createQuery("select new Map(userId,userName) from  UserDetail");
	}
}
