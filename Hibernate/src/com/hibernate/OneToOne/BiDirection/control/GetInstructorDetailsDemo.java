package com.hibernate.OneToOne.BiDirection.control;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.OneToOne.UniDirection.entity.Instructor;
import com.hibernate.OneToOne.UniDirection.entity.InstructorDetail;
import com.hibernate.curd.entity.Student;

public class GetInstructorDetailsDemo {

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
				
				//Start a transaction
				session.beginTransaction();
				
				
				
				//Get Instructor Details
				int id=4;
				InstructorDetail obj=session.get(InstructorDetail.class,id);
				
			
				
				
				// And also save the associate object bcs we have CascadeType.all
				System.out.println("Retrived object of InstructorDetail :"+obj);
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
	

