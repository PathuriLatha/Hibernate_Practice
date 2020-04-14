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

public class deleteData {

	public static void main(String[] args) {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
	    Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
	  
		SessionFactory factory = meta.getSessionFactoryBuilder().build();  
		Session session = factory.openSession();  
		Transaction t = session.beginTransaction();   
		
		System.out.println("===========Before Deleting Row=================");
        List<Student> studentsList = new ArrayList<Student>(); 
		// studentsList =session.createQuery("FROM Student").list(); 
		studentsList =  session.createQuery("FROM Student").getResultList();
		  
		
		  for(Student studentObj : studentsList) {
			  System.out.println(studentObj.toString()); 
		  }
		
		  System.out.println();
//		   =================Deleting data==============================
		
		int deleteingByid = 1005;
    	Student findStudentObj = (Student) session.load(Student.class, deleteingByid);
    	Student studObj = findStudentObj;
//    	System.out.println("==="+findStudentObj);
    	session.delete(studObj);
    	session.getTransaction().commit();
        System.out.println("\nStudent With Id?= " + deleteingByid + " Is Successfully Deleted From The Database!\n");
        
        System.out.println("===========After deleting Row=================");
//        List<Student> studentsList = new ArrayList<Student>(); 
		// studentsList =session.createQuery("FROM Student").list(); 
		studentsList =  session.createQuery("FROM Student").getResultList();
		  
		
		  for(Student studentObj : studentsList) {
			  System.out.println(studentObj.toString()); 
		  }
         
	}

}
