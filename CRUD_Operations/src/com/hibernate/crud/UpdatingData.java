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

public class UpdatingData {

	public static void main(String[] args) {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
	    Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
	  
		SessionFactory factory = meta.getSessionFactoryBuilder().build();  
		Session session = factory.openSession();  
		Transaction t = session.beginTransaction();  
		
		System.out.println("===========Before Updating Row=================");
        List<Student> studentsList = new ArrayList<Student>(); 
		// studentsList =session.createQuery("FROM Student").list(); 
		studentsList =  session.createQuery("FROM Student").getResultList();
		  
		
		  for(Student studentObj : studentsList) {
			  System.out.println(studentObj.toString()); 
		  }
		
		  System.out.println();
		  
//		  =================Updating data==============================
		 int updatingWithId = 1004;
		    Student stuObj = (Student) session.get(Student.class, updatingWithId);
	        stuObj.setFirstName("Srivani");
	        stuObj.setLastName("Vani");

	        // Committing The Transactions To The Database
	      //  session.getTransaction().commit();
	        t.commit();
	        System.out.println("\nStudent With Id?= " + updatingWithId + " Is Successfully Updated In The Database!\n");
	       
	        System.out.println("===========After Updating Row=================");
//	        List<Student> studentsList = new ArrayList<Student>(); 
			// studentsList =session.createQuery("FROM Student").list(); 
			studentsList =  session.createQuery("FROM Student").getResultList();
			  
			
			  for(Student studentObj : studentsList) {
				  System.out.println(studentObj.toString()); 
			  }
	         

	}

}
