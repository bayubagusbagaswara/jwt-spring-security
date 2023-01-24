package com.bayu.jwt.service.impl;

import com.bayu.jwt.model.TokenStatus;
import com.bayu.jwt.model.User;
import com.bayu.jwt.model.token.EmailVerificationToken;
import com.bayu.jwt.repository.EmailVerificationTokenRepository;
import com.bayu.jwt.service.EmailVerificationTokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
public class EmailVerificationTokenServiceImpl implements EmailVerificationTokenService {

    private final static Logger logger = LoggerFactory.getLogger(EmailVerificationTokenServiceImpl.class);

    private final EmailVerificationTokenRepository emailVerificationTokenRepository;

    @Value("{app.token.email.verification.duration}")
    private Long emailVerificationTokenExpiryDuration;

    @Autowired
    public EmailVerificationTokenServiceImpl(EmailVerificationTokenRepository emailVerificationTokenRepository) {
        this.emailVerificationTokenRepository = emailVerificationTokenRepository;
    }

    @Override
    public void createVerificationToken(User user, String token) {
        EmailVerificationToken emailVerificationToken = new EmailVerificationToken();
        emailVerificationToken.setToken(token);
        emailVerificationToken.setTokenStatus(TokenStatus.STATUS_PENDING);
        emailVerificationToken.setUser(user);
        emailVerificationToken.setExpiryDate(Instant.now().plusMillis(emailVerificationTokenExpiryDuration));

        logger.info("Generated Email verification token [" + emailVerificationToken + "]");

        emailVerificationTokenRepository.save(emailVerificationToken);
    }

    @Override
    public EmailVerificationToken updateExistingTokenWithNameAndExpiry(EmailVerificationToken existingToken) {
        existingToken.setTokenStatus(TokenStatus.STATUS_PENDING);
        existingToken.setExpiryDate(Instant.now().plusMillis(emailVerificationTokenExpiryDuration));
        logger.info("Updated Email Verification Token [" + existingToken + "]");
        return save(existingToken);
    }

    @Override
    public Optional<EmailVerificationToken> findByToken(String token) {
        return emailVerificationTokenRepository.findByToken(token);
    }

    @Override
    public EmailVerificationToken save(EmailVerificationToken emailVerificationToken) {
        return emailVerificationTokenRepository.save(emailVerificationToken);
    }

    @Override
    public String generateNewToken() {
        return null;
    }

    @Override
    public void verifyExpiration(EmailVerificationToken token) {

    }
}
