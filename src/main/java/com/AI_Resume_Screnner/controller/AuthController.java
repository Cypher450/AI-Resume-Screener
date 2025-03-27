package com.AI_Resume_Screnner.controller;

import com.AI_Resume_Screnner.DTO.AuthRequest;
import com.AI_Resume_Screnner.DTO.AuthResponse;
import com.AI_Resume_Screnner.model.User;
import com.AI_Resume_Screnner.repository.UserRepository;
import com.AI_Resume_Screnner.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());
        String token = jwtUtil.generateToken(userDetails.getUsername());

        return ResponseEntity.ok(new AuthResponse(token, "Login Successful"));
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody User user) {
        if (userRepository.findByMail(user.getMail()).isPresent()) {
            return ResponseEntity.badRequest().body(new AuthResponse(null, "User already exists"));
        }
        
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return ResponseEntity.ok(new AuthResponse(null, "Registration Successful"));
    }
}

