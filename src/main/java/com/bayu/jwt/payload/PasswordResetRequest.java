package com.bayu.jwt.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PasswordResetRequest {

    @NotBlank(message = "The email for which the password needs to be reset can not empty")
    private String email;

    @NotBlank(message = "New password cannot be blank")
    private String password;

    @NotBlank(message = "Confirm Password cannot be blank")
    private String confirmPassword;

    @NotBlank(message = "Password reset token for the specified email has to be supplied")
    private String token;
}
