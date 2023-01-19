package com.bayu.jwt.service;

import com.bayu.jwt.model.CustomUserDetails;
import com.bayu.jwt.model.PasswordResetToken;
import com.bayu.jwt.model.User;
import com.bayu.jwt.model.token.EmailVerificationToken;
import com.bayu.jwt.model.token.RefreshToken;
import com.bayu.jwt.payload.*;
import org.springframework.security.core.Authentication;

import java.util.Optional;

public interface AuthService {

    public Optional<User> registerUser(RegistrationRequest registrationRequest);

    public Boolean emailAlreadyExists(String email);

    public Boolean usernameAlreadyExists(String username);

    public Optional<Authentication> authenticateUser(LoginRequest loginRequest);

    public Optional<User> confirmEmailRegistration(String emailToken);

    public Optional<EmailVerificationToken> recreateRegistrationToken(String existingToken);

    public Boolean currentPasswordMatches(User currentUser, String password);

    public Optional<User> updatePassword(CustomUserDetails customUserDetails, UpdatePasswordRequest updatePasswordRequest);

    public String generateToken(CustomUserDetails customUserDetails);

    public String generateTokenFromUserId(Long userId);

    public Optional<RefreshToken> createAndPersistRefreshTokenForDevice(Authentication authentication, LoginRequest loginRequest);

    public Optional<String> refreshJwtToken(TokenRefreshRequest tokenRefreshRequest);

    public Optional<PasswordResetToken> generatePasswordResetToken(PasswordResetLinkRequest passwordResetLinkRequest);

    public Optional<User> resetPassword(PasswordResetRequest passwordResetRequest);

}
