package com.hibernate.fetch.EgerVsLazy;
//Connected to OneToMany.BiDirection.entity.*
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.hibernate.OneToMany.BiDirection.entity.*;
import com.hibernate.curd.entity.Student;

public class FetchJoinDemo {

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

				Query<Instructor> query = 
						session.createQuery("select i from Instructor i "
										+ "JOIN FETCH i.courses "
										+ "where i.id=:theInstructorId", 
								Instructor.class);

				// set parameter on query
				query.setParameter("theInstructorId", id);
				
				// execute query and get instructor
				Instructor tempInstructor = query.getSingleResult();
			
				// And also save the associate object bcs we have CascadeType.all
				System.out.println("Retrived object of InstructorDetail :"+tempInstructor);
				

				System.out.println("Courses :"+tempInstructor.getCourses());				
				

				session.close();
				
				System.out.println("Courses :"+tempInstructor.getCourses());				
				

				
				//Commit transaction
				session.getTransaction().commit();

				System.out.println("Done");
				
			}
			finally {
				
				factory.close();
			}
	
	}
}
	

/*
Hibernate: select instructor0_.id as id1_1_0_, courses1_.id as id1_0_1_, instructor0_.email as email2_1_0_, instructor0_.first_name as first_na3_1_0_, instructor0_.instructor_detail_id as instruct5_1_0_, instructor0_.last_name as last_nam4_1_0_, courses1_.instructor_id as instruct3_0_1_, courses1_.title as title2_0_1_, courses1_.instructor_id as instruct3_0_0__, courses1_.id as id1_0_0__ from instructor instructor0_ inner join course courses1_ on instructor0_.id=courses1_.instructor_id where instructor0_.id=?
Hibernate: select instructor0_.id as id1_2_0_, instructor0_.hobby as hobby2_2_0_, instructor0_.youtube_channel as youtube_3_2_0_ from instructor_detail instructor0_ where instructor0_.id=?
Retrived object of InstructorDetail :Instructor [id=1, firstname=Soumyadip, lastname=Chowdhury, email=Soumyadip.note@gmail.com, InstructorDetail=InstructorDetail [id=1, youtube_channel=https://github.com/soumyadip007, hobby=Coding]]
Courses :[com.hibernate.OneToMany.BiDirection.entity.Course@368d5c00, com.hibernate.OneToMany.BiDirection.entity.Course@7e46d648]
Courses :[com.hibernate.OneToMany.BiDirection.entity.Course@368d5c00, com.hibernate.OneToMany.BiDirection.entity.Course@7e46d648]


*/