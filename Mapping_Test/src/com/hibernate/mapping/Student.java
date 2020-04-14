package com.hibernate.mapping;

public class Student {
	private int studentId;
	private String studentName;
	private Address address;

	public void setStudentId(int studentId){
		this.studentId = studentId;
	}
	public int getStudentId(){
		return  studentId;
	}
	public void setStudentName(String studentName){
		this.studentName = studentName;
	}
	public String getStudentName(){
		return  studentName;
	}
	
	public void setAddress(Address address){
		this.address= address;
	}
	public Address getAddress(){
		return  address;
	}

	//toString
	public String toString(){
		return "[studentid="+studentId+", studentname="+studentName+", address="+address+"]";
	}

}
