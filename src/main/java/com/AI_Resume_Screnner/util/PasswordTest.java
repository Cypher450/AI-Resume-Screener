package com.AI_Resume_Screnner.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordTest {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        String rawPassword = "1234567890";  // The password you used during registration
        String hashedPassword = "$2a$10$Dpi0F1GFb.1pT6UTZbiJr.Iierw0Re8OPiceDTE85frGODHJ7gUl2"; // Paste the password from DB

        boolean matches = encoder.matches(rawPassword, hashedPassword);
        System.out.println("Password Match: " + matches);
    }
}
