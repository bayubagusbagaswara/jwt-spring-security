package com.bayu.jwt.repository;

import com.bayu.jwt.model.UserDevice;
import com.bayu.jwt.model.token.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.constraints.NotNull;
import java.util.Optional;

public interface UserDeviceRepository extends JpaRepository<UserDevice, Long> {

    @Override
    Optional<UserDevice> findById(Long id);

    Optional<UserDevice> findByRefreshToken(RefreshToken refreshToken);

    Optional<UserDevice> findByUserIdAndDeviceId(Long userId, String userDeviceId);

}
