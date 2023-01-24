package com.bayu.jwt.service.impl;

import com.bayu.jwt.model.UserDevice;
import com.bayu.jwt.model.token.RefreshToken;
import com.bayu.jwt.payload.DeviceInfo;
import com.bayu.jwt.service.UserDeviceService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDeviceServiceImpl implements UserDeviceService {

    @Override
    public Optional<UserDevice> findDeviceByUserId(Long userId, String deviceId) {
        return Optional.empty();
    }

    @Override
    public Optional<UserDevice> findByRefreshToken(RefreshToken refreshToken) {
        return Optional.empty();
    }

    @Override
    public UserDevice createUserDevice(DeviceInfo deviceInfo) {
        return null;
    }

    @Override
    public void verifyRefreshAvailability(RefreshToken refreshToken) {

    }
}
