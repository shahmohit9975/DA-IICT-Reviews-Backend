package com.daiict.model;

import java.util.Date;
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

import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(length = 10)
	private int course_id;
	@Column(nullable = false, length = 20)
	private String course_name;
	@Column(nullable = false)
	@LastModifiedDate
	private Date course_duration;
	@Column(nullable = false, length = 5)
	private int course_strength;
	@Column(nullable = false)
	private boolean course_status;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "course")
	private Set<Student> students;

	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public Date getCourse_duration() {
		return course_duration;
	}

	public void setCourse_duration(Date course_duration) {
		this.course_duration = course_duration;
	}

	public int getCourse_strength() {
		return course_strength;
	}

	public void setCourse_strength(int course_strength) {
		this.course_strength = course_strength;
	}

	public boolean isCourse_status() {
		return course_status;
	}

	public void setCourse_status(boolean course_status) {
		this.course_status = course_status;
	}
//
//	public Set<Student> getStudents() {
//		return students;
//	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

//	@Override
//	public String toString() {
//		return "Course [course_id=" + course_id + ", course_name=" + course_name + ", course_duration="
//				+ course_duration + ", course_strength=" + course_strength + ", course_status=" + course_status
//				+ ", students=" + students + "]";
//	}

}
