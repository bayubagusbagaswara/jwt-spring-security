package com.bayu.jwt.service;

import com.bayu.jwt.model.UserDevice;
import com.bayu.jwt.model.token.RefreshToken;
import com.bayu.jwt.payload.DeviceInfo;

import java.util.Optional;

public interface UserDeviceService {

    public Optional<UserDevice> findDeviceByUserId(Long userId, String deviceId);

    public Optional<UserDevice> findByRefreshToken(RefreshToken refreshToken);

    public UserDevice createUserDevice(DeviceInfo deviceInfo);

    public void verifyRefreshAvailability(RefreshToken refreshToken);

}
