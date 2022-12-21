package com.team2.his.model.auth;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class RegisterRequest {
    @NotBlank
    @Size(min = 6, max = 20)
    private String password;
    @NotBlank
    private String lastName;
    @NotBlank
    private  String fistName;
    private String fullName;
    private String userName;
}
