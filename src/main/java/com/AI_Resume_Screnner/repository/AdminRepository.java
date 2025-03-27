package com.AI_Resume_Screnner.repository;

import com.AI_Resume_Screnner.model.Admin;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Optional<Admin> findByMail(String mail);
}
