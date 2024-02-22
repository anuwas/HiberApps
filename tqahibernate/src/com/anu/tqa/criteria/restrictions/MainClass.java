package com.anu.tqa.criteria.restrictions;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.anu.tqa.criteria.restrictions.dto.UserDetail;



public class MainClass {
	public static void main(String[] args) {
		//UserDetail userDetail = new UserDetail();
		//userDetail.setUserName("Anupam ");
		
		
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		//using criteria
		Criteria criteria = session.createCriteria(UserDetail.class);
		
		//Using equal
		/*criteria.add(Restrictions.eq("userName", "Anupam 6"))
		.add(Restrictions.gt("userId", 5));*/
		
		
		// Using Like and between
		/*criteria.add(Restrictions.like("userName", "Anupam%"))
		.add(Restrictions.between("userId", 5, 10));*/
		
		//Using Or
		criteria.add(Restrictions.or(Restrictions.between("userId", 1, 5),Restrictions.between("userId", 6, 10)));
		
		
		List<UserDetail> userDetails = criteria.list();
		System.out.println(userDetails.size());
		
		session.getTransaction().commit();
		session.close();
		
	}
}
