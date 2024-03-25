package com.controller;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.exception.InvalidSalaryException;
import com.model.Company;
import com.model.JobListing;
import com.service.CompanyService;

public class CompanyController {
	public static void main(String[] args) {
		CompanyService companyService = new CompanyService();
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println();
			System.out.println();
			System.out.println("Press 1 to Post The Job");
			System.out.println("Press 2 to Get The Posted By Your Company");
			System.out.println("Press 3 to Get All Companies");
			System.out.println("Press 0 to exit");
			int input = sc.nextInt();
			if (input == 0) {
				System.out.println("Thank you ");
				break;

			}
			switch (input) {
			case 1:
				System.out.println("Enter Your Company Id");
				int companyId = sc.nextInt();
				System.out.println("Enter the Job Title");
				sc.nextLine();
				String jobTitle = sc.nextLine();
				System.out.println("Enter Job Description");
				String jobDescription = sc.nextLine();
				System.out.println("Enter Job Loaction");
				String jobLocation = sc.nextLine();
				System.out.println("Enter Job Salary");
				double salary = sc.nextDouble();
				 try {
					companyService.validateSalary(salary);
				} catch (InvalidSalaryException e) {
					System.out.println(e.getMessage());
				}
				System.out.println("Enter Job Type");
				sc.nextLine();
				String jobType = sc.nextLine();
				try {
					companyService.postJob(companyId, jobTitle, jobDescription, jobLocation, salary, jobType,
							LocalDate.now());
					System.out.println("Job Posted Succesfully");
				} catch (SQLException e) {
					e.printStackTrace();
				}

				break;
			case 2:
				System.out.println("Enter your Company Id");
				int companyId1=sc.nextInt();
				List<JobListing> list=new ArrayList<JobListing>();
				try {
					list=companyService.getJobPostedByCompany(companyId1);
					for(JobListing j:list) {
						System.out.println(j);
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				break;
			case 3:
				System.out.println("Showing All Companies");
				List<Company> list1=new ArrayList<Company>();
				try {
					list1=companyService.getAllCompany();
					for(Company c:list1) {
						System.out.println(c);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		sc.close();
	}
}
