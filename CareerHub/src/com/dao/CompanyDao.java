package com.dao;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.model.Company;
import com.model.JobListing;

public interface CompanyDao {

	void postJob(int companyId, String jobTitle, String jobDescription, String jobLocation, double salary,
			String jobType, LocalDate now) throws SQLException;

	List<JobListing> getJobPostedByCompany(int companyId1) throws SQLException;

	List<Company> getAllCompany() throws SQLException;

}
