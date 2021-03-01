package com.example.angularspringbootdemo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="students")
public class Student {
	
	private long id;
	private String name;
    private String email;
    private String phone;
    private String branch;
	private String address;
	
	
    public Student() {
		
	}

	

	 public Student(long id, String name, String email, String phone, String branch, String address) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.branch = branch;
		this.address = address;
	}



	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 
	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String getBranch() {
		return branch;
	}



	public void setBranch(String branch) {
		this.branch = branch;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}
	 
	@Override
    public String toString() {
        return "Student [id=" + id + ","
        		+ " name=" +name + ","
        		+ " email=" + email + ","
        		+ " phone=" +phone + ","
        		+ " branch=" + branch + ","
        		+ " address=" + address
       + "]";
    }	
	
     

}
