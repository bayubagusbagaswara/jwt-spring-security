package com.bayu.jwt.service;

import com.bayu.jwt.model.CustomUserDetails;
import com.bayu.jwt.model.Role;
import com.bayu.jwt.model.User;
import com.bayu.jwt.payload.LogoutRequest;
import com.bayu.jwt.payload.RegistrationRequest;

import java.util.Optional;
import java.util.Set;

public interface UserService {

    public Optional<User> findByUsername(String username);

    public Optional<User> findByEmail(String email);

    public Optional<User> findById(Long id);

    public User save(User user);

    public Boolean existsByEmail(String email);

    public Boolean existsByUsername(String username);

    public User createUser(RegistrationRequest registrationRequest);

    public Set<Role> getRolesForNewUser(Boolean isToBeMadeAdmin);

    public void logoutUser(CustomUserDetails currentUser, LogoutRequest logoutRequest);

}
