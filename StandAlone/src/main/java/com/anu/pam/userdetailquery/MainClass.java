package com.anu.pam.userdetailquery;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.anu.pam.model.UserDetailQuery;



public class MainClass {
	public static void main(String[] args) {
		//UserDetail userDetail = new UserDetail();
		//userDetail.setUserName("Anupam ");
		
		
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		//Using NamedQuery
		//Query query = session.getNamedQuery("UserDetailQuery.byId");
		//query.setInteger(0, 2);
		//List<UserDetail> userDetails = query.list();
		//System.out.println(userDetails.size());
		
		//Using NamedNativeQuery
		Query query = session.getNamedQuery("UserDetailQuery.byName");
		query.setString(0, "Anupam 1");
		List<UserDetailQuery> userDetails = query.list();
		System.out.println(userDetails.size());
		
		session.getTransaction().commit();
		session.close();
		
	}
}
