package com.hibernate.curd.control;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.curd.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		// Create Session Factory
			SessionFactory factory=new Configuration().
							configure("hibernate.cfg.xml").
							addAnnotatedClass(Student.class).
							buildSessionFactory();
			
		
			//Create session
			
			Session session = ((SessionFactory) factory).getCurrentSession();
			
			try {
				
				//Create 3 Student Object
				System.out.println("Creating new student object");
				Student obj=new Student("Soumyadip","Chowdhury","Soumyadip.note@gmail.com");
				Student obj1=new Student("Soumyadip","Chowdhury","Soumyadip.cmp@gmail.com");
				Student obj2=new Student("Soumyadip","Chowdhury","Soumyadip123@gmail.com");
				
				
				//Start a transaction
				session.beginTransaction();
				
				
				//Save the student object
				System.out.println("Saving the student");
				session.save(obj);
				session.save(obj1);
				session.save(obj2);
				
				//Commit transaction
				session.getTransaction().commit();

				System.out.println("Done");
				
			}
			finally {
				factory.close();
			}
	
	}
}
	

