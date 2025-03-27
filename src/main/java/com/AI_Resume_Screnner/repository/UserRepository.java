package com.AI_Resume_Screnner.repository;

import com.AI_Resume_Screnner.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByMail(String mail);
}

