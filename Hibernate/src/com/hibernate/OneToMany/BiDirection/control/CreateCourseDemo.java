package com.hibernate.OneToMany.BiDirection.control;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.OneToMany.BiDirection.entity.*;
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
			
			
				//Start a transaction
				session.beginTransaction();
				//Get Instructor Details
				int id=1;
				Instructor obj=session.get(Instructor.class,id);
				
			
				Course temp1=new Course("Java");

				Course temp2=new Course("C++");
				
				
				obj.add(temp1);
				obj.add(temp2);
				
				
				session.save(temp1);
				session.save(temp2);
				//Save the Instructor object
				// And also save the associate object bcs we have CascadeType.all
				System.out.println("Saving the Instructor"+obj+temp1);
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
	

