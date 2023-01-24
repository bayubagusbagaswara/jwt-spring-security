package com.bayu.jwt.service;

import com.bayu.jwt.model.PasswordResetToken;
import com.bayu.jwt.model.User;
import com.bayu.jwt.payload.PasswordResetRequest;

import java.util.Optional;

public interface PasswordResetTokenService {

    public PasswordResetToken getValidToken(PasswordResetRequest request);

    public Optional<PasswordResetToken> createToken(User user);

    public PasswordResetToken claimToken(PasswordResetToken token);

    public void verifyExpiration(PasswordResetToken token);

    public void matchEmail(PasswordResetToken token, String requestEmail);

    public PasswordResetToken createTokenWithUser(User user);

}
