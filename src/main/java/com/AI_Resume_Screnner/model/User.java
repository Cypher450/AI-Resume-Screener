package com.AI_Resume_Screnner.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false, unique = true)
	private String mail;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	private Role role;
	
	LocalDateTime createdAt;
	LocalDateTime updatedAt;
	
	@PrePersist
	public void onCreate() {
		createdAt = LocalDateTime.now();
	}
	
	@PreUpdate
	public void onUpdate() {
		updatedAt = LocalDateTime.now();
	}
	
	public enum Role {
		ADMIN, CANDIDATE, RECRUITER
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
	
}
