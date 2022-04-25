package com.luv2code.hibernate.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="instructor")
public class Instructor {

	//annotate the class as an entity and map to db table
	
	
		//define the fields 
		
		
		//annotate the fields with db column names
		
		//** set up mapping to InstructorDetail entity
		//create constructors
		
		
		//generate getter/setter methods
		
		
		//generate toString() method
	
		@Id   //Primary Key
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="id")
		private int id;
		
		@Column(name="first_name")
		private String firstName;
		
		@Column(name="last_name")
		private String lastName;
		
		@Column(name="email")
		private String email;
		
		@OneToOne(cascade=CascadeType.ALL)
		@JoinColumn(name="instructor_detail_id") //instructor_detail_id column of instructor class is pointing towards primary key of instructor detail.
		private InstructorDetail instructorDetail;
		
		@OneToMany(fetch=FetchType.LAZY,
				mappedBy="instructor", cascade= {CascadeType.PERSIST, CascadeType.MERGE, 
				CascadeType.DETACH, CascadeType.REFRESH}) //Refers to instructor property in course class
		private List<Course> courses;
		
		//List is interface, implemented by ArrayList class
		
		public Instructor() { //No Argument constructor
			
		}

		public Instructor(String firstName, String lastName, String email) {
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public InstructorDetail getInstructorDetail() {
			return instructorDetail;
		}

		public void setInstructorDetail(InstructorDetail instructorDetail) {
			this.instructorDetail = instructorDetail;
		}

		@Override
		public String toString() {
			return "Instructor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
					+ ", instructorDetail=" + instructorDetail + "]";
		}

		public List<Course> getCourses() {
			return courses;
		}

		public void setCourses(List<Course> courses) {
			this.courses = courses;
		}
		
		// add convenience methods for bi-directional relationship
		
		public void add(Course tempCourse) { //add method hai, Course class hai, tempCourse object hai Course class ka
			if (courses == null) {
				courses = new ArrayList<>();
			}
			courses.add(tempCourse); //courses mein jo value hai wo tempCourse mein add ho jayegi
			
			tempCourse.setInstructor(this);
		}
	
}
