package com.dao;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.dto.ApplicantRetrieval;
import com.model.JobApplication;
import com.model.JobListing;

public interface ApplicantDao {

	List<JobListing> getAllJobListing() throws SQLException;

	void insertJobApplication(int applicantId, int jobId, LocalDate now, String coverLetter) throws SQLException;

	List<ApplicantRetrieval> getApplicants(int jobId) throws SQLException;

	void createProfile(String firstName, String lastName, String email, String phone, String resume) throws SQLException;

	List<JobListing> getJobBasedOnSalary(double startSalary, double endSalary) throws SQLException;

	List<JobApplication> getJobApplication(int jobId) throws SQLException;

}
