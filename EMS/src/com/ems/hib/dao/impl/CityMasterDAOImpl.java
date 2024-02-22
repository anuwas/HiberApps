package com.ems.hib.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
import com.ems.hib.dao.CityMasterDAO;
import com.ems.hib.dto.CityMaster;

@Transactional
public class CityMasterDAOImpl implements CityMasterDAO{

	private SessionFactory sessionFactory;
	
	public CityMasterDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	
	public CityMaster getCity(Long id) {
		Session session = sessionFactory.getCurrentSession();
		CityMaster city=null;
		try {
			
			session.beginTransaction();
			city = (CityMaster) session.get(CityMaster.class, id);
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return city;
	}

	@SuppressWarnings("unchecked")
	public List<CityMaster> cityMasterList() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<CityMaster> cityMaster=null;
		try{
			cityMaster=(List<CityMaster>) session.createQuery("from CityMaster").list();
			
		}catch(HibernateException e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return cityMaster;
	}

}
