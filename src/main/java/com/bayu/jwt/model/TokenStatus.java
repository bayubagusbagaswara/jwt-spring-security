package com.bayu.jwt.model;

public enum TokenStatus {

    STATUS_PENDING("STATUS PENDING"),
    STATUS_CONFIRMED("STATUS CONFIRMED");

    private final String tokenStatusName;

    TokenStatus(String tokenStatusName) {
        this.tokenStatusName = tokenStatusName;
    }

    public String getTokenStatusName() {
        return tokenStatusName;
    }
}
