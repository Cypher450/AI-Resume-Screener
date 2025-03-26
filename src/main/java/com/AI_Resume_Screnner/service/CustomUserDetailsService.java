package com.AI_Resume_Screnner.service;

import com.AI_Resume_Screnner.model.Admin;
import com.AI_Resume_Screnner.model.Candidate;
import com.AI_Resume_Screnner.model.Recruiter;
import com.AI_Resume_Screnner.model.User;
import com.AI_Resume_Screnner.repository.AdminRepository;
import com.AI_Resume_Screnner.repository.CandidateRepository;
import com.AI_Resume_Screnner.repository.RecruiterRepository;
import com.AI_Resume_Screnner.security.CustomUserDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private RecruiterRepository recruiterRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<? extends User> user = findUserByEmail(email);

        return user.map(CustomUserDetails::new)
                   .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
    }

    private Optional<? extends User> findUserByEmail(String email) {
        Optional<Admin> admin = adminRepository.findByMail(email);
        if (admin.isPresent()) return admin;

        Optional<Candidate> candidate = candidateRepository.findByMail(email);
        if (candidate.isPresent()) return candidate;

        Optional<Recruiter> recruiter = recruiterRepository.findByMail(email);
        return recruiter;
    }
}
