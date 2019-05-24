package com.hibernate.OneToMany.BiDirection.control;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.OneToMany.BiDirection.entity.*;
import com.hibernate.curd.entity.Student;

public class GetInstructorDetailsDemo {

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
				
				//Start a transaction
				session.beginTransaction();
				
				
				
				//Get Instructor Details
				int id=1;
				Instructor obj=session.get(Instructor.class,id);
				
				// And also save the associate object bcs we have CascadeType.all
				System.out.println("Retrived object of InstructorDetail :"+obj);
				

				System.out.println("Courses :"+obj.getCourses());
			
				
				
				
				
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
	

/*Hibernate: select instructor0_.id as id1_1_0_, instructor0_.email as email2_1_0_, instructor0_.first_name as first_na3_1_0_, instructor0_.instructor_detail_id as instruct5_1_0_, instructor0_.last_name as last_nam4_1_0_, instructor1_.id as id1_2_1_, instructor1_.hobby as hobby2_2_1_, instructor1_.youtube_channel as youtube_3_2_1_ from instructor instructor0_ left outer join instructor_detail instructor1_ on instructor0_.instructor_detail_id=instructor1_.id where instructor0_.id=?
Retrived object of InstructorDetail :Instructor [id=1, firstname=Soumyadip, lastname=Chowdhury, email=Soumyadip.note@gmail.com, InstructorDetail=InstructorDetail [id=1, youtube_channel=https://github.com/soumyadip007, hobby=Coding]]
Hibernate: select courses0_.instructor_id as instruct3_0_0_, courses0_.id as id1_0_0_, courses0_.id as id1_0_1_, courses0_.instructor_id as instruct3_0_1_, courses0_.title as title2_0_1_ from course courses0_ where courses0_.instructor_id=?
Courses :[com.hibernate.OneToMany.UniDirection.entity.Course@1ee29c84, com.hibernate.OneToMany.UniDirection.entity.Course@7c8326a4]
Done
*/