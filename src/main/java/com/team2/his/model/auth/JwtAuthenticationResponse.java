package com.team2.his.model.auth;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.team2.his.entity.Account;
import lombok.Data;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Data
public class JwtAuthenticationResponse {
    private String accessToken;
    private String tokenType = "Bearer";
    private Account account;

    public JwtAuthenticationResponse(String accessToken, Account account) {
        this.accessToken = accessToken;
        this.account = account;

    }
}
