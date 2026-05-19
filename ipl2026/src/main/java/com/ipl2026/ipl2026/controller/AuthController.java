package com.ipl2026.ipl2026.controller;

import com.ipl2026.ipl2026.dto.Request.LoginRequest;
import com.ipl2026.ipl2026.dto.Request.RegisterRequest;
import com.ipl2026.ipl2026.dto.Response.AuthResponse;
import com.ipl2026.ipl2026.entity.User;
import com.ipl2026.ipl2026.repository.UserRepositry;
import com.ipl2026.ipl2026.security.JwtUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final JwtUtil jwtUtil;
    private final UserRepositry userRepositry;
    private final PasswordEncoder passwordEncoder;

    public AuthController(JwtUtil jwtUtil, UserRepositry userRepositry, PasswordEncoder passwordEncoder) {
        this.jwtUtil = jwtUtil;
        this.userRepositry = userRepositry;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request){
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        userRepositry.save(user);
        return "User registered successfully";
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request){

        User user = userRepositry.findByEmail(request.getEmail()).orElseThrow(() -> new RuntimeException("User not found"));

        if(!passwordEncoder.matches(request.getPassword(), user.getPassword())){
            throw new RuntimeException("Wrong password");
        }

        String token = jwtUtil.generateToken(user.getEmail());
        return new AuthResponse(token);
    }
}
