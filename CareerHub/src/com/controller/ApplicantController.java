package com.controller;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.dto.ApplicantRetrieval;
import com.exception.InvalidEmailException;
import com.model.JobApplication;
import com.model.JobListing;
import com.service.ApplicantService;

public class ApplicantController {
	public static void main(String[] args) {
		ApplicantService applicantService=new ApplicantService();
		Scanner sc =new Scanner(System.in);
		while(true) {
			System.out.println("Press 1 to Create Your Profile");
			System.out.println("Press 2 to Apply for a job");
			System.out.println("Press 3 to Get Applicants Who Applied For Particular Job");
			System.out.println("Press 4 to Get a Specified Salary Range Of Jobs");
			System.out.println("Press 5 to List Job Application For Specific Job");
			System.out.println("Press 0 to exit");
			int input=sc.nextInt();
			if(input==0) {
				System.out.println("Thank you ");
				break;
				
			}
			switch(input) {
			case 1:
				System.out.println("Enter your First Name");
				sc.nextLine();
				String firstName=sc.nextLine();
				System.out.println("Enter your Last Name");
				String lastName=sc.nextLine();
				System.out.println("Enter your Email");
				String email=sc.nextLine();
				try {
					applicantService.validateEmail(email);
				} catch (InvalidEmailException e) {
					System.out.println(e.getMessage());
				}
				System.out.println("Enter your Phone");
				String phone=sc.nextLine();
				System.out.println("Enter your Resume");
				String resume=sc.nextLine();
				try {
					applicantService.createProfile(firstName,lastName,email,phone,resume);
					System.out.println("User Profile Created");

				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				break;
			
			
			case 2:
				System.out.println("Enter your ID");
				int applicantId=sc.nextInt();
				
				List<JobListing> list=new ArrayList<JobListing>();
				try {
					list=applicantService.getAllJobListing();
					for (JobListing j:list) {
						System.out.println(j);
					}
					
					System.out.println("Enter Job Id to Apply");
					int jobId=sc.nextInt();
					System.out.println("Enter the Cover Letter");
					sc.nextLine();
					String coverLetter=sc.nextLine();
					applicantService.insertJobApplication(applicantId,jobId,LocalDate.now(),coverLetter);
					System.out.println("Application Submitted SuccessFully");
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 3:
				System.out.println("Applicants Who Are All Applied To This Job");
				
				try {
					list=applicantService.getAllJobListing();
					for (JobListing j:list) {
						System.out.println(j);
					}
					System.out.println("Enter Job Id To get The Applicants");
					int jobId=sc.nextInt();
					List<ApplicantRetrieval> list1=new ArrayList<ApplicantRetrieval>();
					list1=applicantService.getApplicants(jobId);
					for (ApplicantRetrieval a:list1) {
						System.out.println(a);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			
			case 4:
				System.out.println("Enter Your Start Salary");
				double startSalary=sc.nextDouble();
				System.out.println("Enter End Salary");
				double endSalary=sc.nextDouble();
				List<JobListing> list1=new ArrayList<JobListing>();
				try {
					list1=applicantService.getJobBasedOnSalary(startSalary,endSalary);
					for(JobListing j:list1) {
						System.out.println(j);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				
				break;
			case 5:
				try {
					list=applicantService.getAllJobListing();
					for (JobListing j:list) {
						System.out.println(j);
					}
					System.out.println("Enter Job Id To get The Job Applications");
					int jobId=sc.nextInt();
					List<JobApplication> list2=new ArrayList<JobApplication>();
					System.out.println("Showing Job Application");
					list2=applicantService.getJobApplication(jobId);
					for (JobApplication j:list2) {
						System.out.println(j);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				
				
				
			
			}
				
		}
		sc.close();
	}
}
