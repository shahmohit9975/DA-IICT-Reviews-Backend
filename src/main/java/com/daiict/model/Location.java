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
public class Location {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(length = 10)
	private int location_id;
	@Column(nullable = false, length = 25)
	private String location_name;
	@JoinColumn(name = "location_id")
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private Set<Internship> internship;

	public Set<Internship> getInternship() {
		return internship;
	}

	public void setInternship(Set<Internship> internship) {
		this.internship = internship;
	}

	public int getLocation_id() {
		return location_id;
	}

	public void setLocation_id(int location_id) {
		this.location_id = location_id;
	}

	public String getLocation_name() {
		return location_name;
	}

	public void setLocation_name(String location_name) {
		this.location_name = location_name;
	}

}
