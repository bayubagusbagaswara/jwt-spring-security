package com.bayu.jwt.service.impl;

import com.bayu.jwt.model.Role;
import com.bayu.jwt.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class RoleServiceImpl implements RoleService {

    @Override
    public Collection<Role> findAll() {
        return null;
    }
}
