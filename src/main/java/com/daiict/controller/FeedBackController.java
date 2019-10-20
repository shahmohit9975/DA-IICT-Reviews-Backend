package com.daiict.controller;

import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.daiict.dao.FeedBackDao;
import com.daiict.model.Feedback;

@RestController
public class FeedBackController {

	@Autowired
	FeedBackDao feedBackDao;

	@GetMapping(path = "/feedback")
	public List<Feedback> getAllFeedBack()
	{
		return feedBackDao.getAllFeedback();
	}
	
	@PostMapping(path = "/feedback", consumes = { "application/json" })
	public String addFeedback(@RequestBody String feedback) {

		Object obj = JSONValue.parse(feedback);
		JSONObject jsonObject = (JSONObject) obj;
		long long_student_id = (long) jsonObject.get("student_id");
		int student_id = Integer.parseInt(String.valueOf(long_student_id));
		return feedBackDao.addFeedBack(student_id, jsonObject.toString());
	}
}
