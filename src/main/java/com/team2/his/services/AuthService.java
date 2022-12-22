package com.team2.his.services;

import com.team2.his.entitis.Account;
import com.team2.his.model.ResponseModel;
import com.team2.his.model.auth.RegisterRequest;

public interface AuthService {
    ResponseModel register(RegisterRequest request);
    Account getAccountInfoByLoginId(String loginId);
}
