package com.daiict.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.daiict.dao.AdminDao;
import com.daiict.dao.FacultyDao;
import com.daiict.model.Admin;
import com.daiict.model.Faculty;

@RestController
public class FacultyController {

	@Autowired
	FacultyDao facultyDao;
	
	

	@GetMapping(path = "/faculty")
	public List<Faculty> getAllFaculty() {

		return facultyDao.getAllFaculty();
	}

	@PostMapping(path = "/faculty")
	public String saveFaculty(@Valid @RequestBody Faculty faculty) {

		if (!faculty.getFaculty_id().endsWith("@daiict.ac.in")) {
			throw new ResourceNotFoundException("faculty email id must be ends with @daiict.ac.in");
		}
		return facultyDao.saveFaculty(faculty);
	}
}
