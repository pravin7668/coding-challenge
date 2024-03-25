package com.model;

import java.time.LocalDate;

public class JobListing {
	private int id;
	private int companyId;
	private String jobTitle;
	private String jobDescription;
	private String jobLocation;
	private double salary;
	private String jobType;
	private LocalDate postedDate;

	public JobListing() {
		super();
	}

	public JobListing(int companyId, String jobTitle, String jobDescription, String jobLocation, double salary,
			String jobType, LocalDate postedDate) {
		super();
		this.companyId = companyId;
		this.jobTitle = jobTitle;
		this.jobDescription = jobDescription;
		this.jobLocation = jobLocation;
		this.salary = salary;
		this.jobType = jobType;
		this.postedDate = postedDate;
	}

	public JobListing(int id, int companyId, String jobTitle, String jobDescription, String jobLocation, double salary,
			String jobType, LocalDate postedDate) {
		super();
		this.id = id;
		this.companyId = companyId;
		this.jobTitle = jobTitle;
		this.jobDescription = jobDescription;
		this.jobLocation = jobLocation;
		this.salary = salary;
		this.jobType = jobType;
		this.postedDate = postedDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public String getJobLocation() {
		return jobLocation;
	}

	public void setJobLocation(String jobLocation) {
		this.jobLocation = jobLocation;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	public LocalDate getPostedDate() {
		return postedDate;
	}

	public void setPostedDate(LocalDate postedDate) {
		this.postedDate = postedDate;
	}

	@Override
	public String toString() {
		return "JobListing [id=" + id + ", companyId=" + companyId + ", jobTitle=" + jobTitle + ", jobDescription="
				+ jobDescription + ", jobLocation=" + jobLocation + ", salary=" + salary + ", jobType=" + jobType
				+ ", postedDate=" + postedDate + "]";
	}

}
