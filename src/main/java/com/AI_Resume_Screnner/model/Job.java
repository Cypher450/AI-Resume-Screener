package com.AI_Resume_Screnner.model;

import lombok.*;

import java.util.List;

import jakarta.persistence.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "jobs")
public class Job {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String title;
	private String description;
	private String company;
	private String location;
	
	@ElementCollection
	private List<String> skillsRequired;
	
	@ManyToOne
	@JoinColumn(name = "recruiterId")
	private Recruiter postedBy;
	
	@OneToMany(mappedBy = "job", cascade = CascadeType.ALL)
	private List<JobApplication> application;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<String> getSkillsRequired() {
		return skillsRequired;
	}

	public void setSkillsRequired(List<String> skillsRequired) {
		this.skillsRequired = skillsRequired;
	}

	public Recruiter getPostedBy() {
		return postedBy;
	}

	public void setPostedBy(Recruiter postedBy) {
		this.postedBy = postedBy;
	}

	public List<JobApplication> getApplication() {
		return application;
	}

	public void setApplication(List<JobApplication> application) {
		this.application = application;
	}
	
	

}
