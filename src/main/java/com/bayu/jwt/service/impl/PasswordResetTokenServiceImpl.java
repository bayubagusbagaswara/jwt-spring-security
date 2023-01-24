package com.bayu.jwt.service.impl;

import com.bayu.jwt.model.PasswordResetToken;
import com.bayu.jwt.model.User;
import com.bayu.jwt.payload.PasswordResetRequest;
import com.bayu.jwt.service.PasswordResetTokenService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PasswordResetTokenServiceImpl implements PasswordResetTokenService {

    @Override
    public PasswordResetToken getValidToken(PasswordResetRequest request) {
        return null;
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
