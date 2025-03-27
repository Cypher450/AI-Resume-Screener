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

import com.AI_Resume_Screnner.model.Admin;
import com.AI_Resume_Screnner.repository.AdminRepository;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping("/all")
	public ResponseEntity<List<Admin>> getAllAdmins(){
		return ResponseEntity.ok(adminRepository.findAll());
	}
	
	@PostMapping("/add")
	public ResponseEntity<String> addAdmin(@RequestBody Admin admin){
		if (adminRepository.findByMail(admin.getMail()).isPresent()) {
            return ResponseEntity.badRequest().body("Admin already exists");
        }
		
		admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        adminRepository.save(admin);
        return ResponseEntity.ok("Admin added successfully");
	}
	
}
