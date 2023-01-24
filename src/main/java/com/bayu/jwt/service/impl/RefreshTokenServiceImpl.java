package com.bayu.jwt.service.impl;

import com.bayu.jwt.model.token.RefreshToken;
import com.bayu.jwt.repository.RefreshTokenRepository;
import com.bayu.jwt.service.RefreshTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RefreshTokenServiceImpl implements RefreshTokenService {

    private final RefreshTokenRepository refreshTokenRepository;

    @Value("${app.token.refresh.duration}")
    private Long refreshTokenDurationMs;

    @Override
    public Optional<RefreshToken> findByToken(String token) {
        return refreshTokenRepository.findByToken(token);
    }

    @Override
    public RefreshToken save(RefreshToken refreshToken) {
        return refreshTokenRepository.save(refreshToken);
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
