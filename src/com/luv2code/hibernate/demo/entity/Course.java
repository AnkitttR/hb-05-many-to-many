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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Course {

	//define our fields
	
	//define constructors
	
	//define getter setters
	
	//define toString
	
	//annotate fields 
	
	@Id  // Used for assigning primary key
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	private String title;
	
	// Imp Note: Before "To" represents where we are, in this case (Course.java), and after "To" represents where we are pointing (One if we are pointing towards Instructor, Many if we are pointing towards Reviews.)
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})    //Many courses to one instructor
	@JoinColumn(name="instructor_id")  //Course ka column hai instructor_id, jo point kar raha hai, towards primary key of instructor.
	private Instructor instructor;  //Reference to Instructor class
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL) //Because if we delete a course, then reviews must be deleted.
	@JoinColumn(name="course_id")
	private List<Review> reviews;
	
	@ManyToMany(fetch=FetchType.LAZY, cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	private List<Student> students;
	
	public Course() {  //No argument constructor
			
	}

	public Course(String title) {
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

		
	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	//add a convenience method (Simply an add method to add reviews)
	
	public void addReview(Review theReview) {  //addReview method will search for Review & store it in theReview variable
		if(reviews==null) {
			reviews=new ArrayList<>();
		}
		
		reviews.add(theReview);  //Hey reviews you have arraylist value, please add it to theReview variable.
	}
	
	
	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	//add a convenience method
	
	public void addStudent(Student theStudent) {
		if(students==null) {
			students = new ArrayList<>();
		}
		
		students.add(theStudent);  //Hey students you have arraylist value, please add it to theStudent variable.
	}
	
	
	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + ", instructor=" + instructor + "]";
	}
	
	
	
}
