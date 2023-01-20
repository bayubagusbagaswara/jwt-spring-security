package com.bayu.jwt.service;

import com.bayu.jwt.model.token.EmailVerificationToken;

import java.util.Optional;

public interface EmailVerificationTokenService {

    public EmailVerificationToken updateExistingTokenWithNameAndExpiry(EmailVerificationToken existingToken);

    public Optional<EmailVerificationToken> findByToken(String token);

    public EmailVerificationToken save(EmailVerificationToken emailVerificationToken);

    public String generateNewToken();

    public void verifyExpiration(EmailVerificationToken token);
}
