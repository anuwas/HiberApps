package com.ems.hib.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.ems.hib.dao.CountryMasterDAO;
import com.ems.hib.dto.CountryMaster;

@Transactional
public class CountryMasterDAOImpl implements CountryMasterDAO{

	private SessionFactory sessionFactory;
	
	public CountryMasterDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	public CountryMaster getCountry(Long id) {
		Session session = sessionFactory.getCurrentSession();
		CountryMaster country=null;
		try {
			session.beginTransaction();
			country = (CountryMaster) session.get(CountryMaster.class, id);
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return country;
	}
	@SuppressWarnings("unchecked")
	public List<CountryMaster> countryMasterList() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<CountryMaster> countryMaster=null;
		try{
			countryMaster=(List<CountryMaster>) session.createQuery("from CountryMaster").list();
		}catch(HibernateException e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return countryMaster;
	}

}
