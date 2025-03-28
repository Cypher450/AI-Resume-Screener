package com.AI_Resume_Screnner.controller;

import com.AI_Resume_Screnner.DTO.AuthRequest;
import com.AI_Resume_Screnner.DTO.AuthResponse;
import com.AI_Resume_Screnner.model.User;
import com.AI_Resume_Screnner.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // ✅ Register a user (hash password manually)
    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody User user) {
        if (userRepository.findByMail(user.getMail()).isPresent()) {
            return ResponseEntity.badRequest().body(new AuthResponse(null, "User already exists"));
        }
        
        // Manually hash password
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

        return ResponseEntity.ok(new AuthResponse(null, "Registration Successful"));
    }

    // ✅ Login a user (verify manually)
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        Optional<User> userOptional = userRepository.findByMail(request.getEmail());

        if (userOptional.isEmpty()) {
            return ResponseEntity.status(401).body(new AuthResponse(null, "User not found"));
        }

        User user = userOptional.get();
        
        // 🔍 Compare raw password with hashed password
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            return ResponseEntity.status(401).body(new AuthResponse(null, "Invalid credentials"));
        }

        return ResponseEntity.ok(new AuthResponse(null, "Login Successful"));
    }
}
