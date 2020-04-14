package com.hibernate.mapping;

public class Address {
	private int addressId;
	private String city;
	private String state;
	private String country;
	private Student student;

	public void setAddressId(int addressId){
		this.addressId = addressId;
	}
	public int getAddressId(){
		return  addressId;
	}
	public void setCity(String city){
		this.city = city;
	}
	public String getCity(){
		return  city;
	}
	public void setState(String state){
		this.state = state;
	}
	public String getState(){
		return  state;
	}
	public void setCountry(String country){
		this.country = country;
	}
	public String getCountry(){
		return  country;
	}
	public void setStudent(Student student){
		this.student = student;
	}
	public Student getStudent(){
		return  student;
	}
	
	//toString
	public String toString(){
		return "[addressId="+addressId+", city="+city+", state="+state+", country="+country+"]";
	}

}
