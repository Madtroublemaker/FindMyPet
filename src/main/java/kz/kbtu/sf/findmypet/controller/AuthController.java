package kz.kbtu.sf.findmypet.controller;

import kz.kbtu.sf.findmypet.request.LoginRequest;
import kz.kbtu.sf.findmypet.request.RegisterRequest;
import kz.kbtu.sf.findmypet.response.AuthResponse;
import kz.kbtu.sf.findmypet.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")  // ✅ This will prefix all routes with /auth
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {
        authService.register(request);
        return "User registered successfully!";
    }
}