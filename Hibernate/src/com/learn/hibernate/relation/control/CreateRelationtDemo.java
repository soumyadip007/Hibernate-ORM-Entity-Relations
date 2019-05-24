package com.learn.hibernate.relation.control;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.learn.hibernate.entity.Student;
import com.learn.hibernate.relation.entity.Instructor;
import com.learn.hibernate.relation.entity.InstructorDetail;

public class CreateRelationtDemo {

	public static void main(String[] args) {
		// Create Session Factory
			SessionFactory factory=new Configuration().
							configure("hibernate.cfg.xml").
							addAnnotatedClass(Instructor.class).
							addAnnotatedClass(InstructorDetail.class).
							buildSessionFactory();
			
		
			//Create session
			
			Session session = ((SessionFactory) factory).getCurrentSession();
			
			try {
				
				//Create a Student Object
				System.out.println("Creating new student object");
				Instructor obj=new Instructor("Soumyadip","Chowdhury","Soumyadip.note@gmail.com");
				
				InstructorDetail instructorDetail=new InstructorDetail("https://github.com/soumyadip007","Soumyadip.note@gmail.com");
				
				
				//Associate the objects (Object to Object relation) 
				obj.setInstructorDetail(instructorDetail);
				
				
				//Start a transaction
				session.beginTransaction();
				
				
				//Save the student object
				System.out.println("Saving the Instructor");
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
	

