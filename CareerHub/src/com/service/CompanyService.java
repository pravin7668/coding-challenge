package com.service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.dao.CompanyDao;
import com.dao.CompanyDaoImpl;
import com.exception.InvalidSalaryException;
import com.model.Company;
import com.model.JobListing;

public class CompanyService {
	CompanyDao companyDao=new CompanyDaoImpl();

	public void postJob(int companyId, String jobTitle, String jobDescription, String jobLocation, double salary,
			String jobType, LocalDate now) throws SQLException {
		companyDao.postJob(companyId,jobTitle,jobDescription,  jobLocation, salary, jobType,  now);
	}

	public List<JobListing> getJobPostedByCompany(int companyId1) throws SQLException{
		return companyDao.getJobPostedByCompany(companyId1);
	}

	public void validateSalary(double salary) throws InvalidSalaryException {
		if(salary<0) {
			throw new InvalidSalaryException("Salary is Negative");
		}
	}

	public List<Company> getAllCompany() throws SQLException{
		return  companyDao.getAllCompany();
	}

}
