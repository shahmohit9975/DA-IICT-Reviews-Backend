package com.daiict.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.daiict.model.Review;

public interface ReviewRepo extends JpaRepository<Review, Integer> {

//	@Query(value = "select emp.id, emp.expertise,emp.emp_name,dep.name from employee as emp join department as dep on emp.department_id=dep.department_id", nativeQuery = true)
//	List<Map<Object, Object>> save_emp();

	@Query(value = "select * FROM review where review_status=1 ORDER by review_date DESC", nativeQuery = true)
	List<Review> getAllReviewsByDescendsingOrder();

	@Query(value = "select rev.review_id  from review as rev join internship as inShip on(rev.internship_id=inShip.internship_id) join companies as com on(com.company_id=inShip.company_id) WHERE com.company_name1= ?1 OR com.company_name2= ?1 and rev.review_status=1 ORDER by rev.review_date DESC", nativeQuery = true)
	List<Review> getAllReviewsByCompanyName(String companyName);
}
