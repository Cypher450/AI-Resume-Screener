package com.AI_Resume_Screnner.model;

import lombok.*;

import java.util.List;

import jakarta.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "candidate")
@Entity

public class Candidate extends User{

	private String resumeFile;
	
	@ElementCollection
	private List<String> skills ;
	
	@Column(columnDefinition = "TEXT")
	private String experience;
	
	@Column(columnDefinition = "TEXT")
	private String education;
	
	@ElementCollection
	private List<String> jobPreference;
	
	@OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL)	
	private List<JobApplication> appliedJobs;

	public String getResumeFile() {
		return resumeFile;
	}

	public void setResumeFile(String resumeFile) {
		this.resumeFile = resumeFile;
	}

	public List<String> getSkills() {
		return skills;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public List<String> getJobPreference() {
		return jobPreference;
	}

	public void setJobPreference(List<String> jobPreference) {
		this.jobPreference = jobPreference;
	}

	public List<JobApplication> getAppliedJobs() {
		return appliedJobs;
	}

	public void setAppliedJobs(List<JobApplication> appliedJobs) {
		this.appliedJobs = appliedJobs;
	}
	
	
}
