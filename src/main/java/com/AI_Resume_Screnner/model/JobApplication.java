package com.AI_Resume_Screnner.model;

import lombok.*;
import jakarta.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "job_applications")

public class JobApplication {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "job_id")
	private Job job;
	
	@ManyToOne
	@JoinColumn()
	private Candidate candidate;
	
	private double resumeScore;
	
	private ApplicationStatus status;
	
	private enum ApplicationStatus{
		REJECT, PENDING, SELECTED
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	public double getResumeScore() {
		return resumeScore;
	}

	public void setResumeScore(double resumeScore) {
		this.resumeScore = resumeScore;
	}

	public ApplicationStatus getStatus() {
		return status;
	}

	public void setStatus(ApplicationStatus status) {
		this.status = status;
	}
	
	

}
