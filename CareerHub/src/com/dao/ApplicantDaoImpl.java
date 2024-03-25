package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.dto.ApplicantRetrieval;
import com.model.JobApplication;
import com.model.JobListing;
import com.util.DBPropertyUtil;

public class ApplicantDaoImpl implements ApplicantDao{

	@Override
	public List<JobListing> getAllJobListing() throws SQLException {
		
		Connection conn = DBPropertyUtil.getDBConn();

		List<JobListing> list = new ArrayList<>();

		String sql = "select * from job_listing";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rst = pstmt.executeQuery();

		while (rst.next()) {
			int id = rst.getInt("id");
			int company_id=rst.getInt("company_id");
			String jobTitle=rst.getString("job_title");
			String jobLocation=rst.getString("job_location");
			double salary=rst.getDouble("salary");
			String jobType=rst.getString("job_type");
			JobListing c = new JobListing();
			c.setId(id);
			c.setCompanyId(company_id);
			c.setJobTitle(jobTitle);
			c.setJobLocation(jobLocation);
			c.setSalary(salary);
			c.setJobType(jobType);
			list.add(c);
		}

		DBPropertyUtil.dbClose();

		return list;
	}

	@Override
	public void insertJobApplication(int applicantId, int jobId, LocalDate now, String coverLetter)
			throws SQLException {
		Connection conn = DBPropertyUtil.getDBConn();
		String sql = "insert into job_application(job_listing_id,applicant_id,application_date,cover_letter) values (?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, jobId);
		pstmt.setInt(2, applicantId);
		pstmt.setString(3, now.toString());
		pstmt.setString(4, coverLetter);
		pstmt.executeUpdate();
		
		DBPropertyUtil.dbClose();

		
	}

	@Override
	public List<ApplicantRetrieval> getApplicants(int jobId) throws SQLException {
		Connection conn = DBPropertyUtil.getDBConn();
		List<ApplicantRetrieval> list=new ArrayList<ApplicantRetrieval>();
		String sql = "select a.first_name,a.email,a.phone,a.resume from applicant a join job_application j on a.id=j.applicant_id where j.job_listing_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, jobId);
		ResultSet rst = pstmt.executeQuery();

		while (rst.next()) {
		
			String firstName=rst.getString("first_name");
			String email=rst.getString("email");
			String phone=rst.getString("phone");
			String resume=rst.getString("resume");

			ApplicantRetrieval a = new ApplicantRetrieval(firstName,email,phone,resume);
		
			list.add(a);
		}
		DBPropertyUtil.dbClose();
		
		
		return list;
	}

	@Override
	public void createProfile(String firstName, String lastName, String email, String phone, String resume)
			throws SQLException {
		Connection conn = DBPropertyUtil.getDBConn();
		String sql = "insert into applicant(first_name,last_name,email,phone,resume) values (?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, firstName);
		pstmt.setString(2, lastName);
		pstmt.setString(3, email);
		pstmt.setString(4, phone);
		pstmt.setString(5, resume);
		pstmt.executeUpdate();
		
		DBPropertyUtil.dbClose();
	}

	@Override
	public List<JobListing> getJobBasedOnSalary(double startSalary, double endSalary) throws SQLException {
		
		
		Connection conn = DBPropertyUtil.getDBConn();

		List<JobListing> list = new ArrayList<>();

		String sql = "select * from job_listing where salary >=? and salary<=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setDouble(1, startSalary);
		pstmt.setDouble(2, endSalary);

		ResultSet rst = pstmt.executeQuery();

		while (rst.next()) {
			int id = rst.getInt("id");
			int company_id=rst.getInt("company_id");
			String jobTitle=rst.getString("job_title");
			String jobLocation=rst.getString("job_location");
			double salary=rst.getDouble("salary");
			String jobType=rst.getString("job_type");
			JobListing c = new JobListing();
			c.setId(id);
			c.setCompanyId(company_id);
			c.setJobTitle(jobTitle);
			c.setJobLocation(jobLocation);
			c.setSalary(salary);
			c.setJobType(jobType);
			list.add(c);
		}

		DBPropertyUtil.dbClose();

		return list;
	}

	@Override
	public List<JobApplication> getJobApplication(int jobId) throws SQLException {
		Connection conn = DBPropertyUtil.getDBConn();

		List<JobApplication> list = new ArrayList<>();

		String sql = "select * from job_application where job_listing_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, jobId);
		ResultSet rst = pstmt.executeQuery();

		while (rst.next()) {
			int id = rst.getInt("id");
			String coverLetter=rst.getString("cover_letter");
			int applicantId=rst.getInt("applicant_id");
	
			JobApplication j = new JobApplication();
			j.setId(id);
			j.setCoverLetter(coverLetter);
			j.setApplicantId(applicantId);
			list.add(j);
			
		}

		DBPropertyUtil.dbClose();

		return list;	
		}

}
