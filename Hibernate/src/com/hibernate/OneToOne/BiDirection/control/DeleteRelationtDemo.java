package com.hibernate.OneToOne.BiDirection.control;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.OneToOne.BiDirection.entity.*;
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
				
				int id=4;
				
				InstructorDetail objj=session.get(InstructorDetail.class,id);
				
				System.out.println("Found Instructor"+objj);
				
				if(objj != null)
				{
					System.out.println("Deleting the instructorDetail"+objj);
					

					System.out.println("Associative insuctor"+objj.getInstructor());
					
					//Because we have cascadeType.all so it will delete from all DB table
					
					session.delete(objj);
					
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
	

/*
Hibernate: select instructor0_.id as id1_1_0_, instructor0_.hobby as hobby2_1_0_, instructor0_.youtube_channel as youtube_3_1_0_, instructor1_.id as id1_0_1_, instructor1_.email as email2_0_1_, instructor1_.first_name as first_na3_0_1_, instructor1_.instructor_detail_id as instruct5_0_1_, instructor1_.last_name as last_nam4_0_1_ from instructor_detail instructor0_ left outer join instructor instructor1_ on instructor0_.id=instructor1_.instructor_detail_id where instructor0_.id=?
Found InstructorInstructorDetail [id=4, youtube_channel=https://github.com/soumyadip007, hobby=Coding]
Deleting the instructorDetailInstructorDetail [id=4, youtube_channel=https://github.com/soumyadip007, hobby=Coding]
Associative insuctorInstructor [id=1, firstname=Soumyadip, lastname=Chowdhury, email=Soumyadip.note@gmail.com, InstructorDetail=InstructorDetail [id=4, youtube_channel=https://github.com/soumyadip007, hobby=Coding]]
Hibernate: delete from instructor where id=?
Hibernate: delete from instructor_detail where id=?
Done
May 24, 2019 2:04:21 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl$PoolState stop
INFO: HHH10001008: Cleaning up connection pool [jdbc:mysql://localhost:3306/hibernate]
*/