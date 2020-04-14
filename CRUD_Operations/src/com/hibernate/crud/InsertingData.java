package com.hibernate.crud;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class InsertingData {

	public static void main(String[] args) {
		
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
	    Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
	  
		SessionFactory factory = meta.getSessionFactoryBuilder().build();  
		Session session = factory.openSession();  
		Transaction t = session.beginTransaction();
		
		System.out.println("===========Before Inserting Row=================");
        List<Student> studentsList = new ArrayList<Student>(); 
		// studentsList =session.createQuery("FROM Student").list(); 
		studentsList =  session.createQuery("FROM Student").getResultList();
		  
		
		  for(Student studentObj : studentsList) {
			  System.out.println(studentObj.toString()); 
		  }
		
		  System.out.println();
//		=================Inserting data==============================
		 Student student=new Student(); 
		 student.setId(1014);
		 student.setFirstName("Bhargavi"); 
		 student.setLastName("Bhargavi");
		  
		  // session.save(student); 
		 session.persist(student);
		  
		  t.commit(); System.out.println("successfully saved"); 
		  System.out.println();
		  
		  
		  
		  System.out.println("===========After Inserting Row=================");
//	        List<Student> studentsList = new ArrayList<Student>(); 
			// studentsList =session.createQuery("FROM Student").list(); 
			studentsList =  session.createQuery("FROM Student").getResultList();
			  
			
			  for(Student studentObj : studentsList) {
				  System.out.println(studentObj.toString()); 
			  }
	         
		
	}

}
