package com.daiict.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public List<Review> getAllreviews() {
		
		return reviewdao.getAllReviews();
	}
}
