package com.learn.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {

	@Id        //Primary key
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String first_name;
	

	@Column(name="last_name")
	private String last_name;
	
	@Column(name="email")
	private String email;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
	@Override     //For debugging
	public String toString() {
		return "Student [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", email=" + email
				+ "]";
	}
	
	public Student()
	{
		
	}

	public Student(String firstName, String lastName, String email) {
		this.first_name = firstName;
		this.last_name = lastName;
		this.email = email;
	}

	
}
