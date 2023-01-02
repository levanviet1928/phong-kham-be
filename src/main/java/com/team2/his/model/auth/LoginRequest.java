package com.team2.his.model.auth;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
public class LoginRequest {
    @NotBlank
    @NotEmpty(message = "User name cannot be null")
    private String userName;

    @NotBlank
    @NotEmpty
    private String password;
}
