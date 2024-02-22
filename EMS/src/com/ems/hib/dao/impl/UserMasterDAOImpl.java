package com.ems.hib.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.ems.hib.dao.UserMasterDAO;
import com.ems.hib.dto.ItemMaster;
import com.ems.hib.dto.UserMaster;

@Transactional
public class UserMasterDAOImpl implements UserMasterDAO{

	private SessionFactory sessionFactory;
	
	public UserMasterDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	
	public void addUserMaster(UserMaster userMaster) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			session.save(userMaster);
		  } catch (HibernateException e) {
			  e.printStackTrace();
			  session.getTransaction().rollback();
		}
			session.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public List<UserMaster> userMasterList() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<UserMaster> items = null;
		try {
			System.out.println("IN LIST");
			items = (List<UserMaster>)session.createQuery("from UserMaster").list();
			
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return items;
	}

	public void editUserMaster(UserMaster userMaster) {
		Session session = sessionFactory.getCurrentSession();
		try {
			System.out.println("IN Update");
			session.beginTransaction();
			session.saveOrUpdate(userMaster);
			} catch (HibernateException e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			}
		session.getTransaction().commit();
	}

	
	public UserMaster getUserMaster(Long id) {
		Session session = sessionFactory.getCurrentSession();
		UserMaster usermaster=null;
		try{
			session.beginTransaction();
			usermaster=(UserMaster) session.get(UserMaster.class, id);
		}catch(HibernateException e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return usermaster;
	}

	public void deleteUser(Long id) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		UserMaster userMaster=(UserMaster) session.get(UserMaster.class, id);
		if(null != userMaster) {
			session.delete(userMaster);
		}
		session.getTransaction().commit();
	}

	public void UserLogin(String username, String password) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
	}

	public UserMaster getUsreMasterByEmail(String email) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		UserMaster userMaster=null;
		try{
			userMaster=(UserMaster) session.createQuery("from UserMaster where email='"+email+"'").uniqueResult();
			
	     }catch(HibernateException e)
		{
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return userMaster;
	}

}
