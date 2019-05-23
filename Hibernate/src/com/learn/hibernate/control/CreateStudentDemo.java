package com.learn.hibernate.control;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import com.learn.hibernate.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		// Create Session Factory
			Session factory=(Session) new Configuration().
							configure("hibernate.cfg.xml").
							addAnnotatedClass(Student.class).
							buildSessionFactory();
	}

}
