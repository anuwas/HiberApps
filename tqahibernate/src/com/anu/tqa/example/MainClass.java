package com.anu.tqa.example;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;

import com.anu.tqa.example.dto.UserDetail;



public class MainClass {
	public static void main(String[] args) {
		//UserDetail userDetail = new UserDetail();
		//userDetail.setUserName("Anupam ");
		
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		
		UserDetail userDetail = new UserDetail();
		//userDetail.setUserId(5);
		//userDetail.setUserName("Anupam%");
		
		//Normal Property
		//Example example = Example.create(userDetail);
		
		//Exclude Property
		//Example example = Example.create(userDetail).excludeProperty("userName");
			
		//Enable LIke
		userDetail.setUserName("Anupam%");
		Example example = Example.create(userDetail).enableLike();
		
		//Exclude Property
		Criteria criteria = session.createCriteria(UserDetail.class).add(example);
		List<UserDetail> userDetails = criteria.list();
		System.out.println(userDetails.size());
		
		session.getTransaction().commit();
		session.close();
		
	}
}
