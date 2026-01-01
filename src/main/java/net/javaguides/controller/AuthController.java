package net.javaguides.controller;

import net.javaguides.dto.LoginRequest;
import net.javaguides.dto.RegisterRequest; 
import net.javaguides.dto.EmployeeResponse; 
import net.javaguides.service.AuthService;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public EmployeeResponse register(@Valid @RequestBody RegisterRequest request) {
        return authService.register(request);
    }
    @PostMapping("/login")
    public EmployeeResponse login(@Valid @RequestBody LoginRequest request) {
        return authService.login(request);
    }
}

