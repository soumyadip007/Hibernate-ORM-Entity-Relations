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
	

