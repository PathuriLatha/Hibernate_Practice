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

public class AddingData {

	public static void main(String[] args) {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
	    Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
	  
		SessionFactory factory = meta.getSessionFactoryBuilder().build();  
		Session session = factory.openSession();  
		Transaction t = session.beginTransaction();   
		

	    try {
	    	
			/*
			 * //	    =================Inserting data==============================
			 * Student student=new Student(); student.setId(1005);
			 * student.setFirstName("efg"); student.setLastName("efg");
			 * 
			 * // session.save(student); session.persist(student);
			 * 
			 * t.commit(); System.out.println("successfully saved"); System.out.println();
			 * System.out.println("==========Selecting data=========");
			 * 
			 * // =================Retrieving data==============================
			 * 
			 * List<Student> studentsList = new ArrayList(); // studentsList =
			 * session.createQuery("FROM Student").list(); studentsList =
			 * session.createQuery("FROM Student").getResultList();
			 * 
			 * for(Student studentObj : studentsList) {
			 * System.out.println(studentObj.toString()); }
			 * 
			 * // =================Updating data==============================
			 * 
			 * int updatingWithId = 108; Student stuObj = (Student)
			 * session.get(Student.class, updatingWithId);
			 * stuObj.setFirstName("Java Code Geek");
			 * stuObj.setLastName("Masters Of Technology");
			 * 
			 * // Committing The Transactions To The Database //
			 * session.getTransaction().commit(); t.commit();
			 * System.out.println("\nStudent With Id?= " + updatingWithId +
			 * " Is Successfully Updated In The Database!\n");
			 */
	    	int deleteingByid = 108;
	    	Student findStudentObj = (Student) session.load(Student.class, deleteingByid);
	    	Student studObj = findStudentObj;
//	    	System.out.println("==="+findStudentObj);
	    	session.delete(studObj);
	    	session.getTransaction().commit();
	        System.out.println("\nStudent With Id?= " + deleteingByid + " Is Successfully Deleted From The Database!\n");
	        
	        List<Student> studentsList = new ArrayList<Student>(); 
			// studentsList =session.createQuery("FROM Student").list(); 
			studentsList =  session.createQuery("FROM Student").getResultList();
			  
			  for(Student studentObj : studentsList) {
				  System.out.println(studentObj.toString()); 
			  }
	    }
	    catch(Exception e) {
	    	t.rollback();
	    	System.out.println("Transaction not successfully started");
	    }
	    	    
	    factory.close();  
	    session.close();    
	  
	}

}
