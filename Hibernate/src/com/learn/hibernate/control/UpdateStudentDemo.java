package com.learn.hibernate.control;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.learn.hibernate.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		// Create Session Factory
			SessionFactory factory=new Configuration().
							configure("hibernate.cfg.xml").
							addAnnotatedClass(Student.class).
							buildSessionFactory();
			
		
			//Create session
			
			Session session = ((SessionFactory) factory).getCurrentSession();
			
			try {
				
			
				//Start a transaction
				session.beginTransaction();
				
				int id=1;
				Student obj=session.get(Student.class,id);
				

				System.out.println("Geting Student\n :"+obj);
				
				obj.setFirst_name("Soumyadip");
				
				//Commit transaction


				obj=session.get(Student.class,id);
				
				System.out.println("Updated Student\n :"+obj);
				

				session.getTransaction().commit();  
				System.out.println("Done");
				
				//Update For All
				
				session = ((SessionFactory) factory).getCurrentSession();

				session.beginTransaction();
				

				System.out.println("Updating All Student");

				session.createQuery("update Student set last_name='Chowdhury'").executeUpdate();  //S is the SQL object

					session.getTransaction().commit();  
					System.out.println("Done");
				
			}
			finally {
				factory.close();
			}
	
	}

	
	private static void displatStudents(List<Student> obj) {
		for(Student temp: obj)
		{
			System.out.println(temp);
		}
	}
}
	
/*Update Single student
Hibernate: select student0_.id as id1_0_0_, student0_.email as email2_0_0_, student0_.first_name as first_na3_0_0_, student0_.last_name as last_nam4_0_0_ from student student0_ where student0_.id=?
Geting Student
 :Student [id=1, first_name=Soumya, last_name=Chowdhury, email=Soumyadip.note@gmail.com]
Updated Student
 :Student [id=1, first_name=Soumyadip, last_name=Chowdhury, email=Soumyadip.note@gmail.com]
Hibernate: update student set email=?, first_name=?, last_name=? where id=?
Done

Update for all:
Updating All Student
Hibernate: update student set last_name='Chowdhury'
Done
*/