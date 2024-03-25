package com.model;

import java.time.LocalDate;

public class JobApplication {
	private int id;
	private int jobListingId;
	private int applicantId;
	private LocalDate applicationDate;
	private String coverLetter;

	public JobApplication() {
		super();
	}

	public JobApplication(int jobListingId, int applicantId, LocalDate applicationDate, String coverLetter) {
		super();
		this.jobListingId = jobListingId;
		this.applicantId = applicantId;
		this.applicationDate = applicationDate;
		this.coverLetter = coverLetter;
	}

	public JobApplication(int id, int jobListingId, int applicantId, LocalDate applicationDate, String coverLetter) {
		super();
		this.id = id;
		this.jobListingId = jobListingId;
		this.applicantId = applicantId;
		this.applicationDate = applicationDate;
		this.coverLetter = coverLetter;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getJobListingId() {
		return jobListingId;
	}

	public void setJobListingId(int jobListingId) {
		this.jobListingId = jobListingId;
	}

	public int getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(int applicantId) {
		this.applicantId = applicantId;
	}

	public LocalDate getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(LocalDate applicationDate) {
		this.applicationDate = applicationDate;
	}

	public String getCoverLetter() {
		return coverLetter;
	}

	public void setCoverLetter(String coverLetter) {
		this.coverLetter = coverLetter;
	}

	@Override
	public String toString() {
		return "JobApplication [id=" + id + ", jobListingId=" + jobListingId + ", applicantId=" + applicantId
				+ ", applicationDate=" + applicationDate + ", coverLetter=" + coverLetter + "]";
	}

}
