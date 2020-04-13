package com.hibernate.crud;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name= "student")
public class Student{ 
	  
	@Id   
	@Column(name = "id")
	private int id;   
	
	@Column(name = "firstName")
	private String firstName;
	
	@Column(name = "lastName")
	private String lastName;    
	    
	public int getId() {    
	    return id;    
	}    
	public void setId(int id) {    
	    this.id = id;    
	}    
	public String getFirstName() {    
	    return firstName;    
	}    
	public void setFirstName(String firstName) {    
	    this.firstName = firstName;    
	}    
	public String getLastName() {    
	    return lastName;    
	}    
	public void setLastName(String lastName) {    
	    this.lastName = lastName;    
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}    

	
	
	
}
