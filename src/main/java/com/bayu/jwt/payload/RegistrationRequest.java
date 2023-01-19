package com.bayu.jwt.payload;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder
public class RegistrationRequest {

    private String username;

    private String email;

    @NotNull(message = "Registration password cannot be null")
    private String password;

    @NotNull(message = "Specify whether the user has to be registered as an admin or nut")
    private Boolean registerAsAdmin;

    public RegistrationRequest(String username, String email, String password, Boolean registerAsAdmin) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.registerAsAdmin = registerAsAdmin;
    }
}
