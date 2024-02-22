package com.anu.tqa.inheritance;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.anu.tqa.inheritance.dto.FourWheeler;
import com.anu.tqa.inheritance.dto.TwoWheeler;
import com.anu.tqa.inheritance.dto.Vehicle;



public class MainClass {
	public static void main(String[] args) {
		
		
		Vehicle vechicle = new Vehicle();
		vechicle.setVehicleName("car");
		
		
		TwoWheeler twoWheeler = new TwoWheeler();
		twoWheeler.setVehicleName("bike");
		twoWheeler.setStreeingHandle("handle");
		
		FourWheeler fourWheeler = new FourWheeler();
		fourWheeler.setVehicleName("truck");
		fourWheeler.setStreeingWheel("wheel");
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(vechicle);
		session.save(twoWheeler);
		session.save(fourWheeler);
		session.getTransaction().commit();
		session.close();
		
	}
}
