package com.bayu.jwt.service.impl;

import com.bayu.jwt.exception.TokenRefreshException;
import com.bayu.jwt.model.User;
import com.bayu.jwt.model.UserDevice;
import com.bayu.jwt.model.token.RefreshToken;
import com.bayu.jwt.payload.DeviceInfo;
import com.bayu.jwt.repository.UserDeviceRepository;
import com.bayu.jwt.service.UserDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDeviceServiceImpl implements UserDeviceService {

    private final UserDeviceRepository userDeviceRepository;

    @Autowired
    public UserDeviceServiceImpl(UserDeviceRepository userDeviceRepository) {
        this.userDeviceRepository = userDeviceRepository;
    }

    @Override
    public Optional<UserDevice> findDeviceByUserId(Long userId, String deviceId) {
        return userDeviceRepository.findByUserIdAndDeviceId(userId, deviceId);
    }

    @Override
    public Optional<UserDevice> findByRefreshToken(RefreshToken refreshToken) {
        return userDeviceRepository.findByRefreshToken(refreshToken);
    }

    @Override
    public UserDevice createUserDevice(DeviceInfo deviceInfo) {
        UserDevice userDevice = new UserDevice();
        userDevice.setDeviceId(deviceInfo.getDeviceId());
        userDevice.setDeviceType(deviceInfo.getDeviceType());
        userDevice.setNotificationToken(deviceInfo.getNotificationToken());
        userDevice.setIsRefreshToken(true);
        return userDevice;
    }

    @Override
    public void verifyRefreshAvailability(RefreshToken refreshToken) {
        UserDevice userDevice = findByRefreshToken(refreshToken)
                .orElseThrow(() -> new TokenRefreshException(refreshToken.getToken(), "No device found for the matching token. Please login again"));

        if (!userDevice.getIsRefreshToken()) {
            throw new TokenRefreshException(refreshToken.getToken(), "Refresh blocked for the device. Please login through a different device");
        }
    }

}
