package com.bayu.jwt.service;

import com.bayu.jwt.model.token.RefreshToken;

import java.util.Optional;

public interface RefreshTokenService {

    public Optional<RefreshToken> findByToken(String token);

    public RefreshToken save(RefreshToken refreshToken);

    public RefreshToken createRefreshToken();

    public void verifyExpiration(RefreshToken token);

    public void deleteById(Long id);

    public void increaseCount(RefreshToken refreshToken);
}
