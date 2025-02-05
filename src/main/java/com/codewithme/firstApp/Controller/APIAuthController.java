package com.codewithme.firstApp.Controller;

import com.codewithme.firstApp.DTO.JwtResponse;
import com.codewithme.firstApp.DTO.LoginRequest;
import com.codewithme.firstApp.DTO.SignupRequest;
import com.codewithme.firstApp.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class APIAuthController {

    private final AuthService authService;

    public APIAuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup")
    public String register(@RequestBody SignupRequest request) {
        return authService.registerUser(request);
    }

    @PostMapping("/login")
    public JwtResponse login(@RequestBody LoginRequest request) {
        return authService.authenticateUser(request);
    }
}
