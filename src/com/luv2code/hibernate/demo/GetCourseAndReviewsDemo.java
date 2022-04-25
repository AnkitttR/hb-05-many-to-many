package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;


public class GetCourseAndReviewsDemo {

	public static void main(String[] args) {
		

		//create session factory
		SessionFactory factory = new Configuration()
				                        .configure("hibernate.cfg.xml")
				                        .addAnnotatedClass(Instructor.class)
				                        .addAnnotatedClass(InstructorDetail.class)
				                        .addAnnotatedClass(Course.class)
				                        .addAnnotatedClass(Review.class)
				                        .buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		//factory is object of "SessionFactory Interface"
		//getCurrentSession() is method placed in "SessionFactory Interface"
		
		try {
				
			//Imp Note: Course & Review ki values Main app mein hi create hogi & Connection(Mapping) 
			//Wagareh ka kaam Course & Review apni apni classes mein karenge.
			
			//start a transaction
			session.beginTransaction();
						
			//get the course
			int theId = 10;
			Course tempCourse = session.get(Course.class, theId); //Session will extract course from database, and store it to tempCourse variable
			
			//print the course
			System.out.println("Deleting the course ...");
			System.out.println(tempCourse);
			
			//print the course reviews
			System.out.println(tempCourse.getReviews()); //Extract Reviews from tempCourse
			
			//delete the course
			session.delete(tempCourse); //Session is ordering database to delete the course
			
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
