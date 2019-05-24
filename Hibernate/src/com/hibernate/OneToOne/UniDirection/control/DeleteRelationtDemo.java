package com.hibernate.OneToOne.UniDirection.control;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.OneToOne.UniDirection.entity.Instructor;
import com.hibernate.OneToOne.UniDirection.entity.InstructorDetail;
import com.hibernate.curd.entity.Student;

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
				
				Instructor objj=session.get(Instructor.class,id);
				
				System.out.println("Found Instructor"+objj);
				
				if(objj != null)
				{
					System.out.println("Deleting the instructor"+objj);
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
	

/*May 24, 2019 1:01:39 PM org.hibernate.Version logVersion
INFO: HHH000412: Hibernate Core {5.4.2.Final}
May 24, 2019 1:01:40 PM org.hibernate.annotations.common.reflection.java.JavaReflectionManager <clinit>
INFO: HCANN000001: Hibernate Commons Annotations {5.1.0.Final}
May 24, 2019 1:01:40 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl configure
WARN: HHH10001002: Using Hibernate built-in connection pool (not for production use!)
May 24, 2019 1:01:40 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl buildCreator
INFO: HHH10001005: using driver [com.mysql.jdbc.Driver] at URL [jdbc:mysql://localhost:3306/hibernate]
May 24, 2019 1:01:40 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl buildCreator
INFO: HHH10001001: Connection properties: {user=root, password=****}
May 24, 2019 1:01:40 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl buildCreator
INFO: HHH10001003: Autocommit mode: false
May 24, 2019 1:01:40 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl$PooledConnections <init>
INFO: HHH000115: Hibernate connection pool size: 1 (min=1)
May 24, 2019 1:01:40 PM org.hibernate.dialect.Dialect <init>
INFO: HHH000400: Using dialect: org.hibernate.dialect.MySQLDialect
Output:
Hibernate: select instructor0_.id as id1_0_0_, instructor0_.email as email2_0_0_, instructor0_.first_name as first_na3_0_0_, instructor0_.instructor_detail_id as instruct5_0_0_, instructor0_.last_name as last_nam4_0_0_, instructor1_.id as id1_1_1_, instructor1_.hobby as hobby2_1_1_, instructor1_.youtube_channel as youtube_3_1_1_ from instructor instructor0_ left outer join instructor_detail instructor1_ on instructor0_.instructor_detail_id=instructor1_.id where instructor0_.id=?
Found InstructorInstructor [id=2, firstname=Soumyadip, lastname=Chowdhury, email=Soumyadip.note@gmail.com, InstructorDetail=InstructorDetail [id=5, youtube_channel=https://github.com/soumyadip007, hobby=Coding]]
Deleting the instructorInstructor [id=2, firstname=Soumyadip, lastname=Chowdhury, email=Soumyadip.note@gmail.com, InstructorDetail=InstructorDetail [id=5, youtube_channel=https://github.com/soumyadip007, hobby=Coding]]
Hibernate: delete from instructor where id=?
Hibernate: delete from instructor_detail where id=?
Done
May 24, 2019 1:01:41 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl$PoolState stop
INFO: HHH10001008: Cleaning up connection pool [jdbc:mysql://localhost:3306/hibernate]
*/