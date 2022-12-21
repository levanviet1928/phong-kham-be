package com.team2.his.model.auth;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Data
public class LoginRequest {
    @NotBlank
    @NotEmpty(message = "User name cannot be null")
    private String loginId;

    @NotBlank
    @NotEmpty
    private String password;

    @NotBlank
    @NotEmpty(message = "device token cannot be null")
    private String deviceToken;
}
