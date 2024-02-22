package com.anu.tqa.proxyobjectlaxyegarfetch;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.anu.tqa.proxyobjectlaxyegarfetch.dto.UserDetail;



public class MainClass {
	public static void main(String[] args) {
		UserDetail userDetail = new UserDetail();
		
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		userDetail = (UserDetail)session.get(UserDetail.class, 1);
		session.close();
		System.out.println(userDetail.getListOfAddress().size());
		
	}
}
