package com.hibernate.curd.control;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.curd.entity.Student;

public class DeleteStudentDemo {

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
				
				int id=10;
				Student obj=session.get(Student.class,id);
				

				System.out.println("Geting Student\n :"+obj);
				
				session.delete(obj);
				
				//session.createQuery("delete from Student where id=9").executeUpdate();  

				
				//Commit transaction

				
				System.out.println("Deleted Student\n :"+obj);
				

				session.getTransaction().commit();  
				System.out.println("Done");
				
				//Delete using query 
				
				
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
	
/*Hibernate: select student0_.id as id1_0_0_, student0_.email as email2_0_0_, student0_.first_name as first_na3_0_0_, student0_.last_name as last_nam4_0_0_ from student student0_ where student0_.id=?
Geting Student
 :Student [id=10, first_name=Reshmi, last_name=Chowdhury, email=Soumyadip.note@gmail.com]
Deleted Student
 :Student [id=10, first_name=Reshmi, last_name=Chowdhury, email=Soumyadip.note@gmail.com]
Hibernate: delete from student where id=?
Done

*/