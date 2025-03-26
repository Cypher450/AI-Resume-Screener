package com.AI_Resume_Screnner.model;

import lombok.*;

import java.util.List;

import jakarta.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "recruiters")

public class Recruiter extends User {

	private String companyName;
	
	@ElementCollection
	private List<Job> jobPosting;

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public List<Job> getJobPosting() {
		return jobPosting;
	}

	public void setJobPosting(List<Job> jobPosting) {
		this.jobPosting = jobPosting;
	}
	
	
}
