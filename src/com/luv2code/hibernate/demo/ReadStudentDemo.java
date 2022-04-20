package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;


public class ReadStudentDemo {

	public static void main(String[] args) {
		

		//create session factory
		SessionFactory factory = new Configuration()
				                        .configure("hibernate.cfg.xml")
				                        .addAnnotatedClass(Student.class)
				                        .buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			
			//create a student object
			System.out.println("Creating new student object...");
			Student tempStudent = new Student("Daffy","Duck","daffy@luv2code.com");
						
			//start a transaction
			session.beginTransaction();
			
			//save the student object
			System.out.println("Saving the student...");
			System.out.println(tempStudent);
			session.save(tempStudent);
			
			//commit transaction
			session.getTransaction().commit();
			
			//My New Code
			
			
			//find out the student's id: primary key
			System.out.println("Saved student. Generated id: " + tempStudent.getId());
			System.out.println("Done!");
			
		}
		finally {
			factory.close();
		}
	}

}
