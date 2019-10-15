package com.daiict.model;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Internship {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(length = 10)
	private int internship_id;
//	@ManyToOne
//	@JoinColumn(name = "student_id")
//	private Student student;
//	@ManyToOne
//	@JoinColumn(name = "internship_type_id")
//	private Internship_type internship_type;
//
//	@ManyToOne
//	@JoinColumn(name = "company_id")
//	private Companies companies;
//	@ManyToOne
//	@JoinColumn(name = "faculty_id")
//	private Faculty faculty;
//	@ManyToOne
//	@JoinColumn(name = "location_id")
//	private Location location;
//	@ManyToOne
//	@JoinColumn(name = "job_profile_id")
//	private Job_profile job_profile;

	@Column(nullable = false, length = 6)
	private int stipend;
	@Column(nullable = false, length = 3)
	private int ctc;
	@Column(nullable = false)
	@CreationTimestamp
	private LocalDateTime added_on;
	@Column(nullable = false)
	private Date start_date;
	@Column(nullable = false, length = 200)
	private String offer_file;
	@Column
	private boolean approved_status;

//	@OneToOne(targetEntity = Review.class)
//	private Review review;
	public int getInternship_id() {
		return internship_id;
	}
	public void setInternship_id(int internship_id) {
		this.internship_id = internship_id;
	}
	public int getStipend() {
		return stipend;
	}
	public void setStipend(int stipend) {
		this.stipend = stipend;
	}
	public int getCtc() {
		return ctc;
	}
	public void setCtc(int ctc) {
		this.ctc = ctc;
	}
	public LocalDateTime getAdded_on() {
		return added_on;
	}
	public void setAdded_on(LocalDateTime added_on) {
		this.added_on = added_on;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public String getOffer_file() {
		return offer_file;
	}
	public void setOffer_file(String offer_file) {
		this.offer_file = offer_file;
	}
	public boolean isApproved_status() {
		return approved_status;
	}
	public void setApproved_status(boolean approved_status) {
		this.approved_status = approved_status;
	}
//	public Review getReview() {
//		return review;
//	}
//	public void setReview(Review review) {
//		this.review = review;
//	}

	
}
