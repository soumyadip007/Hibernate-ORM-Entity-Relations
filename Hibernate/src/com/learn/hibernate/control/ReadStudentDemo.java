package com.learn.hibernate.control;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.learn.hibernate.entity.Student;

public class ReadStudentDemo {

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
				Student obj=new Student("Reshmi","Palit","Soumyadip.note@gmail.com");
				
				//Start a transaction
				session.beginTransaction();
				
				
				//Save the student object
				System.out.println("Saving the student");
				System.out.println(obj);
				session.save(obj);
				
				
				//find out the student id :primary key
				System.out.println("Saved student ID:"+obj.getId());
				Student obj1=session.get(Student.class,obj.getId());
				

				System.out.println("Geting Id\n complete:"+obj1);
				
				//Commit transaction
				session.getTransaction().commit();

				System.out.println("Done");
				
			}
			finally {
				factory.close();
			}
	
	}
}
	

