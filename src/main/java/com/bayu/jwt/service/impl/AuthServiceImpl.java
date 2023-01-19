package com.bayu.jwt.service.impl;

import com.bayu.jwt.model.CustomUserDetails;
import com.bayu.jwt.model.PasswordResetToken;
import com.bayu.jwt.model.User;
import com.bayu.jwt.model.token.EmailVerificationToken;
import com.bayu.jwt.model.token.RefreshToken;
import com.bayu.jwt.payload.*;
import com.bayu.jwt.service.AuthService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {

    @Override
    public Optional<User> registerUser(RegistrationRequest registrationRequest) {
        return Optional.empty();
    }

    @Override
    public Boolean emailAlreadyExists(String email) {
        return null;
    }

    @Override
    public Boolean usernameAlreadyExists(String username) {
        return null;
    }

    @Override
    public Optional<Authentication> authenticateUser(LoginRequest loginRequest) {
        return Optional.empty();
    }

    @Override
    public Optional<User> confirmEmailRegistration(String emailToken) {
        return Optional.empty();
    }

    @Override
    public Optional<EmailVerificationToken> recreateRegistrationToken(String existingToken) {
        return Optional.empty();
    }

    @Override
    public Boolean currentPasswordMatches(User currentUser, String password) {
        return null;
    }

    @Override
    public Optional<User> updatePassword(CustomUserDetails customUserDetails, UpdatePasswordRequest updatePasswordRequest) {
        return Optional.empty();
    }

    @Override
    public String generateToken(CustomUserDetails customUserDetails) {
        return null;
    }

    @Override
    public String generateTokenFromUserId(Long userId) {
        return null;
    }

    @Override
    public Optional<RefreshToken> createAndPersistRefreshTokenForDevice(Authentication authentication, LoginRequest loginRequest) {
        return Optional.empty();
    }

    @Override
    public Optional<String> refreshJwtToken(TokenRefreshRequest tokenRefreshRequest) {
        return Optional.empty();
    }

    @Override
    public Optional<PasswordResetToken> generatePasswordResetToken(PasswordResetLinkRequest passwordResetLinkRequest) {
        return Optional.empty();
    }

    @Override
    public Optional<User> resetPassword(PasswordResetRequest passwordResetRequest) {
        return Optional.empty();
    }
}
