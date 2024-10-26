package com.springboot.ecommerce.security;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        return authService.authenticate(loginRequest.getUsername(), loginRequest.getPassword());
    }
}
