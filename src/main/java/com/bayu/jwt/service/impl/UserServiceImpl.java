package com.bayu.jwt.service.impl;

import com.bayu.jwt.exception.UserLogoutException;
import com.bayu.jwt.model.CustomUserDetails;
import com.bayu.jwt.model.Role;
import com.bayu.jwt.model.User;
import com.bayu.jwt.model.UserDevice;
import com.bayu.jwt.payload.LogoutRequest;
import com.bayu.jwt.payload.RegistrationRequest;
import com.bayu.jwt.repository.UserRepository;
import com.bayu.jwt.service.RefreshTokenService;
import com.bayu.jwt.service.RoleService;
import com.bayu.jwt.service.UserDeviceService;
import com.bayu.jwt.service.UserService;
import com.bayu.jwt.validation.annotation.CurrentUser;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final RoleService roleService;
    private final UserDeviceService userDeviceService;
    private final RefreshTokenService refreshTokenService;

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public Boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public User createUser(RegistrationRequest registrationRequest) {
        User newUser = new User();
        Boolean isNewUserAsAdmin = registrationRequest.getRegisterAsAdmin();
        newUser.setEmail(registrationRequest.getEmail());
        newUser.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
        newUser.setUsername(registrationRequest.getUsername());
        newUser.addRoles(getRolesForNewUser(isNewUserAsAdmin));
        newUser.setActive(true);
        newUser.setEmailVerified(false);

        return newUser;
    }

    @Override
    public Set<Role> getRolesForNewUser(Boolean isToBeMadeAdmin) {
        Set<Role> newUserRoles = new HashSet<>(roleService.findAll());
        if (!isToBeMadeAdmin) {
            newUserRoles.removeIf(Role::isAdminRole);
        }
        logger.info("Setting user roles: " + newUserRoles);
        return newUserRoles;
    }

    @Override
    public void logoutUser(@CurrentUser CustomUserDetails currentUser, LogoutRequest logoutRequest) {
        String deviceId = logoutRequest.getDeviceInfo().getDeviceId();
        UserDevice userDevice = userDeviceService
                .findDeviceByUserId(currentUser.getId(), deviceId)
                .filter(device -> device.getDeviceId().equals(deviceId))
                .orElseThrow(() -> new UserLogoutException(logoutRequest.getDeviceInfo().getDeviceId(), "Invalid device Id supplied. No matching device found for the given user "));

        logger.info("Removing refresh token associated with device [" + userDevice + "]");
        refreshTokenService.deleteById(userDevice.getRefreshToken().getId());
    }

}
