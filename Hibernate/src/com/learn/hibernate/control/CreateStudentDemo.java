package com.learn.hibernate.control;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.learn.hibernate.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		// Create Session Factory
			SessionFactory factory=new Configuration().
							configure("hibernate.cfg.xml").
							addAnnotatedClass(Student.class).
							buildSessionFactory();
			
		
			//Create session
			
			Session session = ((SessionFactory) factory).getCurrentSession();
			
			try {
				
				//Create a Student Object
				System.out.println("Creating new student object");
				Student obj=new Student("Soumyadip","Chowdhury","Soumyadip.note@gmail.com");
				
				//Start a transaction
				session.beginTransaction();
				
				
				//Save the student object
				System.out.println("Saving the student");
				session.save(obj);
				
				//Commit transaction
				session.getTransaction().commit();

				System.out.println("Done");
				
			}
			finally {
				factory.close();
			}
	
	}
}
	

