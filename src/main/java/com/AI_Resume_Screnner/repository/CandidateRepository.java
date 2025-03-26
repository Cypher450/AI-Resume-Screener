package com.AI_Resume_Screnner.repository;

import com.AI_Resume_Screnner.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {
    Optional<Candidate> findByMail(String mail);
}
