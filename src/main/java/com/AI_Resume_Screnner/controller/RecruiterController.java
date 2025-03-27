package com.AI_Resume_Screnner.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AI_Resume_Screnner.model.Recruiter;
import com.AI_Resume_Screnner.repository.RecruiterRepository;

@RestController
@RequestMapping("/recruiter")
public class RecruiterController {

	@Autowired
	private RecruiterRepository recruiterRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping("/all")
	public ResponseEntity<List<Recruiter>> getAllRecruiters(){
		return ResponseEntity.ok(recruiterRepository.findAll());
	}
	
	@PostMapping("/add")
	public ResponseEntity<String> addRecruiter(@RequestBody Recruiter recruiter){
		
		if(recruiterRepository.findByMail(recruiter.getMail()).isPresent()) {
			return ResponseEntity.badRequest().body("Recruiter already exists");
		}
		recruiter.setPassword(passwordEncoder.encode(recruiter.getPassword()));
		recruiterRepository.save(recruiter);
		return ResponseEntity.ok("Recruiter Added succesfully");
	}
	
}
