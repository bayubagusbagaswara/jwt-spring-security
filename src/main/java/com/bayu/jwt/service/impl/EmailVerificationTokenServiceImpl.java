package com.bayu.jwt.service.impl;

import com.bayu.jwt.model.token.EmailVerificationToken;
import com.bayu.jwt.service.EmailVerificationTokenService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmailVerificationTokenServiceImpl implements EmailVerificationTokenService {



    @Override
    public EmailVerificationToken updateExistingTokenWithNameAndExpiry(EmailVerificationToken existingToken) {
        return null;
    }

    @Override
    public Optional<EmailVerificationToken> findByToken(String token) {
        return Optional.empty();
    }

    @Override
    public EmailVerificationToken save(EmailVerificationToken emailVerificationToken) {
        return null;
    }

    @Override
    public String generateNewToken() {
        return null;
    }

    @Override
    public void verifyExpiration(EmailVerificationToken token) {

    }
}
