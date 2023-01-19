package com.bayu.jwt.model;

public enum DeviceType {

    DEVICE_TYPE_ANDROID("DEVICE TYPE ANDROID"),
    DEVICE_TYPE_IOS("DEVICE TYPE IOS");

    private final String deviceTypeName;

    DeviceType(String deviceTypeName) {
        this.deviceTypeName = deviceTypeName;
    }

    public String getDeviceTypeName() {
        return deviceTypeName;
    }
}
