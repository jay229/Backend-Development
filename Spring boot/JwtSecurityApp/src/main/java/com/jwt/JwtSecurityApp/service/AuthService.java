package com.jwt.JwtSecurityApp.service;

import com.jwt.JwtSecurityApp.config.JwtService;
import com.jwt.JwtSecurityApp.enums.Role;
import com.jwt.JwtSecurityApp.repositories.UserRepository;
import com.jwt.JwtSecurityApp.request.AuthenticationRequest;
import com.jwt.JwtSecurityApp.request.RegisterRequest;
import com.jwt.JwtSecurityApp.response.AuthResponse;
import com.jwt.JwtSecurityApp.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    private final JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;
    public AuthResponse register(RegisterRequest request) {
        var user= User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        userRepository.save(user);
        String jwtToken=jwtService.generateToken(user);
        return AuthResponse.builder()
                .token(jwtToken)
                .build();

    }

    public AuthResponse authenticate(AuthenticationRequest request) throws UsernameNotFoundException {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user=userRepository.findByEmail(request.getEmail()).orElseThrow();
        String jwtToken=jwtService.generateToken(user);
        return AuthResponse.builder()
                .token(jwtToken)
                .build();

    }
}
