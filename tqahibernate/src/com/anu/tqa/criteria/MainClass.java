package com.anu.tqa.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.anu.tqa.criteria.dto.UserDetail;



public class MainClass {
	public static void main(String[] args) {
		//UserDetail userDetail = new UserDetail();
		//userDetail.setUserName("Anupam ");
		
		
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		//using criteria
		Criteria criteria = session.createCriteria(UserDetail.class);
		criteria.add(Restrictions.eq("userName", "Anupam 1"));
		List<UserDetail> userDetails = criteria.list();
		System.out.println(userDetails.size());
		
		session.getTransaction().commit();
		session.close();
		
	}
}
