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

@Entity
public class Job_profile {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(length = 10)
	private int job_profile_id;
	@Column(nullable = false, length = 25)
	private String job_profile_name;
	@JoinColumn(name = "job_profile_id")
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private Set<Internship> internship;

	public Set<Internship> getInternship() {
		return internship;
	}

	public void setInternship(Set<Internship> internship) {
		this.internship = internship;
	}

	public int getJob_profile_id() {
		return job_profile_id;
	}

	public void setJob_profile_id(int job_profile_id) {
		this.job_profile_id = job_profile_id;
	}

	public String getJob_profile_name() {
		return job_profile_name;
	}

	public void setJob_profile_name(String job_profile_name) {
		this.job_profile_name = job_profile_name;
	}

}
