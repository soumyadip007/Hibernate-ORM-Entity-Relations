package com.learn.hibernate.control;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.learn.hibernate.entity.Student;

public class QueryStudentDemo {

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
				

				//query student 
				List<Student> obj=session.createQuery("from Student").list();
			
				System.out.println("\nAll students :\n");
				for(Student temp: obj)
				{
					System.out.println(temp);
				}
				
				
				//query Student : last_name="Chowdhury"
				obj=session.createQuery("from Student s where s.last_name='Chowdhury'").list();  //S is the SQL object
				
				System.out.println("\nStudents last_name=Chowdhury:\n");
				
				for(Student temp: obj)
				{
					System.out.println(temp);
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
	
