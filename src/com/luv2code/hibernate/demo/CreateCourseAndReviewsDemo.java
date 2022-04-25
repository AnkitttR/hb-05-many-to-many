package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;


public class CreateCourseAndReviewsDemo {

	public static void main(String[] args) {
		

		//create session factory
		SessionFactory factory = new Configuration()
				                        .configure("hibernate.cfg.xml")
				                        .addAnnotatedClass(Instructor.class)
				                        .addAnnotatedClass(InstructorDetail.class)
				                        .addAnnotatedClass(Course.class)
				                        .buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		//factory is object of "SessionFactory Interface"
		//getCurrentSession() is method placed in "SessionFactory Interface"
		
		try {
				
			
			
			//start a transaction
			session.beginTransaction();
						
			//create a course
			
			//add some reviews
			
			//save the course ... and leverage the cascade all
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
		}
		finally {
			
			//add clean up code
			session.close();
			
			factory.close();
		}
	}

}
