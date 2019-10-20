package com.daiict.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Faculty {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, length = 10)
	private int faculty_id;
	@Column(nullable = false, length = 50)
	private String faculty_name;
	@Column(nullable = false, length = 11)
	private String faculty_contact_no;
	@Column(nullable = false, length = 25)
	private String faculty_email_id;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "faculty")
	private Set<Internship> internship;

//	public Set<Internship> getInternship() {
//		return internship;
//	}

	public void setInternship(Set<Internship> internship) {
		this.internship = internship;
	}

	public int getFaculty_id() {
		return faculty_id;
	}

	public void setFaculty_id(int faculty_id) {
		this.faculty_id = faculty_id;
	}

	public String getFaculty_name() {
		return faculty_name;
	}

	public void setFaculty_name(String faculty_name) {
		this.faculty_name = faculty_name;
	}

	public String getFaculty_contact_no() {
		return faculty_contact_no;
	}

	public void setFaculty_contact_no(String faculty_contact_no) {
		this.faculty_contact_no = faculty_contact_no;
	}

	public String getFaculty_email_id() {
		return faculty_email_id;
	}

	public void setFaculty_email_id(String faculty_email_id) {
		this.faculty_email_id = faculty_email_id;
	}

//	@Override
//	public String toString() {
//		return "Faculty [faculty_id=" + faculty_id + ", faculty_name=" + faculty_name + ", faculty_contact_no="
//				+ faculty_contact_no + ", faculty_email_id=" + faculty_email_id + ", internship=" + internship + "]";
//	}

}
