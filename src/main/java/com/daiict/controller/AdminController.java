package com.daiict.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daiict.dao.AdminDao;
import com.daiict.model.Admin;
import com.daiict.model.Features;

@RestController
public class AdminController {
	@Autowired
	AdminDao adminDao;

	@GetMapping(path = "/admin")
	public List<Admin> getAllFeatures() {

		return adminDao.getAllAdmin();
	}

	@PostMapping(path = "/admin")
	public String saveAdmin(@Valid @RequestBody Admin admin) {

		if (!admin.getAdmin_id().endsWith("@daiict.ac.in")) {
			throw new ResourceNotFoundException("admin email id must be ends with @daiict.ac.in");
		}
		return adminDao.saveAdmin(admin);
	}
}
