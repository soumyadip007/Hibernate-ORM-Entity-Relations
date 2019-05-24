package com.hibernate.OneToMany.UniDirection.control;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.OneToMany.UniDirection.entity.*;

public class CreateCourseDemo {

	public static void main(String[] args) {
		// Create Session Factory
			SessionFactory factory=new Configuration().
							configure("hibernate.cfg.xml").
							addAnnotatedClass(Instructor.class).
							addAnnotatedClass(InstructorDetail.class).
							addAnnotatedClass(Course.class).
							buildSessionFactory();
			
		
			//Create session
			
			Session session = ((SessionFactory) factory).getCurrentSession();
			
			try {
				
				//Create a Student Object
				System.out.println("Creating new student object");
				Instructor obj=new Instructor("Soumyadip","Chowdhury","Soumyadip.note@gmail.com");
				
				InstructorDetail instructorDetail=new InstructorDetail("https://github.com/soumyadip007","Coding");
				
				
				//Associate the objects (Object to Object relation) 
				obj.setInstructorDetail(instructorDetail);
				
				
				//Start a transaction
				session.beginTransaction();
				
				
				//Save the Instructor object
				// And also save the associate object bcs we have CascadeType.all
				System.out.println("Saving the Instructor"+obj);
				session.save(obj);
				
				//Commit transaction
				session.getTransaction().commit();

				System.out.println("Done");
				
			}
			finally {
				session.close();
				factory.close();
			}
	
	}
}
	

