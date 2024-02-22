package com.anu.tqa.criteria.projections;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.anu.tqa.criteria.projections.dto.UserDetail;



public class MainClass {
	public static void main(String[] args) {
		//UserDetail userDetail = new UserDetail();
		//userDetail.setUserName("Anupam ");
		
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		//selecting only one property using projection
		//Criteria criteria = session.createCriteria(UserDetail.class).setProjection(Projections.property("userId"));
				
		
		//selecting only one property using projection
		//Criteria criteria = session.createCriteria(UserDetail.class).setProjection(Projections.max("userId"));
						
		//selecting count of userid
		//Criteria criteria = session.createCriteria(UserDetail.class).setProjection(Projections.count("userId"));
		
		//using Order
		Criteria criteria = session.createCriteria(UserDetail.class).addOrder(Order.desc("userId"));
		
				
		List<UserDetail> userDetails = criteria.list();
		System.out.println(userDetails.size());
		
		session.getTransaction().commit();
		session.close();
		
	}
}
