package com.daiict.controller;

import java.util.List;

import javax.validation.Valid;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.daiict.dao.InternshipDao;
import com.daiict.model.Internship;
import com.daiict.model.Review;
import com.daiict.repository.InternShipRepo;

@RestController
public class InternshipController {

	@Autowired
	InternshipDao internshpDao;

	@GetMapping(path = "/internship", produces = { "application/json" })
	public @PostMapping List<Internship> getAllInternship() {

		return internshpDao.getAllIntenship();
	}

	@PutMapping(path = "/internship/{internship_id}")
	public String updateInternshipApprovedStatus(@PathVariable(name = "internship_id") int internship_id) {

		return internshpDao.updateStatus(internship_id);
	}

	@PostMapping(path = "/internship", consumes = { "application/json" })
	public String addInternship(@Valid @RequestBody String internship) {

		Object obj = JSONValue.parse(internship);
		JSONObject jsonObject = (JSONObject) obj;

		String long_company_id = null;
		try {

			long_company_id = (String) jsonObject.get("company_id");
		} catch (Exception e) {

			long_company_id = String.valueOf((long) jsonObject.get("company_id"));
		}
		long long_internship_type_id = (long) jsonObject.get("internship_type_id");
		long long_job_profile_id = (long) jsonObject.get("job_profile_id");
		long long_location_id = (long) jsonObject.get("location_id");

		if (long_company_id == null || long_company_id.length() == 0) {
			long_company_id = "0";
		}
		int company_id = Integer.parseInt(String.valueOf(long_company_id));
		int internship_type_id = Integer.parseInt(String.valueOf(long_internship_type_id));
		int job_profile_id = Integer.parseInt(String.valueOf(long_job_profile_id));
		int location_id = Integer.parseInt(String.valueOf(long_location_id));
		String student_id = (String) jsonObject.get("student_id");
		String faculty_id = (String) jsonObject.get("faculty_id");

		boolean isCompany = faculty_id.length() == 0 || faculty_id == null ? true : false;

//		System.out.println(jsonObject);
		System.out.println("=============");
		return internshpDao.addInternship(company_id, faculty_id, isCompany, internship_type_id, job_profile_id,
				location_id, student_id, jsonObject.toString());

	}
}
