package com.AI_Resume_Screnner.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AI_Resume_Screnner.model.Candidate;
import com.AI_Resume_Screnner.repository.CandidateRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/candidate")
public class CandidateController {
	
	@Autowired
	private CandidateRepository candidateRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping("/all")
	public ResponseEntity<List<Candidate>> getAllCandidates() {
		return ResponseEntity.ok(candidateRepository.findAll());
	}
	
	@PostMapping("/add")
	public ResponseEntity<String> addCandidate(@RequestBody Candidate candidate){
		
		if(candidateRepository.findByMail(candidate.getMail()).isPresent()) {
			return ResponseEntity.badRequest().body("Candidate Already present");
		}
		
		candidate.setPassword(passwordEncoder.encode(candidate.getPassword()));
		candidateRepository.save(candidate);
		return ResponseEntity.ok("Candidate Added Succesfully");
	}
}
