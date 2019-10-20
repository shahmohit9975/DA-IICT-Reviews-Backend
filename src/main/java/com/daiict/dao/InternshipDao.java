package com.daiict.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daiict.model.Companies;
import com.daiict.model.Faculty;
import com.daiict.model.Internship;
import com.daiict.model.Internship_type;
import com.daiict.model.Job_profile;
import com.daiict.model.Location;
import com.daiict.model.Review;
import com.daiict.model.Student;
import com.daiict.repository.CompanyRepo;
import com.daiict.repository.FacultyRepo;
import com.daiict.repository.InternShipRepo;
import com.daiict.repository.InternShipTypeRepo;
import com.daiict.repository.JobProfileRepo;
import com.daiict.repository.LocationRepo;
import com.daiict.repository.StudentRepo;
import com.google.gson.Gson;

@Service
public class InternshipDao {

	@Autowired
	InternShipRepo internShipRepo;
	@Autowired
	CompanyRepo companyRepo;
	@Autowired
	FacultyRepo facultyRepo;
	@Autowired
	InternShipTypeRepo internShipTypeRepo;
	@Autowired
	JobProfileRepo jobProfileRepo;
	@Autowired
	LocationRepo locationRepo;
	@Autowired
	StudentRepo studentRepo;

	public String updateStatus(int internship_id) {

		if (internShipRepo.existsById(internship_id)) {
			int id = internship_id;
			internShipRepo.updateStatus(id);
			return "updated";
		}
		return "internship ID is not valid...";
	}

	public String addInternship(int company_or_faculty_id, boolean isCompany, int internship_type_id,
			int job_profile_id, int location_id, int student_id, String string) {
		Internship internship = null;

		try {
			internship = new Gson().fromJson(string, Internship.class);
		} catch (Exception e) {
			System.out.println("========");
			e.printStackTrace();
			return e.getMessage();
		}
		try {
			if ((isCompany && companyRepo.findById(company_or_faculty_id) != null)
					|| facultyRepo.findById(company_or_faculty_id) != null) {
				if (internShipTypeRepo.findById(internship_type_id) != null) {

					if (jobProfileRepo.findById(job_profile_id) != null) {

						if (locationRepo.findById(location_id) != null) {

							if (studentRepo.findById(student_id) != null) {

								Companies company = null;
								Faculty faculty = null;
								if (isCompany) {
									company = companyRepo.getOne(company_or_faculty_id);
								} else {
									faculty = facultyRepo.getOne(company_or_faculty_id);
								}

								Internship_type internship_type = internShipTypeRepo.getOne(internship_type_id);
								Job_profile job_profile = jobProfileRepo.getOne(job_profile_id);
								Location location = locationRepo.getOne(location_id);
								Student student = studentRepo.getOne(student_id);
								if (isCompany) {
									internship.setCompanies(company);
								} else {
									internship.setFaculty(faculty);
								}
								internship.setInternship_type(internship_type);
								internship.setJob_profile(job_profile);
								internship.setLocation(location);
								internship.setStudent(student);

								internShipRepo.save(internship);

							}
						}
					}
				}
			}
		}

		catch (Exception e) {
			return e.getMessage();
		}

		return "added....";

	}

	public List<Internship> getAllIntenship() {

		return internShipRepo.findAll();
	}

}
