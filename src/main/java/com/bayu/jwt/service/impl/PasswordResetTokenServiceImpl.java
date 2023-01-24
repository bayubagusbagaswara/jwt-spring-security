package com.bayu.jwt.service.impl;

import com.bayu.jwt.exception.ResourceNotFoundException;
import com.bayu.jwt.model.PasswordResetToken;
import com.bayu.jwt.model.User;
import com.bayu.jwt.payload.PasswordResetRequest;
import com.bayu.jwt.repository.PasswordResetTokenRepository;
import com.bayu.jwt.service.PasswordResetTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PasswordResetTokenServiceImpl implements PasswordResetTokenService {

    private final PasswordResetTokenRepository passwordResetTokenRepository;

    @Value("${app.token.password.reset.duration}")
    private Long expiration;

    @Autowired
    public PasswordResetTokenServiceImpl(PasswordResetTokenRepository passwordResetTokenRepository) {
        this.passwordResetTokenRepository = passwordResetTokenRepository;
    }

    @Override
    public PasswordResetToken getValidToken(PasswordResetRequest request) {
        String tokenID = request.getToken();
        PasswordResetToken token = passwordResetTokenRepository.findByToken(tokenID)
                .orElseThrow(() -> new ResourceNotFoundException("Password Reset Token", "Token Id", tokenID));

        matchEmail(token, request.getEmail());
        verifyExpiration(token);
        return token;
    }

    @Override
    public Optional<PasswordResetToken> createToken(User user) {
        return Optional.empty();
    }

    @Override
    public PasswordResetToken claimToken(PasswordResetToken token) {
        return null;
    }

    @Override
    public void verifyExpiration(PasswordResetToken token) {

    }

    @Override
    public void matchEmail(PasswordResetToken token, String requestEmail) {

    }
}
