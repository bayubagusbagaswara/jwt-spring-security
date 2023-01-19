package com.bayu.jwt.repository;

import com.bayu.jwt.model.PasswordResetToken;
import com.bayu.jwt.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Long> {

    Optional<PasswordResetToken> findByToken(String token);

    @Query("SELECT t FROM PasswordResetToken t WHERE t.active = true AND t.user = :user")
    List<PasswordResetToken> findActiveTokensForUser(User user);
}
