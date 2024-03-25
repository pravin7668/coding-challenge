package com.dto;

public class ApplicantRetrieval {
	private String firstName;
	private String email;
	private String phone;
	private String resume;

	public ApplicantRetrieval(String firstName, String email, String phone, String resume) {
		super();
		this.firstName = firstName;
		this.email = email;
		this.phone = phone;
		this.resume = resume;
	}

	@Override
	public String toString() {
		return "ApplicantRetrieval [firstName=" + firstName + ", email=" + email + ", phone=" + phone + ", resume="
				+ resume + "]";
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

}
