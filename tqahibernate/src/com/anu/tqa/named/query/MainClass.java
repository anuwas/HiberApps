package com.anu.tqa.named.query;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import com.anu.tqa.named.query.dto.UserDetail;




public class MainClass {
	public static void main(String[] args) {
		//UserDetail userDetail = new UserDetail();
		//userDetail.setUserName("Anupam ");
		
		
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		//Using NamedQuery
		//Query query = session.getNamedQuery("UserDetail.byId");
		//query.setInteger(0, 2);
		//List<UserDetail> userDetails = query.list();
		//System.out.println(userDetails.size());
		
		//Using NamedNativeQuery
		Query query = session.getNamedQuery("UserDetail.byName");
		query.setString(0, "Anupam 1");
		List<UserDetail> userDetails = query.list();
		System.out.println(userDetails.size());
		
		session.getTransaction().commit();
		session.close();
		
	}
}
