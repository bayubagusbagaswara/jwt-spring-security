package com.bayu.jwt.controller;

import com.bayu.jwt.payload.ApiResponse;
import com.bayu.jwt.security.JwtTokenProvider;
import com.bayu.jwt.service.AuthService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;
    private final JwtTokenProvider tokenProvider;
    private final ApplicationEventPublisher applicationEventPublisher;

    public AuthController(AuthService authService, JwtTokenProvider tokenProvider, ApplicationEventPublisher applicationEventPublisher) {
        this.authService = authService;
        this.tokenProvider = tokenProvider;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @GetMapping("/checkEmailInUse")
    public ResponseEntity<?> checkEmailInUse(@Param(value = "Email id to check against") @RequestParam("email") String email) {
        Boolean emailExists = authService.emailAlreadyExists(email);
        return ResponseEntity.ok(new ApiResponse(true, emailExists.toString()));
    }

    @GetMapping("/checkUsernameInUse")
    public ResponseEntity<?> checkUsernameInUse(@Param(value = "Username to check against") @RequestParam("username") String username ) {
        return null;
    }

}
