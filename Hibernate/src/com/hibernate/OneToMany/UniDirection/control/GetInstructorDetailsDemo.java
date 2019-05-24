package com.hibernate.OneToMany.UniDirection.control;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.OneToMany.UniDirection.entity.Instructor;
import com.hibernate.OneToMany.UniDirection.entity.InstructorDetail;


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
				session.close();
				
				factory.close();
			}
	
	}
}
	

/*
Output:
Hibernate: select instructor0_.id as id1_1_0_, instructor0_.hobby as hobby2_1_0_, instructor0_.youtube_channel as youtube_3_1_0_ from instructor_detail instructor0_ where instructor0_.id=?
Retrived object of InstructorDetail :InstructorDetail [id=4, youtube_channel=https://github.com/soumyadip007, hobby=Coding]
Done
*/