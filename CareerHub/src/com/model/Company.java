package com.model;

public class Company {
	private int id;
	private String companyName;
	private String location;

	public Company(int id, String companyName, String location) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.location = location;
	}

	public Company(String companyName, String location) {
		super();
		this.companyName = companyName;
		this.location = location;
	}

	public Company() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", companyName=" + companyName + ", location=" + location + "]";
	}

}
