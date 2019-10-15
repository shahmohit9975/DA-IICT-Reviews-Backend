package com.daiict.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Features {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(length = 10)
	private int feature_id;
	@Column(nullable = false, length = 50)
	private String feature_name;
	@Column(nullable = false, length = 30)
	private String feature_route;
	@Column(nullable = false)
	private boolean is_student;
	@Column(nullable = false)
	private boolean is_admin;

	public int getFeature_id() {
		return feature_id;
	}

	public void setFeature_id(int feature_id) {
		this.feature_id = feature_id;
	}

	public String getFeature_name() {
		return feature_name;
	}

	public void setFeature_name(String feature_name) {
		this.feature_name = feature_name;
	}

	public String getFeature_route() {
		return feature_route;
	}

	public void setFeature_route(String feature_route) {
		this.feature_route = feature_route;
	}

	public boolean isIs_student() {
		return is_student;
	}

	public void setIs_student(boolean is_student) {
		this.is_student = is_student;
	}

	public boolean isIs_admin() {
		return is_admin;
	}

	public void setIs_admin(boolean is_admin) {
		this.is_admin = is_admin;
	}
}
