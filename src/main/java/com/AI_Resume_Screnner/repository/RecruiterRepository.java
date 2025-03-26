package com.AI_Resume_Screnner.repository;

import com.AI_Resume_Screnner.model.Recruiter;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface RecruiterRepository extends JpaRepository<Recruiter, Long> {
    Optional<Recruiter> findByMail(String mail);  // Method to find recruiter by email
}

