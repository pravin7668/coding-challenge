package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.model.Company;
import com.model.JobListing;
import com.util.DBPropertyUtil;

public class CompanyDaoImpl implements CompanyDao{

	@Override
	public void postJob(int companyId, String jobTitle, String jobDescription, String jobLocation, double salary,
			String jobType, LocalDate now) throws SQLException {
		Connection conn = DBPropertyUtil.getDBConn();
		String sql = "insert into job_listing(company_id,job_title,job_description,job_location,salary,job_type,posted_date) values (?,?,?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, companyId);
		pstmt.setString(2, jobTitle);
		pstmt.setString(3, jobDescription);
		pstmt.setString(4, jobLocation);
		pstmt.setDouble(5, salary);
		pstmt.setString(6, jobType);
		pstmt.setString(7, now.toString());

		pstmt.executeUpdate();
		
		DBPropertyUtil.dbClose();
	}

	@Override
	public List<JobListing> getJobPostedByCompany(int companyId1) throws SQLException {
		
		Connection conn = DBPropertyUtil.getDBConn();

		List<JobListing> list = new ArrayList<>();

		String sql = "select * from job_listing where company_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, companyId1);
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
	public List<Company> getAllCompany() throws SQLException {
		
		Connection conn = DBPropertyUtil.getDBConn();
		List<Company> list=new ArrayList<Company>();
		String sql = "select * from company";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rst = pstmt.executeQuery();

		while (rst.next()) {
			int id = rst.getInt("id");
			String companyName=rst.getString("company_name");
			String location=rst.getString("location");
			Company c=new Company(id,companyName,location);
			list.add(c);
		
		}
		
		DBPropertyUtil.dbClose();
		return list;
	}

}
