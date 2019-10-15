package com.daiict.dao;

import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daiict.model.Review;
import com.daiict.repository.ReviewRepo;

@Service
public class ReviewDao {

	@Autowired
	ReviewRepo reviewRepo;

	public List<Review> getReviewsByCompanyName(String companyName) {

		if (companyName == null || companyName.length() == 0) {

			return getAllReviews();

		}
		return reviewRepo.getAllReviewsByCompanyName(companyName);

	}

	public List<Review> getAllReviews() {

		return reviewRepo.getAllReviewsByDescendsingOrder();

	}
}
