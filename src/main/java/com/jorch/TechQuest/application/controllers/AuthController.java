package com.jorch.TechQuest.application.controllers;

import com.jorch.TechQuest.application.dto.request.AuthRequest;
import com.jorch.TechQuest.application.dto.request.RegisterRequest;
import com.jorch.TechQuest.application.dto.response.AuthResponse;
import com.jorch.TechQuest.application.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest registerRequest) {
        userService.register(registerRequest);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> createToken(@RequestBody AuthRequest authRequest) {
        AuthResponse authResponse = userService.authenticate(authRequest);
        return ResponseEntity.ok(authResponse);
    }
}
