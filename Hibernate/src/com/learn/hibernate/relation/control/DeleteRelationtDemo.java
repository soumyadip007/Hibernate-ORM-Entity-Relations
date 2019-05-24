package com.learn.hibernate.relation.control;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.learn.hibernate.entity.Student;
import com.learn.hibernate.relation.entity.Instructor;
import com.learn.hibernate.relation.entity.InstructorDetail;

public class DeleteRelationtDemo {

	public static void main(String[] args) {
		// Create Session Factory
			SessionFactory factory=new Configuration().
							configure("hibernate.cfg.xml").
							addAnnotatedClass(Instructor.class).
							addAnnotatedClass(InstructorDetail.class).
							buildSessionFactory();
			
		
			//Create session
			
			Session session =  factory.getCurrentSession();
			
			try {
				
				//Create a Student Object
				
				//Start a transaction
				session.beginTransaction();
				
				//Get primary Key
				
				int id=2;
				
				Instructor obj=session.get(Instructor.class,id);
				
				System.out.println("Found Instructor"+obj);
				
				if(obj != null)
				{
					System.out.println("Deleting the instructor"+obj);
					//Because we have cascadeType.all so it will delete from all DB table
					
					session.delete(obj);
					
				}
				
				
				//Commit transaction
				session.getTransaction().commit();

				System.out.println("Done");
				
			}
			finally {
				factory.close();
			}
	
	}
}
	

