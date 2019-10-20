package com.daiict.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.daiict.dao.FeaturesDao;
import com.daiict.model.Features;
import com.daiict.repository.FeatureRepo;

@RestController
public class FeatureController {

	@Autowired
	FeaturesDao featuresDao;

	@PutMapping(path = "/feature/{feature_id}", consumes = { "application/json" })
	public String FeatureUpdateById(@PathVariable("feature_id") int feature_id, @RequestBody Features feature) {

		return featuresDao.UpdateFeature(feature_id, feature);
	}
	@GetMapping(path = "/feature")
	public List<Features> getAllFeatures() {
		
		return featuresDao.getAllFeatures();
	}
	
	@PostMapping(path = "/feature", consumes = { "application/json" })
	public String addFeature(@RequestBody Features feature) {
		
		return featuresDao.addFeature(feature);
	}

}
