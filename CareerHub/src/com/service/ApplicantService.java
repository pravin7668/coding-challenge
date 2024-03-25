package com.service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.dao.ApplicantDao;
import com.dao.ApplicantDaoImpl;
import com.dto.ApplicantRetrieval;
import com.exception.InvalidEmailException;
import com.model.JobApplication;
import com.model.JobListing;

public class ApplicantService {
	ApplicantDao applicantDao=new ApplicantDaoImpl();
	public List<JobListing> getAllJobListing() throws SQLException {
		return applicantDao.getAllJobListing();
	}
	public void insertJobApplication(int applicantId, int jobId, LocalDate now, String coverLetter) throws SQLException{
		applicantDao.insertJobApplication(applicantId,jobId,  now, coverLetter);
	}
	public List<ApplicantRetrieval> getApplicants(int jobId) throws SQLException {
		return applicantDao.getApplicants(jobId);
	}
	public void createProfile(String firstName, String lastName, String email, String phone, String resume)  throws SQLException{
		applicantDao.createProfile(firstName,  lastName, email,phone, resume);
	}
	public void validateEmail(String email) throws InvalidEmailException {
		if(!email.contains("@gmail.com")) {
			throw new InvalidEmailException("Invalid Email ID");
		}
	}
	public List<JobListing> getJobBasedOnSalary(double startSalary, double endSalary) throws SQLException{
		return applicantDao.getJobBasedOnSalary(startSalary,endSalary);
	}
	public List<JobApplication> getJobApplication(int jobId) throws SQLException{
		return applicantDao.getJobApplication( jobId);
	}

}
