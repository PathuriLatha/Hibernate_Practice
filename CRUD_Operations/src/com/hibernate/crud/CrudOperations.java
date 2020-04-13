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
		            
	    Student student=new Student();    
	    student.setId(301);    
	    student.setFirstName("Lasya");    
	    student.setLastName("Muthyala");    
	        
//	    session.save(student);  
	    session.persist(student);
	    
	    t.commit();  
	    System.out.println("successfully saved"); 
	    System.out.println();
	    System.out.println("==========Selecting data=========");
	    
	    List<Student> studentsList = new ArrayList();
//	    studentsList = session.createQuery("FROM Student").list();
	    studentsList = session.createQuery("FROM Student").getResultList();
	    
	    for(Student studentObj : studentsList) {
            System.out.println(studentObj.toString());
        }
 
	    factory.close();  
	    session.close();    
	  
	}

}
