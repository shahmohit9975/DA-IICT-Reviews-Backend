package com.daiict.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.daiict.model.Internship;

@RepositoryRestResource(collectionResourceRel = "internship", path = "internship")
public interface InternShipRepo extends JpaRepository<Internship, Integer> {

}
