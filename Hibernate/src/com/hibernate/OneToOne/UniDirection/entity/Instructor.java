package com.hibernate.OneToOne.UniDirection.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="instructor")
public class Instructor {

	@Id        //Primary key
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstname;
	

	@Column(name="last_name")
	private String lastname;
	
	@Column(name="email")
	private String email;
	
	@OneToOne (cascade=CascadeType.ALL)
	@JoinColumn(name="instructor_detail_id")
	private InstructorDetail instructorDetail;

	public Instructor(String firstname, String lastname, String email) {
	//	super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public InstructorDetail getObj() {
		return instructorDetail;
	}

	public void setInstructorDetail(InstructorDetail obj) {
		this.instructorDetail = obj;
	}
	
	public Instructor()
	{
		
	}
	

	@Override
	public String toString() {
		return "Instructor [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", InstructorDetail=" + instructorDetail + "]";
	}

	}
