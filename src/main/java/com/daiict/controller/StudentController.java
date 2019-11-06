package com.daiict.controller;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.daiict.dao.StudentDao;

@RestController
public class StudentController {

	@Autowired
	StudentDao studentDao;

	@PostMapping(path = "/student", consumes = { "application/json" })
	public String addStudent(@RequestBody String student) {
		Object obj = JSONValue.parse(student);
		JSONObject jsonObject = (JSONObject) obj;
		String student_id = (String) jsonObject.get("student_id");
		if (!student_id.endsWith("@daiict.ac.in")) {
			throw new ResourceNotFoundException("Student email id must be ends with @daiict.ac.in");
		}
		long long_course_id = (long) jsonObject.get("course_id");
		int course_id = Integer.parseInt(String.valueOf(long_course_id));
		return studentDao.addStudent(course_id, jsonObject.toString());

	}
}
