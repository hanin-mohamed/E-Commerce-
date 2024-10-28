package com.springboot.ecommerce.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService {

    private final AuthenticationManager authManager;
    private final JWTUtil jwtUtil;
    private final UserDetailsService userDetailsService;


    // login method to authenticate and return JWT token
    public String authenticate(String name, String password) {
        try {
            log.info("Authenticating user: " + name);
            authManager.authenticate(new UsernamePasswordAuthenticationToken(name, password));

            log.info("Loading user details for: " + name);
            UserDetails userDetails = userDetailsService.loadUserByUsername(name);

            log.info("Generating JWT for user: " + userDetails.getUsername());
            return jwtUtil.generateToken(userDetails.getUsername());

        } catch (Exception e) {
            log.error("Authentication failed for user: " + name, e);
            throw new RuntimeException("Authentication failed");
        }
    }
}
