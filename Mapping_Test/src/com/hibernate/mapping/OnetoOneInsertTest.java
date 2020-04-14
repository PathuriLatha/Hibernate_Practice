package com.hibernate.mapping;

import java.lang.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OnetoOneInsertTest {
	public static void main(String args[]){

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml"); 

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();		
		
		Address address = new Address();
		address.setCity("avr");
		address.setState("ts");
		address.setCountry("india");
		Student student = new Student();
		student.setStudentName("Latha");
		student.setAddress(address);
		address.setStudent(student);

		System.out.println("students="+student);

		Transaction tx = null;
		try{
    			tx = session.beginTransaction();
    			session.save(student);
    			tx.commit();
   			System.out.println("one To one uni-Directional is Done..!!");
		}
		catch(Exception e){
			tx.rollback();
			System.out.println("one To one uni-Directional is  not Done..!!");
			e.printStackTrace();
	  	}
		session.close();
		factory.close();
	}

}
