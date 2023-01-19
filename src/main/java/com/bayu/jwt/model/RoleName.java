package com.bayu.jwt.model;

public enum RoleName {

    ROLE_ADMIN("ROLE ADMIN"),
    ROLE_USER("ROLE USER");

    private final String roleName;

    RoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }
}
