package com.codewithme.firstApp.Service;

import com.codewithme.firstApp.DTO.JwtResponse;
import com.codewithme.firstApp.DTO.LoginRequest;
import com.codewithme.firstApp.DTO.SignupRequest;
import com.codewithme.firstApp.Model.User;
import com.codewithme.firstApp.Repository.UserRepository;
import com.codewithme.firstApp.Security.JwtUtils;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;

    public AuthService(UserRepository userRepository, @Lazy PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, JwtUtils jwtUtils) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
    }

    public String registerUser(SignupRequest request) {
        if (userRepository.existsByUserName(request.getUsername()) || userRepository.existsByUserEmail(request.getEmail())) {
            throw new RuntimeException("User already exists");
        }
        User user = new User(null, request.getUsername(), request.getEmail(), passwordEncoder.encode(request.getPassword()), request.getRole());
        userRepository.save(user);
        return "User registered successfully!";
    }

    public JwtResponse authenticateUser(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        User user = userRepository.findByUserName(request.getUsername()).orElseThrow();
        // Convert User entity to UserDetails
        UserDetails userDetails = org.springframework.security.core.userdetails.User
                .withUsername(user.getUserName())
                .password(user.getUserPassword())
                .roles(user.getUserRole())
                .build();
        String token = jwtUtils.generateToken(userDetails);
        return new JwtResponse(token, user.getUserName(), user.getUserRole());
    }
}
