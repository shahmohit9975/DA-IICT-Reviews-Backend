package com.daiict.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.hibernate.annotations.Parameter;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.daiict.dao.ReviewDao;
import com.daiict.model.Review;

@RestController
public class ReviewController {
	@Autowired
	ReviewDao reviewdao;

	// get employee by id
	@GetMapping("/search/{search_string}")
	public List<Review> getReviewsByCompanyName(@PathVariable("search_string") String companyName) {

		return reviewdao.getReviewsByCompanyName(companyName);
	}

	@GetMapping("/search")
	public List<Review> getAllreviewsForSearchString() {

		return reviewdao.getAllReviewsForSearchStirng();
	}

	@GetMapping("/review")
	public List<Review> getAllreviews() {

		return reviewdao.getAllReviews();
	}

	@GetMapping("/review/company/{company_id}")
	public List<Review> getAllreviewsByCompanyId(@PathVariable("company_id") int company_id) {

		return reviewdao.getAllReviewsByCompanyId(company_id);
	}

	@PutMapping(path = "/review/{review_id}", consumes = { "application/json" })
	public String ReviewUpdateByAdmin(@PathVariable("review_id") int review_id, @RequestBody String review) {

		Object obj = JSONValue.parse(review);
		JSONObject jsonObject = (JSONObject) obj;

		long long_admin_id = (long) jsonObject.get("admin_id");
		long long_review_status = (long) jsonObject.get("review_status");

		int admin_id = Integer.parseInt(String.valueOf(long_admin_id));
		int review_status = Integer.parseInt(String.valueOf(long_review_status));
		
		return reviewdao.updateReviewStatus(review_id, admin_id, review_status);
	}

	@PostMapping(path = "/review", consumes = { "application/json" })
	public String addReview(@RequestBody String review) {

		Object obj = JSONValue.parse(review);
		JSONObject jsonObject = (JSONObject) obj;
		long long_internship_id = (long) jsonObject.get("internship_id");
		int internship_id = Integer.parseInt(String.valueOf(long_internship_id));
		System.out.println(jsonObject);
		return reviewdao.addReview(internship_id, jsonObject.toString());

	}
}
