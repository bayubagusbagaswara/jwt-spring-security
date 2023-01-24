package com.bayu.jwt.service.impl;

import com.bayu.jwt.model.token.RefreshToken;
import com.bayu.jwt.service.RefreshTokenService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RefreshTokenServiceImpl implements RefreshTokenService {

    @Override
    public Optional<RefreshToken> findByToken(String token) {
        return Optional.empty();
    }

    @Override
    public RefreshToken save(RefreshToken refreshToken) {
        return null;
    }

    @Override
    public RefreshToken createRefreshToken() {
        return null;
    }

    @Override
    public void verifyExpiration(RefreshToken token) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void increaseCount(RefreshToken refreshToken) {

    }
}
