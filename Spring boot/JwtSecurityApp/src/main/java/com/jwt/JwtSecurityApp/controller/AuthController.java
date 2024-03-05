package com.jwt.JwtSecurityApp.controller;

import com.jwt.JwtSecurityApp.request.AuthenticationRequest;
import com.jwt.JwtSecurityApp.request.RegisterRequest;
import com.jwt.JwtSecurityApp.response.AuthResponse;
import com.jwt.JwtSecurityApp.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    @Autowired
    private AuthService authService;
    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request){
        return  ResponseEntity.ok(authService.register(request));
    }
    @PostMapping("/authenticate")
    public ResponseEntity<AuthResponse> authenticate(@RequestBody AuthenticationRequest request){
        return  ResponseEntity.ok(authService.authenticate(request));
    }
}
