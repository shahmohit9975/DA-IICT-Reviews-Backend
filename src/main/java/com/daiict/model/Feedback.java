package com.daiict.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
public class Feedback {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(length = 10)
	private int feedback_id;
//	@ManyToOne
//	@JoinColumn(name = "student_id")
//	private Student student;
	@Column(nullable = false, length = 50)
	private String feedback_title;
	@Column(length = 200)
	private String feedback_descri;
	@Column(nullable = false, length = 200)
	private String feedback_file;

	public int getFeedback_id() {
		return feedback_id;
	}

	public void setFeedback_id(int feedback_id) {
		this.feedback_id = feedback_id;
	}

//	public Student getStudent() {
//		return student;
//	}
//
//	public void setStudent(Student student) {
//		this.student = student;
//	}

	public String getFeedback_title() {
		return feedback_title;
	}

	public void setFeedback_title(String feedback_title) {
		this.feedback_title = feedback_title;
	}

	public String getFeedback_descri() {
		return feedback_descri;
	}

	public void setFeedback_descri(String feedback_descri) {
		this.feedback_descri = feedback_descri;
	}

	public String getFeedback_file() {
		return feedback_file;
	}

	public void setFeedback_file(String feedback_file) {
		this.feedback_file = feedback_file;
	}

}
