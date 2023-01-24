package com.bayu.jwt.service.impl;

import com.bayu.jwt.model.CustomUserDetails;
import com.bayu.jwt.model.Role;
import com.bayu.jwt.model.User;
import com.bayu.jwt.payload.LogoutRequest;
import com.bayu.jwt.payload.RegistrationRequest;
import com.bayu.jwt.repository.UserRepository;
import com.bayu.jwt.service.RefreshTokenService;
import com.bayu.jwt.service.RoleService;
import com.bayu.jwt.service.UserDeviceService;
import com.bayu.jwt.service.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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
        return Optional.empty();
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public Boolean existsByEmail(String email) {
        return null;
    }

    @Override
    public Boolean existsByUsername(String username) {
        return null;
    }

    @Override
    public User createUser(RegistrationRequest registrationRequest) {
        return null;
    }

    @Override
    public Set<Role> getRolesForNewUser(Boolean isToBeMadeAdmin) {
        return null;
    }

    @Override
    public void logoutUser(CustomUserDetails currentUser, LogoutRequest logoutRequest) {

    }
}
