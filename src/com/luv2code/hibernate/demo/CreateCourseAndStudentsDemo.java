package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;


public class CreateCourseAndStudentsDemo {

	public static void main(String[] args) {
		

		//create session factory
		SessionFactory factory = new Configuration()
				                        .configure("hibernate.cfg.xml")
				                        .addAnnotatedClass(Instructor.class)
				                        .addAnnotatedClass(InstructorDetail.class)
				                        .addAnnotatedClass(Course.class)
				                        .addAnnotatedClass(Review.class)
				                        .addAnnotatedClass(Student	.class)	
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
						
			//create a course
			Course tempCourse = new Course("Pacman - How To Score One Million Points");
			
			//save the course
			System.out.println("\nSaving the course ...");
			session.save(tempCourse); //Session says hey database please save tempCourse
			System.out.println("Saved the course: " + tempCourse);
			
			//create the students
			Student tempStudent1 = new Student("John","Doe","john@luv2code.com");
			Student tempStudent2 = new Student("Mary","Public","mary@luv2code.com");
			
			//add students to the course
			tempCourse.addStudent(tempStudent1); //Hey tempCourse please add tempStudent1 to Course
			tempCourse.addStudent(tempStudent2); //Hey tempCourse please add tempStudent2 to Course
			
			//save the students
			System.out.println("\nSaving students ...");
			session.save(tempStudent1); //Hey session please add tempStudent1 to database
			session.save(tempStudent2); //Hey session please add tempStudent2 to database
			System.out.println("Saved students: " + tempCourse.getStudents()); //Hey tempCourse please give me students
			
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
