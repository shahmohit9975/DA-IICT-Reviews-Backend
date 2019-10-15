package com.daiict.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(length = 10)
	private int student_id;
	@Column(nullable = false, length = 20)
	private String student_name;
	@Column(nullable = false, length = 11)
	private String student_contact_number;
//	@JoinColumn(name = "course_id")
//	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//	private Course course;
	@JoinColumn(name = "student_id")
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private Set<Internship> internship;
	@JoinColumn(name = "student_id")
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Feedback> feedback;

	public Set<Internship> getInternship() {
		return internship;
	}

	public void setInternship(Set<Internship> internship) {
		this.internship = internship;
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public String getStudent_contact_number() {
		return student_contact_number;
	}

	public void setStudent_contact_number(String student_contact_number) {
		this.student_contact_number = student_contact_number;
	}

//	public Course getCourse() {
//		return course;
//	}
//
//	public void setCourse(Course course) {
//		this.course = course;
//	}

	public Set<Feedback> getFeedback() {
		return feedback;
	}

	public void setFeedback(Set<Feedback> feedback) {
		this.feedback = feedback;
	}

}
